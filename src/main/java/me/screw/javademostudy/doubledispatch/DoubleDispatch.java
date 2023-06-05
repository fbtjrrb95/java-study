package me.screw.javademostudy.doubledispatch;

import me.screw.javademostudy.doubledispatch.company.*;
import me.screw.javademostudy.doubledispatch.product.Application;
import me.screw.javademostudy.doubledispatch.product.Phone;
import me.screw.javademostudy.doubledispatch.product.Product;
import me.screw.javademostudy.doubledispatch.product.TV;

import java.util.List;
import java.util.Map;

public class DoubleDispatch {

    public static void main(String[] args) {
        Map<Company, List<Product>> map = Map.of(
                new Samsung(), List.of(new TV(), new Phone()),
                new LG(), List.of(new TV(), new Phone()),
                new Naver(), List.of(new Application()),
                new Kakao(), List.of(new Application())
        );

        for (Company company : map.keySet()) {
            List<Product> products = map.get(company);
            products.forEach(company::create);
            System.out.println("=====================");
        }
    }

}
