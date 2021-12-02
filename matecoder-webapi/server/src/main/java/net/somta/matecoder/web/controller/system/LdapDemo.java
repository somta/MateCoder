package net.somta.matecoder.web.controller.system;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LdapDemo{
  public static void main(String[] args){
    Hashtable<String, String> tbl = new Hashtable<String, String>(4);
    String LDAP_URL = "ldap://122.51.97.89/dc=somta,dc=net";
    tbl.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
    tbl.put(Context.PROVIDER_URL, LDAP_URL);
    tbl.put(Context.SECURITY_AUTHENTICATION, "simple");
    tbl.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=somta,dc=net");
    tbl.put(Context.SECURITY_CREDENTIALS, "123456");
    System.out.println("env setting");
    DirContext context = null;
    try {
        System.out.println("login verification begins...");
        context = new InitialDirContext(tbl);
        System.out.println("login successfully.");
    } catch (Exception ex) {
        ex.printStackTrace();
        System.out.println("login failed.");
    } finally {
        try {
            if (context != null) {
                context.close();
                context = null;
            }
            tbl.clear();
        } catch (Exception e) {
            System.out.println("exception happened.");
        }
    }
  }
}