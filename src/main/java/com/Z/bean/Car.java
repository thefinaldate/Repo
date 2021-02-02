package com.Z.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Z on 2021/2/1 21:03
 */

/**
 *  只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 *  所以需要再加上@Component
 */

//@Component
@ToString
@Data
@ConfigurationProperties(prefix = "mycar") // 此处prefix 前缀： 在配置文件中前缀和prefix相同的值所对应的属性与Car类中的成员变量一一对应
public class Car {

    private String brand; //品牌
    private Integer price;

//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public void setPrice(Integer price) {
//        this.price = price;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public Integer getPrice() {
//        return price;
//    }
//
//    @Override
//    public String toString() {
//        return "Car{" +
//                "brand='" + brand + '\'' +
//                ", price=" + price +
//                '}';
//    }
}
