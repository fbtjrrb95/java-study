package me.skrew.javastudy.doubledispatch.product;

import me.skrew.javastudy.doubledispatch.company.LG;
import me.skrew.javastudy.doubledispatch.company.Naver;
import me.skrew.javastudy.doubledispatch.company.Samsung;

public class Application implements Product {

    @Override
    public void createdBy(LG lg) {
        System.out.println("LG creates Application");
    }

    @Override
    public void createdBy(Naver naver) {
        System.out.println("Naver creates Application");
    }

    @Override
    public void createdBy(Samsung samsung) {
        System.out.println("Samsung creates Application");
    }
}
