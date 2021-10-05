package com.example.covid_details;

public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getAdate() {
        return adate;
    }

    public void setAdate(String adate) {
        this.adate = adate;
    }

    public String getDdate() {
        return ddate;
    }

    public void setDdate(String ddate) {
        this.ddate = ddate;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getFirstdose() {
        return firstdose;
    }

    public void setFirstdose(String firstdose) {
        this.firstdose = firstdose;
    }

    public String getSeconddose() {
        return seconddose;
    }

    public void setSeconddose(String seconddose) {
        this.seconddose = seconddose;
    }

    public User(String name, String email, String mNumber, String age, String gender, String aadhar
            , String address, String cdate, String adate, String ddate, String vaccine, String firstdose, String seconddose) {
        this.name = name;
        this.email = email;
        this.mNumber = mNumber;
        this.age = age;
        this.gender = gender;
        this.aadhar = aadhar;
        this.address = address;
        this.cdate = cdate;
        this.adate = adate;
        this.ddate = ddate;
        this.vaccine = vaccine;
        this.firstdose = firstdose;
        this.seconddose = seconddose;
    }

    String  name,email,mNumber, age, gender, aadhar, address, cdate, adate, ddate, vaccine, firstdose, seconddose;

    public User() {

    }


}
