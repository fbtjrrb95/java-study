package me.skrew.javastudy.doubledispatch.company;

import me.skrew.javastudy.doubledispatch.product.Product;

public class Naver implements Company {
    @Override
    public void create(Product product) {
        product.createdBy(this);
    }
}
