package com.example.apekshakhandelwal.admin_jovial;

/**
 * Created by Apeksha Khandelwal on 03-10-2017.
 */

public class User {
    private String email,password,fname,address,adharn,no;

    public User(String email,String password,String fname,String address,String no,String adhar)
    {
        this.email = email;
        this.password=password;
        this.fname = fname;
        this.address=address;
        this.no=no;
        this.adharn=adhar;
    }
}
