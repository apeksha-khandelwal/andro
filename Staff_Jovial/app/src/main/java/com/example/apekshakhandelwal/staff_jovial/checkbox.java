package com.example.apekshakhandelwal.staff_jovial;

/**
 * Created by Apeksha Khandelwal on 19-06-2017.
 */

public class checkbox
{
    String code = null;
    String name = null;
    boolean selected = false;

    public checkbox(String code, String name, boolean selected) {
        super();
        this.code = code;
        this.name = name;
        this.selected = selected;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
