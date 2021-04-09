package com.example.apekshakhandelwal.guidetour;

import android.location.Location;

/**
 * Created by Apeksha Khandelwal on 27-05-2017.
 */

public class Speciality
{
    private String Name;
    private String Phone;
    private String addr;
    private String ImageUrl;
    private Location Location;

    public Speciality(String name, String phone, String address, String imageUrl, Location location) {
        Name = name;
        Phone = phone;
        addr = address;
        ImageUrl = imageUrl;
        Location = location;
    }

    public String getAttractionName() {
        return Name;
    }

    public String getAttractionPhone() {
        return Phone;
    }

    public Location getLocation() {
        return Location;
    }

    public String getAttractionAddress() {
        return addr;
    }

    public String getImageResourceUrl(){
        return ImageUrl;
    }

}
