/**
 * copyRight
 */
package com.gennlife.json.path;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/3/13
 * Time: 10:12
 */
public interface GroupSplitService {
    /**
     * 获取分隔符前一个字符串 visits
     * @param groups  格式类似 visits.operation_records.OPERATION_DATE
     * @param splitChar 分割符
     * @return
     */
    String getFirstGroup(String groups,String splitChar);
    /**
     * 获取两个分割符之间的字符串operation_records
     * @param groups  格式类似 visits.operation_records.OPERATION_DATE
     * @param open 第一个分割符
     * @param close 第二个分割符
     * @return
     */
    String getSecondGroup(String groups,String open,String close);
    /**
     *获取两个分割符之间的字符串operation_records
     * @param groups  格式类似 visits.operation_records.OPERATION_DATE
     * @param open 第一个分割符
     * @param close 第二个分割符
     * @return
     */
    String getThirdGroup(String groups,String open,String close);
    /**
     * 获取字符串中最后一个分隔符之后的字符串 OPERATION_DATE
     * @param groups  格式类似 visits.operation_records.OPERATION_DATE
     * @param splitChar 分割符
     * @return
     */
    String getEndGroup(String groups,String splitChar);
    /**
     * 获取字符串中最后一个分隔符之前的字符串 visits.operation_records
     * @param groups  格式类似 visits.operation_records.OPERATION_DATE
     * @param splitChar 分割符
     * @return
     */
    String getBeforeLastSpliteGroup(String groups,String splitChar);
    /**
     * 获取字符串中最后一个分隔符之前的字符串 visits.operation_records
     * @param groups  格式类似 visits.operation_records.OPERATION_DATE
     * @param splitChar 分割符
     * @return
     */
    String getAfterFirstSpliteGroup(String groups,String splitChar);
    /**
     * 获取字符串中某个字符的个数
     * @param groups  格式类似 visits.operation_records.OPERATION_DATE
     * @param splitChar 分割符
     * @return
     */
    int getCountMatch(String groups,String splitChar);
}
