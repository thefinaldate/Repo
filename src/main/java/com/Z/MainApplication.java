package com.Z;

import ch.qos.logback.core.db.DBHelper;
import com.Z.bean.Pet;
import com.Z.bean.User;
import com.Z.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Z on 2021/1/22 10:39
 * <p>
 * <p>
 * 主程序类； 主配置类
 */
//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.Z")
public class MainApplication {
    public static void main(String[] args) {
        // 1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        // 2.查看容器中的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        // 3.从容器中获取组件
        Pet tom = run.getBean("tomcatPet", Pet.class);
        Pet tom1 = run.getBean("tomcatPet", Pet.class);
        System.out.println("组件: " + (tom == tom1));

        // 4. Z.config.MyConfig@49d98dc5 proxyBeanMethods = false
        //    Z.config.MyConfig$$EnhancerBySpringCGLIB$$6e12496@4e6d7365 proxyBeanMethods = true
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        // 若@Configuration(proxyBeanMethods = true)代理对象调用方法，SpringBoot会检查并保持组件单例
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(user == user1);

        User user01 = run.getBean("user01", User.class);
        Pet tomcatPet = run.getBean("tomcatPet", Pet.class);
        System.out.println("用户的宠物：" + (user01.getPet() == tomcatPet));

        // 5. 获取组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("=========");
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        User bean2 = run.getBean("com.Z.bean.User", User.class);
        System.out.println(bean2);
        System.out.println(user1);
        DBHelper bean1 = run.getBean(DBHelper.class);
        System.out.println(bean1);

        boolean tom2 = run.containsBean("tom");
        System.out.println("容器中Tom组件：" + tom2);

        boolean user011 = run.containsBean("user01");
        System.out.println("容器中user01组件：" + user011);

        boolean hen = run.containsBean("hen");
        boolean ha = run.containsBean("ha");
        System.out.println("hen:" + hen);
        System.out.println("ha:" + ha);

    }
}
