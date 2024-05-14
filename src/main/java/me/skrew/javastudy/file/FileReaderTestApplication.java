package me.skrew.javastudy.file;

import java.io.File;

public class FileReaderTestApplication {

    public static void main(String[] args) {
       FileReader fileReader = new FileReader();
        File file = new File("src/main/java/me/skrew/javastudy/file/test.xlsx");
       fileReader.read(file);
    }

}
