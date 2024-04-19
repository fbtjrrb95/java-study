package me.skrew.javastudy.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class FutureTestApplication {

    public static void main(String[] args) {

        List<Integer> task = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
            add(9);
            add(10);
        }};

        List<CompletableFuture<String>> printFutures = task.stream()
                .map(integer -> CompletableFuture.supplyAsync(
                        () -> {
                            String res = integer + "First";
                            System.out.println(res);
                            return res;
                        }
                ))
                .map(stringCompletableFuture -> stringCompletableFuture.thenApply(
                        (res) -> {
                            String res2 = res + " Second";
                            System.out.println(res2);
                            return res2;
                        }))
                .collect(Collectors.toList());

        List<String> collect = printFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        System.out.println("****************************");

        for (String item : collect) {
            System.out.println(item);
        }

    }
}
