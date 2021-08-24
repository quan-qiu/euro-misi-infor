package com.euromisi.infordatainterface.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ttcibd001350")
public class Item {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="t_item")
    protected String tItem;
    @Column(name="t_dsca")
    protected String tDsca;
    @Column(name="t_cuni")
    protected String tCuni;

    public String gettItem() {
        return tItem;
    }

    public void settItem(String tItem) {
        this.tItem = tItem;
    }

    public String gettDsca() {
        return tDsca;
    }

    public void settDsca(String tDsca) {
        this.tDsca = tDsca;
    }

    public String gettCuni() {
        return tCuni;
    }

    public void settCuni(String tCuni) {
        this.tCuni = tCuni;
    }

    @Override
    public String toString() {
        return "Item{" +
                "tItem='" + tItem + '\'' +
                ", tDsca='" + tDsca + '\'' +
                ", tCuni='" + tCuni + '\'' +
                '}';
    }
}
