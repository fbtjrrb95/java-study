package me.screw.javademostudy.doubledispatch.product;

import me.screw.javademostudy.doubledispatch.company.LG;
import me.screw.javademostudy.doubledispatch.company.Naver;
import me.screw.javademostudy.doubledispatch.company.Samsung;

public class Phone implements Product {

    @Override
    public void createdBy(LG lg) {
        System.out.println("LG doesn't create Phone");
    }

    @Override
    public void createdBy(Naver naver) {
        System.out.println("Naver doesn't create Phone");
    }

    @Override
    public void createdBy(Samsung samsung) {
        System.out.println("Samsung creates Phone");
    }
}
