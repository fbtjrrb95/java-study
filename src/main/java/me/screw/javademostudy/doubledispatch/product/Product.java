package me.screw.javademostudy.doubledispatch.product;

import me.screw.javademostudy.doubledispatch.company.LG;
import me.screw.javademostudy.doubledispatch.company.Naver;
import me.screw.javademostudy.doubledispatch.company.Samsung;

public interface Product {

    void createdBy(LG lg);
    void createdBy(Naver naver);
    void createdBy(Samsung samsung);
}
