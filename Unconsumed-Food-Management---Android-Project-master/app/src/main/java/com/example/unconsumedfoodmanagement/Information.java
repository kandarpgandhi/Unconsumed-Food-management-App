package com.example.unconsumedfoodmanagement;

public class Information {
    private  String DonerName,DonerMob,DonerAdd,DonerPincode,DonerMeal,DonerHour;

    public Information()
    {

    }
    public Information(String donerName, String donerMob, String donerAdd, String donerPincode, String donerMeal, String donerHour) {
        DonerName = donerName;
        DonerMob = donerMob;
        DonerAdd = donerAdd;
        DonerPincode = donerPincode;
        DonerMeal = donerMeal;
        DonerHour = donerHour;
    }

    public String getDonerName() {
        return DonerName;
    }

    public void setDonerName(String donerName) {
        DonerName = donerName;
    }

    public String getDonerMob() {
        return DonerMob;
    }

    public void setDonerMob(String donerMob) {
        DonerMob = donerMob;
    }

    public String getDonerAdd() {
        return DonerAdd;
    }

    public void setDonerAdd(String donerAdd) {
        DonerAdd = donerAdd;
    }

    public String getDonerPincode() {
        return DonerPincode;
    }

    public void setDonerPincode(String donerPincode) {
        DonerPincode = donerPincode;
    }

    public String getDonerMeal() {
        return DonerMeal;
    }

    public void setDonerMeal(String donerMeal) {
        DonerMeal = donerMeal;
    }

    public String getDonerHour() {
        return DonerHour;
    }

    public void setDonerHour(String donerHour) {
        DonerHour = donerHour;
    }
}
