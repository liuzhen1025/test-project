/**
 * copyRight
 */
package com.gennlife.json.path;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuzhen
 *         Created by liuzhen.
 *         Date: 2018/3/13
 *         Time: 14:10
 */
public class MathCalculate extends BaseMathCalculate {
    private static Logger logger = LoggerFactory.getLogger(MathCalculate.class);
    private JSONObject visits;
    private GroupSplitService groupSplit = new GroupSplitServiceImpl();

    public MathCalculate(JSONObject visits) {
        this.visits = visits;
    }

    /**
     * 计算单次就诊是否满足条件
     * @param array      检索条件(所有的跨就诊条件)
     * @param itemRelase 全局变量用于获取组英文名称
     * @return
     */
    public String calc(JSONArray array, ConcurrentHashMap<String, String> itemRelase) {
        logger.info("receive condition {}",array.toJSONString());
        if (array == null || array.isEmpty()) {
            return "";
        }
        int size = array.size();
        boolean isInSameVisits = true;
        String visistSN = "";
        for (int i = 0; i < size; i++) {
            JSONObject json = array.getJSONObject(i);

            //一个跨就诊条件组
            JSONArray collection = json.getJSONArray("collection");
            if (JsonUtils.isEmptyArray(collection)) {
                continue;
            }
            int collectionSize = collection.size();
            boolean isMatch = false;
            for (int j = 0; j < collectionSize; j++) {
                JSONObject coll = collection.getJSONObject(j);
                if (JsonUtils.isEmptyJSON(coll, "srchRelationValue", "uiItem", "srchRelation")) {
                    continue;
                }
                String dataType = coll.getString("dataType");
                String srchRelationValue = coll.getString("srchRelationValue");
                String srchRelation = coll.getString("srchRelation");
                String dateFormat = coll.getString("dateFormat");
                //过滤掉患者基本信息
                if(StringUtils.containsIgnoreCase(coll.getString("uiItem"),"患者基本信息")){
                    break;
                }
                String uiItemEN = getUiItemEn(itemRelase, coll);
                int countMatch = groupSplit.getCountMatch(uiItemEN, ".");
                //适用uiItemEN为 aa.bb.cc
                //组名
                String firstGroupName = groupSplit.getFirstGroup(uiItemEN, ".");
                //属性名
                String attribute = groupSplit.getEndGroup(uiItemEN, ".");
                JSONArray groupArray = visits.getJSONArray(firstGroupName);
                //处理有子项的部分,强关联,此部分未作递归，以后改造
                if (countMatch == 2) {
                    String secondGroupName = groupSplit.getSecondGroup(uiItemEN, ".", ".");
                    if(!JsonUtils.isEmptyArray(groupArray)){
                        int firstLen = groupArray.size();
                        for (int q = 0;q<firstLen; q++) {
                            JSONObject firstItem = groupArray.getJSONObject(q);
                            visistSN = firstItem.getString("VISIT_SN");
                            JSONArray senordGroupArray = firstItem.getJSONArray(secondGroupName);
                            if(!JsonUtils.isEmptyArray(senordGroupArray)){
                                int sencondGroupSize = senordGroupArray.size();
                                for (int h = 0; h < sencondGroupSize; h++) {
                                    JSONObject secondItem = senordGroupArray.getJSONObject(h);
                                    String value = secondItem.getString(attribute);
                                    isMatch = match(dataType,value,srchRelationValue,srchRelation,dateFormat);
                                    if(isMatch){
                                        //子项match，强关联
                                        JSONArray relatedItems = coll.getJSONArray("relatedItems");
                                        if(!JsonUtils.isEmptyArray(relatedItems)){
                                            int relateSize = relatedItems.size();
                                            for(int t = 0; t < relateSize; t++){
                                                JSONObject colls = relatedItems.getJSONObject(t);
                                                if (JsonUtils.isEmptyJSON(colls, "srchRelationValue", "uiItem", "srchRelation")) {
                                                    continue;
                                                }
                                                String innerDataType = colls.getString("dataType");
                                                String innerSrchRelationValue = colls.getString("srchRelationValue");
                                                String innerSrchRelation = colls.getString("srchRelation");
                                                String innerDateFormat = colls.getString("dateFormat");
                                                String innerUiItemEN = getUiItemEn(itemRelase, colls);
                                                //属性名
                                                String innerAttribute = groupSplit.getEndGroup(innerUiItemEN, ".");
                                                String senondValue = secondItem.getString(innerAttribute);
                                                isMatch = match(innerDataType,senondValue,innerSrchRelationValue,innerSrchRelation,innerDateFormat);
                                                //强关联判断，条件内，有一项不符合，即可舍弃
                                                if(!isMatch){
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    //只要有一次匹配到一个条件项即认为当前就诊时符合跨就诊条件要求的
                                    if(isMatch){
                                        break;
                                    }
                                }
                            }
                            //匹配到一个条件项即认为当前就诊时符合跨就诊条件要求的
                            if(isMatch){
                                break;
                            }
                        }
                    }
                } else {
                    //组值
                    if (!JsonUtils.isEmptyArray(groupArray)) {
                        int groupSize = groupArray.size();
                        for (int k = 0; k < groupSize; k++) {
                            JSONObject groupItem = groupArray.getJSONObject(k);
                            String attributeValue = groupItem.getString(attribute);
                            visistSN = groupItem.getString("VISIT_SN");
                            isMatch = match(dataType,attributeValue,srchRelationValue,srchRelation,dateFormat);
                            //当前跨就诊条件组内只要有一个条件不符合，即为该次就诊不符合该条件组
                            if(isMatch){
                                break;
                            }
                        }
                    }
                }
                //只要有一个条件不符合，就认为本次就诊不符合条件定义
                if(!isMatch){
                    break;
                }
            }
            if(isMatch){
               return visistSN;
            }
        }
        return "";
    }

    public boolean match(String dataType,String sourceValue,String targetValue,String srchRelation,String format){
        boolean result = false;
        //字符串类型
        if (StringUtils.equalsIgnoreCase(dataType,CommonContent.CALC_UNIT_STR)) {
            //包含
            if(StringUtils.equalsIgnoreCase(srchRelation,CommonContent.RELATION_CONTAIN)){
                result = super.isContains(sourceValue,targetValue);
            }else{
                result = !super.isContains(sourceValue,targetValue);
            }
        }else if(StringUtils.equalsIgnoreCase(dataType,CommonContent.CALC_UNIT_DATE)){
            if (StringUtils.equalsIgnoreCase(srchRelation,CommonContent.RELATION_BEGIN_TO)) {
                String firstTime = groupSplit.getFirstGroup(targetValue, ",");
                String endTime = groupSplit.getEndGroup(targetValue, ",");
                result = DateUtils.betten(DateUtils.getDate(sourceValue,format), DateUtils.getDate(firstTime,format), DateUtils.getDate(endTime,format));
            }else if(StringUtils.equalsIgnoreCase(srchRelation,CommonContent.RELATION_BEFORE)){
                result = DateUtils.before(DateUtils.getDate(sourceValue,format), DateUtils.getDate(targetValue,format));
            }else if(StringUtils.equalsIgnoreCase(srchRelation,CommonContent.RELATION_AFTER)){
                result = DateUtils.after(DateUtils.getDate(sourceValue,format), DateUtils.getDate(targetValue,format));
            }
        }else if (StringUtils.equalsIgnoreCase(dataType,CommonContent.CALC_UNIT_LONG) || StringUtils.equalsIgnoreCase(dataType,CommonContent.CALC_UNIT_DOUBLE)) {
            if(StringUtils.equalsIgnoreCase(srchRelation,CommonContent.RELATION_EQUAL)){
                result = NumberUtils.equals(sourceValue,targetValue);
            }else if(StringUtils.equalsIgnoreCase(srchRelation,CommonContent.RELATION_LESSTHEN)){
                result = NumberUtils.lessThan(sourceValue,targetValue);
            }else if(StringUtils.equalsIgnoreCase(srchRelation,CommonContent.RELATION_LESSTHENEQUAL)){
                result = NumberUtils.lessThanEquals(sourceValue,targetValue);
            }else if(StringUtils.equalsIgnoreCase(srchRelation,CommonContent.RELATION_GREATERTHEN)){
                result = NumberUtils.greaterThan(sourceValue,targetValue);
            }else if(StringUtils.equalsIgnoreCase(srchRelation,CommonContent.RELATION_GREATERTHENEQUAL)){
                result = NumberUtils.greaterThanEqusls(sourceValue,targetValue);
            }
        }

        return result;
    }


    private String getUiItemEn(ConcurrentHashMap<String, String> itemRelase, JSONObject json) {
        String uiItem = json.getString("uiItem");
        String uiItemEn = itemRelase.get(uiItem);
        if (StringUtils.isEmpty(uiItemEn)) {
            uiItemEn = uiItem;//网络请求获取
            itemRelase.put(uiItem, uiItemEn);
        }
        return groupSplit.getAfterFirstSpliteGroup(uiItemEn, ".");
    }

}

/**
 * //visist后第一级
 JSONArray groupArray = visits.getJSONArray(firstGroupName);
 //子项属性名
 groupSplit.getThirdGroup(uiItemEN,".",".");
 if (!JsonUtils.isEmptyArray(groupArray)) {
 int groupSize = groupArray.size();
 for (int k = 0; k < groupSize; k++) {
 JSONObject groupItem = groupArray.getJSONObject(k);
 String attributeValue = groupItem.getString(attribute);
 visistSN = groupItem.getString("VISIT_SN");
 isMatch = match(dataType,attributeValue,srchRelationValue,srchRelation,dateFormat);
 if(isMatch){
 String secondGroupName = groupSplit.getSecondGroup(uiItemEN, ".", ".");
 //子项条件
 JSONArray relatedItems = coll.getJSONArray("relatedItems");
 //获取子项json值
 JSONArray secondGroupValue = groupItem.getJSONArray(secondGroupName);
 boolean innerIsMatch = false;
 if(!JsonUtils.isEmptyArray(relatedItems)){
 int realeteItemsSize = relatedItems.size();
 for (int u = 0; u<realeteItemsSize; u++) {
 JSONObject relateCondition = relatedItems.getJSONObject(u);
 dataType = relateCondition.getString("dataType");
 srchRelationValue = relateCondition.getString("srchRelationValue");
 srchRelation = relateCondition.getString("srchRelation");
 dateFormat = relateCondition.getString("dateFormat");
 uiItemEN = getUiItemEn(itemRelase, relateCondition);
 //属性名
 attribute = groupSplit.getEndGroup(uiItemEN, ".");
 if(JsonUtils.isEmptyArray(secondGroupValue)){
 int secondGroupSize = secondGroupValue.size();
 for (int y=0; y<secondGroupSize; y++) {
 JSONObject jsonObject = secondGroupValue.getJSONObject(i);
 attributeValue = jsonObject.getString(attribute);
 innerIsMatch = match(dataType,attributeValue,srchRelationValue,srchRelation,dateFormat);
 if(innerIsMatch){
 break;
 }
 }
 }
 }
 }
 isMatch = innerIsMatch;
 }
 }
 }*/
