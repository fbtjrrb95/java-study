package me.skrew.javastudy.doubledispatch.product;

import me.skrew.javastudy.doubledispatch.company.LG;
import me.skrew.javastudy.doubledispatch.company.Naver;
import me.skrew.javastudy.doubledispatch.company.Samsung;

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
