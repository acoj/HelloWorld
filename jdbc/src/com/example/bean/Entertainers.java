package com.example.bean;

/**
 * @author cxf
 * @create 2022-07-12 10:24 AM
 */

public class Entertainers {
    private int eid;
    private String ename;
    private String password;

    public Entertainers() {
    }

    public Entertainers(int eid, String ename, String password) {
        this.eid = eid;
        this.ename = ename;
        this.password = password;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Entertainers{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
