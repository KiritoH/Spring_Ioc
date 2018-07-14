package com.yww.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

public class SpringDemo1 {

    //传统开发方式
    @Test
    public void demo1() {
        //要new这个对象,有耦合关系
        UserService userService = new UserServiceImpl();
        userService.sayHello();
    }

    @Test
    public void demo2() {
        //首先要使用Spring的工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过工厂获得类,需要强转
        UserService userService = (UserService) applicationContext.getBean("userService");

        userService.sayHello();

    }

    //读取磁盘系统中的配置文件
    @Test
    public void demo3() {
        //FileSystemXmlApplicationContext需要访问磁盘下的文件(绝对路径),创建Spring的工厂类
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("g:\\applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHello();
    }

    //传统方式工厂类(了解即可,此为旧方式,不提倡使用)----访问类路径的xml文件
    @Test
    public void demo4() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

        UserService userService = (UserService) beanFactory.getBean("userService");

        userService.sayHello();
    }

    //传统方式工厂类(了解即可,此为旧方式,不提倡使用)----访问磁盘路径的xml文件
    @Test
    public void demo5(){
        BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("G:\\applicationContext.xml"));

        UserService userService = (UserService) beanFactory.getBean("userService");

        userService.sayHello();
    }
}
