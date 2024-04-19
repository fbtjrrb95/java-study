package me.skrew.javastudy.doubledispatch.product;

import me.skrew.javastudy.doubledispatch.company.LG;
import me.skrew.javastudy.doubledispatch.company.Naver;
import me.skrew.javastudy.doubledispatch.company.Samsung;

public interface Product {

    void createdBy(LG lg);
    void createdBy(Naver naver);
    void createdBy(Samsung samsung);
}
