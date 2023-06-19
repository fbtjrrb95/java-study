package me.screw.javademostudy.doubledispatch.product;

import me.screw.javademostudy.doubledispatch.company.LG;
import me.screw.javademostudy.doubledispatch.company.Naver;
import me.screw.javademostudy.doubledispatch.company.Samsung;

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
