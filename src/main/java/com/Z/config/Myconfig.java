package com.Z.config;

import ch.qos.logback.core.db.DBHelper;
import com.Z.bean.Car;
import com.Z.bean.Pet;
import com.Z.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Z on 2021/1/25 16:35
 */


/**
 *      1.配置类中使用@Bean 标注在方法上给容器注册组件，默认是单例的
 *      2.配置类本身也是组件
 *      3.proxyBeanMethods：代理bean的方法
 *          Full（proxyBeanMethods = true） 【保证每个@Bean方法被调用多少次返回的组件都是单例的】
 *          Lite（proxyBeanMethods = false） 【每个@Bean方法被调用多少次返回的组件都是新创建的 多例】
 *          组件依赖
 *      4.@Import（{User.class, DBHelper.class}）
 *          给容器中自动创建出这两个类型的组件，默认组件的名字就是全类名
 *
 */
@Configuration(proxyBeanMethods = false) //告诉springboot这时一个配置类 == 配置文件
@Import({User.class, DBHelper.class})
//@ConditionalOnBean(name = "tomcatPet111")  //只有当容器中存在tomcatPet组件时，以下配置才生效
@ConditionalOnMissingBean(name = "tomcatPet111")    // 不存在tomcatPet组件时，以下配置生效
@ImportResource(locations = "classpath:beans.xml")  // 在任意config文件中 声明@ImportResource注解，表明从路径中读取配置文件
@EnableConfigurationProperties(Car.class)   // 1.开启Car配置绑定功能 2.把这个Car这个组件自动注册到容器中（方便将第三方包中的组件注册到容器中）
public class MyConfig {
    @Bean   // 给容器添加组件
    public User user01() {
        User zhangSan = new User("ZhangSan", "12");
//        zhangSan.setPet(tomcatPet());
        return zhangSan;
    }

    @Bean
    public Pet tomcatPet() {
        return new Pet("tomcat111");
    }

}
