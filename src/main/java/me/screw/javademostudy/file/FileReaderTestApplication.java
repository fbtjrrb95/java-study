package me.screw.javademostudy.file;

import java.io.File;

public class FileReaderTestApplication {

    public static void main(String[] args) {
       FileReader fileReader = new FileReader();
        File file = new File("java-demo-study/src/main/java/me/screw/javademostudy/file/test.xlsx");
       fileReader.read(file);
    }

}
