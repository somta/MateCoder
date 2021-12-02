package net.somta.matecoder.model.system;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;


@Entry(objectClasses = "person")
public class Person {

    @Id
    private Name id;
    /**
     * 用户名
     */
    @DnAttribute(value = "uid")
    private String uid;

    /**
     * 名
     */
    @Attribute(name = "cn")
    private String cn;

    /**
     * 姓
     */
    @Attribute(name = "sn")
    private String sn;


    /*@Attribute(name="mail")
    private String mail;
    @Attribute(name = "homedirectory")
    private String homedirectory;
    @Attribute(name = "gidnumber")
    private String gidnumber;
    @Attribute(name = "uidnumber")
    private String uidnumber;*/

    public Name getId() {
        return id;
    }

    public void setId(Name id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    /*public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getHomedirectory() {
        return homedirectory;
    }

    public void setHomedirectory(String homedirectory) {
        this.homedirectory = homedirectory;
    }

    public String getGidnumber() {
        return gidnumber;
    }

    public void setGidnumber(String gidnumber) {
        this.gidnumber = gidnumber;
    }

    public String getUidnumber() {
        return uidnumber;
    }

    public void setUidnumber(String uidnumber) {
        this.uidnumber = uidnumber;
    }*/
}