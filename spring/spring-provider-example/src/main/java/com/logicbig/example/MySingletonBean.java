package com.logicbig.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.inject.Provider;

public class MySingletonBean {

    @Autowired
    private Provider<MyPrototypeBean> myPrototypeBeanProvider;

    public void showMessage () {
        MyPrototypeBean bean = myPrototypeBeanProvider.get();
        System.out.println("Hi, the time is " + bean.getDateTime());
    }
}