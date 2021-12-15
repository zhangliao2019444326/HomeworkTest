package com.example.homeworktest;

public class Eser  {
    private String one;            //节点一
    private String two;           //节点二
    private String three;           //节点二
    public Eser(String one, String two,String three) {
        this.one = one;
        this.two = two;
        this.three=three;
    }
    public String getone() {
        return one;
    }
    public void setone(String one) {
        this.one = one;
    }
    public String gettwo() {
        return two;
    }
    public void settwo(String two) {
        this.two = two;
    }
    public String getthree() {
        return three;
    }
    public void setthree(String three) {
        this.three = three;
    }
    @Override
    public String toString() {
        return "Eser{" +
                "one='" + one + '\'' +
                ", two='" + two + '\'' +
                ", three='" + three + '\'' +
                '}';
    }
}