package com.example.bean;

/**
 * @author cxf
 * @create 2022-07-12 12:20 PM
 */

public class Engagements {
    private int id;
    private int eid;
    private int price;

    public Engagements() {
    }

    public Engagements(int id, int eid, int price) {
        this.id = id;
        this.eid = eid;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Engagements{" +
                "id=" + id +
                ", eid=" + eid +
                ", price=" + price +
                '}';
    }
}
