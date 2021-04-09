package com.example.apekshakhandelwal.admin_jovial;

/**
 * Created by Apeksha Khandelwal on 02-10-2017.
 */

public class ImageUploadInfo {
    public String imageName;

    public String imageURL;

    public ImageUploadInfo(String name, String url) {

        this.imageName = name;
        this.imageURL= url;
    }

    public String getImageName() {
        return imageName;
    }

    public String getImageURL() {
        return imageURL;
    }

}
