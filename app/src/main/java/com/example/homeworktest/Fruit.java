package com.example.homeworktest;

public class Fruit{

    private String name;
    private int imageId;
    public Fruit(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getname(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
