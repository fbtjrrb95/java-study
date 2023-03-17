package me.screw.javademostudy.javathis;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ThisTest {

    @Test
    void printThis() {
        This this1 = new This();
        This this2 = new This();

        this1.printThis();
        this2.printThis();
    }

    @Test
    void getSum() {
        This thisWithThreeArgs = new This(1, 0, 0);
        This thisWithTwoArgs = new This(1, 0);
        This thisWithOneArg = new This(1);

        assertThat(thisWithThreeArgs.getSum()).isEqualTo(thisWithTwoArgs.getSum());
        assertThat(thisWithTwoArgs.getSum()).isEqualTo(thisWithOneArg.getSum());

    }

    @Test
    void builder() {
        This thisObjectCreatedByBuilder = This.newBuilder()
                .first(10)
                .second(20)
                .third(30)
                .build();

        This thisObjectCreatedByConstructor = new This(10, 20, 30);

        assertThat(thisObjectCreatedByBuilder.getSum())
                .isEqualTo(thisObjectCreatedByConstructor.getSum())
                .isEqualTo(60);
    }
}