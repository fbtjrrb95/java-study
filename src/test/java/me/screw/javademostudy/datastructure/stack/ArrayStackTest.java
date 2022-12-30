package me.screw.javademostudy.datastructure.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    public void push_multiThread_array_doubleUp이_일어날때() {
        final int cnt = 1_000_000;
        int[] integersToPush = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            integersToPush[i] = i + 1;
        }
        ArrayStack multiThreadArrayStack = new ArrayStack(10);
        assertThatNoException().isThrownBy(() -> {
            Arrays.stream(integersToPush).parallel()
                    .forEach(multiThreadArrayStack::push);
        });
    }
}