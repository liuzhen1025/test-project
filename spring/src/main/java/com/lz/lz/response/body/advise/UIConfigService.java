/**
 * copyRight
 */
package com.lz.lz.response.body.advise;

import com.gennlife.platform.dao.UIConfigMapper;
import com.gennlife.platform.util.GsonUtil;
import com.gennlife.platform.util.RedisUtil;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhen
 *         Created by liuzhen.
 *         Date: 2019/3/27
 *         Time: 14:15
 */
@Service
public class UIConfigService {

    @Autowired
    private UIConfigMapper configMapper;
    private static Gson gson = GsonUtil.getGson();

    public UIConfig selectByUuidAndStatus(String configUUId, int status) {
        Map<String, Object> param = new HashMap<>();
        param.put("configUuid", configUUId);
        param.put("status", status);
        String value = RedisUtil.getValue(configUUId);
        if (StringUtils.isEmpty(value)) {
            UIConfig uiConfig = getUiConfig(param);
            if (uiConfig == null) {
                return null;
            }
            return uiConfig;
        } else {
            try {
                JsonReader jsonReader = new JsonReader(new StringReader(value));
                jsonReader.setLenient(true);
                UIConfig uiConfig = gson.fromJson(jsonReader, UIConfig.class);
                return uiConfig;
            } catch (Exception e) {
                return null;
            }
        }

    }

    private UIConfig getUiConfig(Map<String, Object> param) {

        UIConfig uiConfig = configMapper.selectByUuidAndStatus(param);
        if (uiConfig == null) {
            return null;
        }
        String s = gson.toJson(uiConfig);
        RedisUtil.setValue(uiConfig.getConfigUuid(), s);
        return uiConfig;
    }

    public int updateBySelected(UIConfig uiConfig) {

        int i = configMapper.updateBySelected(uiConfig);
        RedisUtil.deleteKey(uiConfig.getConfigUuid());
        return i;
    }

    public int insert(UIConfig uiConfig) {

        int insert = configMapper.insert(uiConfig);
        return insert;
    }
}
