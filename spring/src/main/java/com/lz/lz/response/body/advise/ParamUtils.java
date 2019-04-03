package com.lz.lz.response.body.advise;

import com.gennlife.platform.bean.ResultBean;
import com.gennlife.platform.service.ConfigurationService;
import com.gennlife.platform.view.View;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.net.URLEncoder;

/**
 * Created by chensong on 2015/12/9.
 */
public class ParamUtils {
    private static Logger logger = LoggerFactory.getLogger(ParamUtils.class);
    private static Gson gson = GsonUtil.getGson();
    private static View viewer = new View();

    public static String getParam(HttpServletRequest request) {
        String param = null;
        if ("GET".equals(request.getMethod())) {
            param = request.getParameter("param");
        } else {
            param = getPostParm(request);
        }
        return cleanXSS(param);
    }

    private static String getPostParm(HttpServletRequest request) {
        StringBuffer jb = new StringBuffer();
        String line = null;
        BufferedReader reader = null;
        try {
            reader = request.getReader();
            if (!reader.ready()) return jb.toString();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (IllegalStateException e){
            logger.error("getReader 被调用了两次的原因么" );
        } catch (Exception e) {
            logger.error("读取请求参数出错", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    logger.error("", e);
                }
            }
        }
        return jb.toString();
    }


    public static String encodeURI(String uri) {
        try {
            return URLEncoder.encode(uri, "UTF-8");
        } catch (Exception e) {
            return uri;
        }
    }

    public static int[] parseLimit(String limit) {
        String[] strings = limit.split(",");
        int[] result = new int[2];
        result[0] = Integer.parseInt(strings[0]);
        result[1] = Integer.parseInt(strings[1]);
        return result;
    }

    private static String cleanXSS(String value) {
        if (value == null) {
            return null;
        }
        value = value.replaceAll("eval", "");
        value = value.replaceAll("<script>", "");
        value = value.replaceAll("<javascript>", "");
        return value;
    }

    public static void errorParam(HttpServletRequest request, HttpServletResponse resps) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(getErrorCode());
        resultBean.setInfo("请求参数出错");
        viewer.viewString(gson.toJson(resultBean), resps, request);
        return;
    }

    public static int getErrorCode() {
        return 0;
    }

    public static int getSuccessCode() {
        return 1;
    }

    public static String getDataKey() {
        return "info";
    }

    public static void errorParam(String info, HttpServletRequest req, HttpServletResponse resp) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(getErrorCode());
        resultBean.setInfo(info);
        String data = gson.toJson(resultBean);
        viewer.viewString(data, resp, req);
    }

    public static String errorParam(String info) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(getErrorCode());
        resultBean.setInfo(info);
        JsonObject json = gson.toJsonTree(resultBean).getAsJsonObject();
        json.addProperty("success", false);
        return gson.toJson(json);

    }
    public static String errorParamWithRedirect(String info,String redirectUrl) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(getErrorCode());
        resultBean.setInfo(info);
        JsonObject json = gson.toJsonTree(resultBean).getAsJsonObject();
        json.addProperty("success", false);
        json.addProperty("errorRedirectUrl", redirectUrl);
        return gson.toJson(json);

    }

    public static String errorAuthorityParam() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(-2);
        String info = "没有权限";
        resultBean.setInfo(info);
        return gson.toJson(resultBean);
    }

    public static JsonArray indexNameTranformUIName(JsonArray array) {
        JsonArray jsonArray = new JsonArray();
        for (JsonElement indexNameElement : array) {
            String indexName = indexNameElement.getAsString();
            String uiName = ConfigurationService.getUIFieldName(indexName);
            jsonArray.add(uiName);
        }
        return jsonArray;
    }

    public static ResultBean errorParamResultBean(String info) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(getErrorCode());
        resultBean.setInfo(info);
        return resultBean;
    }

    public static String errorSessionLosParam() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(-1);
        resultBean.setInfo("session失效");
        return gson.toJson(resultBean);
    }

    public static String getStatusKey() {
        return "code";
    }

    public static String errorPermission() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(-2);
        resultBean.setInfo("账户失效，请联系管理员");
        return gson.toJson(resultBean);
    }
}
