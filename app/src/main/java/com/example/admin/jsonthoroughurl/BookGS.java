package com.example.admin.jsonthoroughurl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class BookGS {
    private String posName;

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getKeySkills() {
        return keySkills;
    }

    public void setKeySkills(String keySkills) {
        this.keySkills = keySkills;
    }

    public String getExperience() {
        return experience;

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalRange() {
        return salRange;
    }

    public void setSalRange(String salRange) {
        this.salRange = salRange;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    private String experience;

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    private String salRange;

    private String location;

    private String keySkills;

    private String createdDate;




  }
