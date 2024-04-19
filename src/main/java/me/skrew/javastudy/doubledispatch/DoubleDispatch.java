package me.skrew.javastudy.doubledispatch;

import me.skrew.javastudy.doubledispatch.company.Company;
import me.skrew.javastudy.doubledispatch.company.LG;
import me.skrew.javastudy.doubledispatch.company.Naver;
import me.skrew.javastudy.doubledispatch.company.Samsung;
import me.skrew.javastudy.doubledispatch.product.Application;
import me.skrew.javastudy.doubledispatch.product.Phone;
import me.skrew.javastudy.doubledispatch.product.Product;
import me.skrew.javastudy.doubledispatch.product.TV;

import java.util.List;

public class DoubleDispatch {

    public static void main(String[] args) {
        List<Company> companies = List.of(new Samsung(), new LG(), new Naver());
        List<Product> products = List.of(new TV(), new Phone(), new Application());

        companies.forEach(company -> products.forEach(company::create));
    }

}
