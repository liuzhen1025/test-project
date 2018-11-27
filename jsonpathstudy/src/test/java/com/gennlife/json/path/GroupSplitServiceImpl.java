/**
 * copyRight
 */
package com.gennlife.json.path;

import org.apache.commons.lang3.StringUtils;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/3/13
 * Time: 10:12
 */
public class GroupSplitServiceImpl implements GroupSplitService {
    public String getFirstGroup(String groups, String splitChar) {
        return StringUtils.substringBefore(groups,splitChar);
    }

    public String getSecondGroup(String groups, String open, String close) {
        return StringUtils.substringBetween(groups,open,close);
    }

    public String getThirdGroup(String groups, String open, String close) {
        return StringUtils.substringBetween(groups,open,close);
    }

    public String getEndGroup(String groups, String splitChar) {
        return StringUtils.substringAfterLast(groups,splitChar);
    }

    public String getBeforeLastSpliteGroup(String groups, String splitChar) {
        return StringUtils.substringBeforeLast(groups,splitChar);
    }

    public String getAfterFirstSpliteGroup(String groups, String splitChar) {
        return StringUtils.substringAfter(groups,".");
    }

    public int getCountMatch(String groups, String splitChar) {
        return StringUtils.countMatches(groups,splitChar);
    }


}
