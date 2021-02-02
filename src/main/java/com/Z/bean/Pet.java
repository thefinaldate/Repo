package com.Z.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Z on 2021/1/25 15:59
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    private String name;

//    public Pet() {
//    }
//
//    public Pet(String name) {
//        this.name = name;
//    }
//
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Pet{" +
//                "name='" + name + '\'' +
//                '}';
//    }
}
