package me.screw.javademostudy.doubledispatch.company;

import me.screw.javademostudy.doubledispatch.product.Product;

public interface Company {

    String getName();

    default void create(Product product) {
        product.createdBy(this);
    }
}
