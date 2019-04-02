
package mypackage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mypackage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ValidUserToke_QNAME = new QName("http://services.ws.common.idm.yonyou/", "validUserToke");
    private final static QName _CheckClientUserAccessPermission_QNAME = new QName("http://services.ws.common.idm.yonyou/", "checkClientUserAccessPermission");
    private final static QName _UserAuthLog_QNAME = new QName("http://services.ws.common.idm.yonyou/", "userAuthLog");
    private final static QName _VerifyUserLoginResponse_QNAME = new QName("http://services.ws.common.idm.yonyou/", "verifyUserLoginResponse");
    private final static QName _ValidUserTokeResponse_QNAME = new QName("http://services.ws.common.idm.yonyou/", "validUserTokeResponse");
    private final static QName _CheckClientUserAccessPermissionResponse_QNAME = new QName("http://services.ws.common.idm.yonyou/", "checkClientUserAccessPermissionResponse");
    private final static QName _VerifyUserAndPassResponse_QNAME = new QName("http://services.ws.common.idm.yonyou/", "verifyUserAndPassResponse");
    private final static QName _VerifyUserLogin_QNAME = new QName("http://services.ws.common.idm.yonyou/", "verifyUserLogin");
    private final static QName _GenerateUserToke_QNAME = new QName("http://services.ws.common.idm.yonyou/", "generateUserToke");
    private final static QName _UserAuthLogResponse_QNAME = new QName("http://services.ws.common.idm.yonyou/", "userAuthLogResponse");
    private final static QName _GenerateUserTokeResponse_QNAME = new QName("http://services.ws.common.idm.yonyou/", "generateUserTokeResponse");
    private final static QName _VerifyUserAndPass_QNAME = new QName("http://services.ws.common.idm.yonyou/", "verifyUserAndPass");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VerifyUserAndPass }
     * 
     */
    public VerifyUserAndPass createVerifyUserAndPass() {
        return new VerifyUserAndPass();
    }

    /**
     * Create an instance of {@link GenerateUserTokeResponse }
     * 
     */
    public GenerateUserTokeResponse createGenerateUserTokeResponse() {
        return new GenerateUserTokeResponse();
    }

    /**
     * Create an instance of {@link GenerateUserToke }
     * 
     */
    public GenerateUserToke createGenerateUserToke() {
        return new GenerateUserToke();
    }

    /**
     * Create an instance of {@link UserAuthLogResponse }
     * 
     */
    public UserAuthLogResponse createUserAuthLogResponse() {
        return new UserAuthLogResponse();
    }

    /**
     * Create an instance of {@link ValidUserTokeResponse }
     * 
     */
    public ValidUserTokeResponse createValidUserTokeResponse() {
        return new ValidUserTokeResponse();
    }

    /**
     * Create an instance of {@link CheckClientUserAccessPermission }
     * 
     */
    public CheckClientUserAccessPermission createCheckClientUserAccessPermission() {
        return new CheckClientUserAccessPermission();
    }

    /**
     * Create an instance of {@link UserAuthLog }
     * 
     */
    public UserAuthLog createUserAuthLog() {
        return new UserAuthLog();
    }

    /**
     * Create an instance of {@link VerifyUserLoginResponse }
     * 
     */
    public VerifyUserLoginResponse createVerifyUserLoginResponse() {
        return new VerifyUserLoginResponse();
    }

    /**
     * Create an instance of {@link VerifyUserLogin }
     * 
     */
    public VerifyUserLogin createVerifyUserLogin() {
        return new VerifyUserLogin();
    }

    /**
     * Create an instance of {@link CheckClientUserAccessPermissionResponse }
     * 
     */
    public CheckClientUserAccessPermissionResponse createCheckClientUserAccessPermissionResponse() {
        return new CheckClientUserAccessPermissionResponse();
    }

    /**
     * Create an instance of {@link VerifyUserAndPassResponse }
     * 
     */
    public VerifyUserAndPassResponse createVerifyUserAndPassResponse() {
        return new VerifyUserAndPassResponse();
    }

    /**
     * Create an instance of {@link ValidUserToke }
     * 
     */
    public ValidUserToke createValidUserToke() {
        return new ValidUserToke();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidUserToke }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ws.common.idm.yonyou/", name = "validUserToke")
    public JAXBElement<ValidUserToke> createValidUserToke(ValidUserToke value) {
        return new JAXBElement<ValidUserToke>(_ValidUserToke_QNAME, ValidUserToke.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckClientUserAccessPermission }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ws.common.idm.yonyou/", name = "checkClientUserAccessPermission")
    public JAXBElement<CheckClientUserAccessPermission> createCheckClientUserAccessPermission(CheckClientUserAccessPermission value) {
        return new JAXBElement<CheckClientUserAccessPermission>(_CheckClientUserAccessPermission_QNAME, CheckClientUserAccessPermission.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAuthLog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ws.common.idm.yonyou/", name = "userAuthLog")
    public JAXBElement<UserAuthLog> createUserAuthLog(UserAuthLog value) {
        return new JAXBElement<UserAuthLog>(_UserAuthLog_QNAME, UserAuthLog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyUserLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ws.common.idm.yonyou/", name = "verifyUserLoginResponse")
    public JAXBElement<VerifyUserLoginResponse> createVerifyUserLoginResponse(VerifyUserLoginResponse value) {
        return new JAXBElement<VerifyUserLoginResponse>(_VerifyUserLoginResponse_QNAME, VerifyUserLoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidUserTokeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ws.common.idm.yonyou/", name = "validUserTokeResponse")
    public JAXBElement<ValidUserTokeResponse> createValidUserTokeResponse(ValidUserTokeResponse value) {
        return new JAXBElement<ValidUserTokeResponse>(_ValidUserTokeResponse_QNAME, ValidUserTokeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckClientUserAccessPermissionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ws.common.idm.yonyou/", name = "checkClientUserAccessPermissionResponse")
    public JAXBElement<CheckClientUserAccessPermissionResponse> createCheckClientUserAccessPermissionResponse(CheckClientUserAccessPermissionResponse value) {
        return new JAXBElement<CheckClientUserAccessPermissionResponse>(_CheckClientUserAccessPermissionResponse_QNAME, CheckClientUserAccessPermissionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyUserAndPassResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ws.common.idm.yonyou/", name = "verifyUserAndPassResponse")
    public JAXBElement<VerifyUserAndPassResponse> createVerifyUserAndPassResponse(VerifyUserAndPassResponse value) {
        return new JAXBElement<VerifyUserAndPassResponse>(_VerifyUserAndPassResponse_QNAME, VerifyUserAndPassResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyUserLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ws.common.idm.yonyou/", name = "verifyUserLogin")
    public JAXBElement<VerifyUserLogin> createVerifyUserLogin(VerifyUserLogin value) {
        return new JAXBElement<VerifyUserLogin>(_VerifyUserLogin_QNAME, VerifyUserLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateUserToke }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ws.common.idm.yonyou/", name = "generateUserToke")
    public JAXBElement<GenerateUserToke> createGenerateUserToke(GenerateUserToke value) {
        return new JAXBElement<GenerateUserToke>(_GenerateUserToke_QNAME, GenerateUserToke.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAuthLogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ws.common.idm.yonyou/", name = "userAuthLogResponse")
    public JAXBElement<UserAuthLogResponse> createUserAuthLogResponse(UserAuthLogResponse value) {
        return new JAXBElement<UserAuthLogResponse>(_UserAuthLogResponse_QNAME, UserAuthLogResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateUserTokeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ws.common.idm.yonyou/", name = "generateUserTokeResponse")
    public JAXBElement<GenerateUserTokeResponse> createGenerateUserTokeResponse(GenerateUserTokeResponse value) {
        return new JAXBElement<GenerateUserTokeResponse>(_GenerateUserTokeResponse_QNAME, GenerateUserTokeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyUserAndPass }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ws.common.idm.yonyou/", name = "verifyUserAndPass")
    public JAXBElement<VerifyUserAndPass> createVerifyUserAndPass(VerifyUserAndPass value) {
        return new JAXBElement<VerifyUserAndPass>(_VerifyUserAndPass_QNAME, VerifyUserAndPass.class, null, value);
    }

}
