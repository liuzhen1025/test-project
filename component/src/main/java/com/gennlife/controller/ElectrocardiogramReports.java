/**
 * copyRight
 */
package com.gennlife.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2019/2/14
 * Time: 18:02
 */
@RestController
@RequestMapping("/component")
public class ElectrocardiogramReports {
    private String diogramReports = "{\"electrocardiogram_reports\":[{\"EXAMINATION_SN\":\"20171108137\",\"REPORT_DATE\":\"2017-11-20 08:35:00\",\"P_ELECTTRIC_AXIS\":57,\"SEX\":\"男\",\"QRS_PEROID\":106,\"P_WAVEFORM\":\"104.0\",\"T_ELECTTRIC_AXIS\":47,\"QRS_ELECTTRIC_AXIS\":56,\"APPLY_SN\":\"382957\",\"QT_PEROID\":390,\"QRS_WAVEFORM\":\"106.0\",\"AGE\":30,\"VISIT_TYPE\":\"0\",\"QTc_PEROID\":405,\"HEART_RATE\":65,\"ECG_EXAMINATION_TYPE\":\"常规心电图检查\",\"REPORT_PHYSICIAN\":\"王曾乐\",\"ECG_DIAGNOSTIC_OPINION\":\"1.窦性心律\\n2.正常范围心电图\",\"SV2\":29999.0,\"SV1\":0.62,\"T_WAVEFORM\":\"221.0\",\"RV5\":2.0,\"RV6\":29999.0,\"VISIT_SN\":\"vis_da1b959f23eedd7e6e0425ec2745a40d\",\"PR_PERIOD\":159,\"PATIENT_SN\":\"pat_d4faf1c7b7c7fd7af7fdef6b594f60cd\"}],\"success\":true,\"fstook\":\"54ms\"}";
    private String diogramReports_config="";
    private String diagnose = "{\"diagnose\":[{\"DIAGNOSIS\":\"恶性淋巴瘤个人史\",\"DIAGNOSIS_TYPE\":\"门诊诊断\",\"DIAGNOSTIC_DEPT_ID\":\"207\",\"VISIT_SN\":\"vis_0569476127a287443ebd9575a21f9365\",\"DIAGNOSTIC_DATE\":\"2017-11-20 14:07:00\",\"PATIENT_SN\":\"pat_d4faf1c7b7c7fd7af7fdef6b594f60cd\",\"DIAGNOSTIC_DEPT\":\"内科\",\"MAIN_DIAGNOSIS_FLAG\":true,\"VISIT_TYPE\":\"0\"}],\"success\":true,\"fstook\":\"105ms\"}";
    private String diagnose_config="{\n" +
            "  \"style\": \"Table\",\n" +
            "  \"data\": \"diagnose\",\n" +
            "  \"serialNumber\": true,\n" +
            "  \"tableHeight\": \"middle\",\n" +
            "  \"tableName\": \"诊断\",\n" +
            "  \"align\": \"center\",\n" +
            "  \"isStatus\": true,\n" +
            "  \"operationOptions\": {\n" +
            "    \"isShow\": true,\n" +
            "    \"isShowEdit\": true,\n" +
            "    \"isShowDelete\": true\n" +
            "  },\n" +
            "  \"isCheck\": true,\n" +
            "  \"selectedState\": \"checkbox\",\n" +
            "  \"notEdit\": \"notEdit\",\n" +
            "  \"notDelete\": \"notDelete\",\n" +
            "  \"tableConfigure\": {\n" +
            "    \"title\": false,\n" +
            "    \"showHeader\": true,\n" +
            "    \"footer\": false,\n" +
            "    \"hasData\": true,\n" +
            "    \"bordered\": true\n" +
            "  },\n" +
            "  \"pagination\": {\n" +
            "    \"isShow\": true,\n" +
            "    \"position\": \"bottom\",\n" +
            "    \"showQuickJumper\": true,\n" +
            "    \"showSizeChanger\": true,\n" +
            "    \"isShowTotal\": true,\n" +
            "    \"defaultCurrent\": 1\n" +
            "  },\n" +
            "  \"config\": {\n" +
            "    \"columns\": {\n" +
            "      \"PATIENT_SN\": {\n" +
            "        \"PATIENT_SN\": \"患者编号\",\n" +
            "        \"OrderType\": true,\n" +
            "        \"highLight\": true,\n" +
            "        \"multiBlockDisplay\": false,\n" +
            "        \"isFilter\": true,\n" +
            "        \"linkUrl\": \"http://aa/b/c/d/e?\",\n" +
            "        \"linkUrlParam\": [\n" +
            "          {\n" +
            "            \"pat_sn\": \"data.pat_sn\",\n" +
            "            \"sex\": \"data.sex\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"DIAGNOSIS\": {\n" +
            "        \"DIAGNOSIS\": \"诊断名称\",\n" +
            "        \"OrderType\": true,\n" +
            "        \"highLight\": true,\n" +
            "        \"multiBlockDisplay\": false,\n" +
            "        \"isFilter\": true,\n" +
            "        \"linkUrl\": \"http://aa/b/c/d/e?\",\n" +
            "        \"linkUrlParam\": [\n" +
            "          {\n" +
            "            \"pat_sn\": \"data.pat_sn\",\n" +
            "            \"sex\": \"data.sex\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"DIAGNOSTIC_DEPT\": {\n" +
            "        \"DIAGNOSTIC_DEPT\": \"诊断科室\",\n" +
            "        \"OrderType\": true,\n" +
            "        \"highLight\": false,\n" +
            "        \"multiBlockDisplay\": false,\n" +
            "        \"linkUrl\": \"http://aa/b/c/d?\",\n" +
            "        \"linkUrlParam\": [\n" +
            "          {\n" +
            "            \"pat_sn\": \"data.pat_sn\",\n" +
            "            \"sex\": \"data.sex\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"DIAGNOSIS_CODE\": {\n" +
            "        \"DIAGNOSIS_CODE\": \"诊断编码\",\n" +
            "        \"OrderType\": false,\n" +
            "        \"highLight\": false,\n" +
            "        \"multiBlockDisplay\": false\n" +
            "      },\n" +
            "      \"DIAGNOSIS_TYPE\": {\n" +
            "        \"DIAGNOSIS_TYPE\": \"诊断类别\",\n" +
            "        \"OrderType\": false,\n" +
            "        \"highLight\": false,\n" +
            "        \"multiBlockDisplay\": false\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}\n";
    @RequestMapping("/electrocardiogram_reports")
    public String electrocardiogram_reports(){
        JSONObject object1 = JSONObject.parseObject(diogramReports);
        JSONObject object2 = JSONObject.parseObject(diogramReports_config);
        return getResult(object1, object2);
    }
    private String getResult(JSONObject data, JSONObject config) {

        JSONObject object = new JSONObject();
        object.put("status",200);
        object.put("message","成功");
        object.put("data",data);
        object.put("config",config);
        return object.toJSONString();
    }

    @RequestMapping("/lab_result_item")
    public String labResult(){
        JSONObject config = JSONObject.parseObject(diagnose_config);
        JSONObject data = JSONObject.parseObject(diagnose);
        return getResult(data, config);
    }
}
