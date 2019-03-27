package com.jingzhun.poordatemanager.entity;

import java.util.List;

/**
 * Created by Administrator on 2019/3/26 0026.
 */
public class HPoorVillage implements java.io.Serializable {
    private Integer id;
    private Integer tid;
    private String vsname2;
    private List<HPoorVillage> hPoorVillageList;

    @Override
    public String toString() {
        return "HPoorVillage{" +
                "id=" + id +
                ", tid=" + tid +
                ", vsname2='" + vsname2 + '\'' +
                ", hPoorVillageList=" + hPoorVillageList +
                '}';
    }

    public HPoorVillage(Integer id, Integer tid, String vsname2, List<HPoorVillage> hPoorVillageList) {
        this.id = id;
        this.tid = tid;
        this.vsname2 = vsname2;
        this.hPoorVillageList = hPoorVillageList;
    }

    public HPoorVillage() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getVsname2() {
        return vsname2;
    }

    public void setVsname2(String vsname2) {
        this.vsname2 = vsname2;
    }

    public List<HPoorVillage> gethPoorVillageList() {
        return hPoorVillageList;
    }

    public void sethPoorVillageList(List<HPoorVillage> hPoorVillageList) {
        this.hPoorVillageList = hPoorVillageList;
    }
}
