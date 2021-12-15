package com.example.homeworktest.entity;

public class MainMenu {
    private int icon;
    private  String menuName;
    public  int getIcon(){
        return  icon;
    }
    public  void  setIcon (int icon){
        this.icon=icon;
    }
    public String getMenuName(){
        return  menuName;
    }
    public void setMenuName(String menuName){
        this.menuName=menuName;
    }
    public  MainMenu(int icon,String menuName){
        this.icon=icon;
        this.menuName=menuName;
    }
}
