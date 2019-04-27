package com.jesse.lession1staticcreator;

public class CreateByStaticFactory {


    public String saySomething(){
        return "original say";
    }

    public static CreateByStaticFactory getInstance(){
        return new CreateByStaticFactory();
    }

    public static CreateByStaticFactory getSubObject(){
        return new SubClass();
    }



    public static void main(String[] args) {
        System.out.println(CreateByStaticFactory.getInstance().saySomething());
        System.out.println(CreateByStaticFactory.getSubObject().saySomething());
    }
}
