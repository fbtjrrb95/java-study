package me.screw.javademostudy.doubledispatch.product;

import me.screw.javademostudy.doubledispatch.company.Company;

public interface Product {

    String getName();
    default void createdBy(Company company) {
        System.out.printf("%s created by %s%n", this.getName(), company.getName());
    }
}
