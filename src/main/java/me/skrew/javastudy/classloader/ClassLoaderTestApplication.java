package me.skrew.javastudy.classloader;

import java.lang.reflect.Field;
import java.util.Vector;

public class ClassLoaderTestApplication {
    public static void main(String[] args) {
        checkLoadingClass();
    }

    /**
     * class loader 는 동적으로 class 정보를 로드한다.
     * 즉, 컴파일 단계에서 모든 클래스 정보를 로드하는 게 아니라 사용하려고 할 때, 로드한다.
     * 정말 그런지를 시각적으로 확인하기 위한 코드.
     */
    public static void checkLoadingClass() {
        Play play = new Play();
//        Work work = new Work();

        Field f = null;
        try {
            f = ClassLoader.class.getDeclaredField("classes");
        } catch (NoSuchFieldException e) {
            System.out.println(e);
        }
        f.setAccessible(true);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Vector<Class> classes = null;

        try {
            classes =  (Vector<Class>) f.get(classLoader);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }

        assert classes != null;
        for (Class c : classes) {
            System.out.println(c);
        }
    }
}
