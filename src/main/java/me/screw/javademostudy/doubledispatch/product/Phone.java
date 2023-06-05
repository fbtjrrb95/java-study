package me.screw.javademostudy.doubledispatch.product;

import me.screw.javademostudy.doubledispatch.company.LG;
import me.screw.javademostudy.doubledispatch.company.Naver;
import me.screw.javademostudy.doubledispatch.company.Samsung;

public class Phone implements Product {

    @Override
    public void createdBy(LG lg) {
        System.out.println("phone did not created by lg");
    }

    @Override
    public void createdBy(Naver naver) {
        System.out.println("phone did not created by naver");
    }

    @Override
    public void createdBy(Samsung samsung) {
        System.out.println("phone created by samsung");
    }
}
