package me.screw.javademostudy.file;

import org.junit.jupiter.api.Test;

import java.io.File;

public class FileReaderTest {

    @Test
    public void test() {

        FileReader fileReader = new FileReader();
        File file = new File("src/test/java/me/screw/javademostudy/file/test.xlsx");
        fileReader.read(file);

    }

}
