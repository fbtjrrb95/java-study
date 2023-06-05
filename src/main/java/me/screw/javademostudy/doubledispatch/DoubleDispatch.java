package me.screw.javademostudy.doubledispatch;

import me.screw.javademostudy.doubledispatch.company.*;
import me.screw.javademostudy.doubledispatch.product.Application;
import me.screw.javademostudy.doubledispatch.product.Phone;
import me.screw.javademostudy.doubledispatch.product.Product;
import me.screw.javademostudy.doubledispatch.product.TV;

import java.util.List;

public class DoubleDispatch {

    public static void main(String[] args) {
        List<Company> companies = List.of(new Samsung(), new LG(), new Naver());
        List<Product> products = List.of(new TV(), new Phone(), new Application());

        companies.forEach(company -> products.forEach(company::create));
    }

}
