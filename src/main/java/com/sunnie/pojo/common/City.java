package com.sunnie.pojo.common;

import java.io.Serializable;

/**
 * @author Sunnie
 */
public class City implements Serializable {

    String city;

    String distrct;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrct() {
        return distrct;
    }

    public void setDistrct(String distrct) {
        this.distrct = distrct;
    }
}
