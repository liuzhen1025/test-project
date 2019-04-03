/**
 * copyRight
 */
package com.lz.lz.response.body.advise;

import com.gennlife.platform.model.UIConfig;
import com.gennlife.platform.util.JsonUtils;
import com.google.gson.JsonObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2019/3/25
 * Time: 18:20
 */
@Configuration
@ControllerAdvice
public class ResponseBodyAdvices implements ResponseBodyAdvice<Object> {
    private static int CONFIGSTATUS = 1;
    /*@Autowired
    private UIConfigService uiConfigService;*/
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        ResponseBody methodAnnotation = methodParameter.getMethodAnnotation(ResponseBody.class);
        RestController annotation = methodParameter.getDeclaringClass().getAnnotation(RestController.class);
        boolean hasAnnotation = methodAnnotation == null && annotation == null;
        /**
         * 当调用的方法 没有ResponseBody注解或 方法所属类没有 RestController 注解时
         * 表示此调用返回的值不是字符串，此时不需要经过任何处理，
         * ResponseBodyAdvice 本身就是拦截这两个注解的，但是为了避免出现意外故增加此
         * 判断
         */
        if(hasAnnotation || body == null){
            return body;
        }
        if(body instanceof String){
            String value = (String) body;
            JsonObject jsonObject = JsonUtils.getJsonObject(value);
            if(jsonObject != null){
                ServletServerHttpRequest request = (ServletServerHttpRequest) serverHttpRequest;
                HttpServletRequest servletRequest = request.getServletRequest();
                String configUuid = getCofigUuid(servletRequest);
                UIConfig uiConfig = uiConfigService.selectByUuidAndStatus(configUuid, CONFIGSTATUS);
                if(uiConfig!=null){
                    jsonObject.addProperty("config",JsonUtils.toJsonElement(uiConfig).getAsString());
                }
                return jsonObject.toString();
            }
        }
        return body;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }
    private String getCofigUuid(HttpServletRequest request){
        String configUuid = request.getParameter("configUuid");
        if(StringUtils.isNotEmpty(configUuid)){
            return  configUuid;
        }else {
            String param = ParamUtils.getParam(request);
            JsonObject jsonObject = JsonUtils.getJsonObject(param);
            if(jsonObject == null){
                return null;
            }else if(jsonObject.has("configUuid")){
                return jsonObject.get("configUuid").getAsString();
            }
            return null;
        }
    }
}
