package com.landrec.entity;

public class Land_info {
    private String land_id;
    private String land_status;
    private String land_type;
    private int land_size;
    private String land_name;
    private String dist_id;
    public Land_info()
    {
        land_id= null;
        land_name =null;
        land_size = 0;
        land_status = null;
        land_type =null;
        dist_id =null;
    }

    public String getLand_id() {
        return land_id;
    }

    public void setLand_id(String land_id) {
        this.land_id = land_id;
    }

    public String getLand_status() {
        return land_status;
    }

    public void setLand_status(String land_status) {
        this.land_status = land_status;
    }

    public String getLand_type() {
        return land_type;
    }

    public void setLand_type(String land_type) {
        this.land_type = land_type;
    }

    public int getLand_size() {
        return land_size;
    }

    public void setLand_size(int land_size) {
        this.land_size = land_size;
    }

    public String getLand_name() {
        return land_name;
    }

    public void setLand_name(String land_name) {
        this.land_name = land_name;
    }

    public String getDist_id() {
        return dist_id;
    }

    public void setDist_id(String dist_id) {
        this.dist_id = dist_id;
    }
}
