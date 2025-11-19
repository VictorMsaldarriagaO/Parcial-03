package com.example.parcial3.Model;

public class Person {
    private String Id;
    private  String name;
    private  String gender;
    private Integer age;
    public Person(String Id,String name,String gender,Integer age){
        this.Id=Id;
        this.age=age;
        this.gender=gender;
        this.name=name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name ="+name+" "+ "gender ="+gender+" "+ "age ="+age+" "+ " ID="+Id+" ";
    }
}
