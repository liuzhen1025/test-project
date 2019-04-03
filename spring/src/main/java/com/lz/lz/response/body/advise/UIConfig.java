/**
 * copyRight
 */
package com.lz.lz.response.body.advise;

import java.io.Serializable;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2019/3/27
 * Time: 11:01
 */
public class UIConfig implements Serializable {
    private Long id;
    private String interfaceName;
    private String uri;
    private String frontConfigInfo;
    private String backendConfigInfo;
    private String bussName;
    private String serviceName;
    private String configUuid;
    private String mark;
    private Integer status;
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getInterfaceName() {

        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {

        this.interfaceName = interfaceName;
    }

    public String getUri() {

        return uri;
    }

    public void setUri(String uri) {

        this.uri = uri;
    }

    public String getFrontConfigInfo() {

        return frontConfigInfo;
    }

    public void setFrontConfigInfo(String frontConfigInfo) {

        this.frontConfigInfo = frontConfigInfo;
    }

    public String getBackendConfigInfo() {

        return backendConfigInfo;
    }

    public void setBackendConfigInfo(String backendConfigInfo) {

        this.backendConfigInfo = backendConfigInfo;
    }

    public String getBussName() {

        return bussName;
    }

    public void setBussName(String bussName) {

        this.bussName = bussName;
    }

    public String getServiceName() {

        return serviceName;
    }

    public void setServiceName(String serviceName) {

        this.serviceName = serviceName;
    }

    public String getConfigUuid() {

        return configUuid;
    }

    public void setConfigUuid(String configUuid) {

        this.configUuid = configUuid;
    }

    public String getMark() {

        return mark;
    }

    public void setMark(String mark) {

        this.mark = mark;
    }

    public Integer getStatus() {

        return status;
    }

    public void setStatus(Integer status) {

        this.status = status;
    }
}
