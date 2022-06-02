package com.landrec.entity;

public class Owner_info {
    private String owner_id;
    private String f_name;
    private String m_name;
    private String l_name;
    private String city;
    private String add_line1;
    private String add_line2;


    public Owner_info() {
        this.owner_id = null;
        this.f_name = null;
        this.m_name = null;
        this.l_name = null;
        this.city = null;
        this.add_line1 = null;
        this.add_line2 = null;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdd_line1() {
        return add_line1;
    }

    public void setAdd_line1(String add_line1) {
        this.add_line1 = add_line1;
    }

    public String getAdd_line2() {
        return add_line2;
    }

    public void setAdd_line2(String add_line2) {
        this.add_line2 = add_line2;
    }
}
