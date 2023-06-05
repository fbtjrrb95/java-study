package me.screw.javademostudy.doubledispatch.company;

import me.screw.javademostudy.doubledispatch.product.Product;

public class Samsung implements Company {
    @Override
    public void create(Product product) {
        product.createdBy(this);
    }
}
