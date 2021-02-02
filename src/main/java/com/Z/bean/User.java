package com.Z.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Z on 2021/1/25 16:00
 */

@Data
@ToString
@NoArgsConstructor
//@AllArgsConstructor
public class User {

    @Qualifier("tomcatPet")
    @Autowired
    private Pet pet;
//    private Pet pet;

    private String name;
    private String age;

//    public User() {
//    }
//
    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getAge() {
//        return age;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(String age) {
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "pet=" + pet +
//                ", name='" + name + '\'' +
//                ", age='" + age + '\'' +
//                '}';
//    }
//
//    public void setPet(Pet pet) {
//        this.pet = pet;
//    }
//
//    public Pet getPet() {
//        return pet;
//    }
}
