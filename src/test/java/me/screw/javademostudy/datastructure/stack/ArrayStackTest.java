package me.screw.javademostudy.datastructure.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayStackTest {

    private ArrayStack arrayStack;

    @BeforeEach
    public void setUp() {
        arrayStack = new ArrayStack(10);
    }

    @Test
    public void push() {
        arrayStack.push(1);
        arrayStack.push(2);

        assertThat(arrayStack.getSize()).isEqualTo(2);
    }

    @Test
    public void push_doubleUp() {
        for (int i = 0; i < 20; i++) {
            arrayStack.push(i);
        }

        assertThat(arrayStack.getSize()).isEqualTo(20);
    }

    @Test
    public void pop() {
        arrayStack.push(1);
        arrayStack.push(2);

        assertThat(arrayStack.pop()).isEqualTo(2);
        assertThat(arrayStack.getSize()).isEqualTo(1);
    }
}