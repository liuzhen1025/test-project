/**
 * copyRight
 */
package com.gennlife;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/11/26
 * Time: 14:09
 */
public class User {
    private String userName;
    private String id;
    private Integer age;
    private Object message;

    public Object getMessage() {

        return message;
    }

    public void setMessage(Object message) {

        this.message = message;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public Integer getAge() {

        return age;
    }

    public void setAge(Integer age) {

        this.age = age;
    }
}
