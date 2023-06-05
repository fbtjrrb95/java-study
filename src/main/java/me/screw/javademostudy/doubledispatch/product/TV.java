package me.screw.javademostudy.doubledispatch.product;

import me.screw.javademostudy.doubledispatch.company.LG;
import me.screw.javademostudy.doubledispatch.company.Naver;
import me.screw.javademostudy.doubledispatch.company.Samsung;

public class TV implements Product {

    @Override
    public void createdBy(LG lg) {
        System.out.println("TV created by lg");
    }

    @Override
    public void createdBy(Naver naver) {
        System.out.println("TV did not created by naver");
    }

    @Override
    public void createdBy(Samsung samsung) {
        System.out.println("TV created by samsung");
    }
}
