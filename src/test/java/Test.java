import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
/*
 test/exp/ directory contains expected outputs,
 test/inp/ directory contains input JSON files
 Outputs are verified with whitespace characters removed
 */

class Test {
    String getContents(String fileName) throws FileNotFoundException {
        return new Scanner(new File(fileName)).useDelimiter("\\Z").next();
    }
    @org.junit.jupiter.api.Test
    void test0() throws FileNotFoundException {
        String output = Main.getResult("src/test/inp/0.json");
        String expected = getContents("src/test/exp/0.json");

        assertEquals(expected.replaceAll("\\s",""), output.replaceAll("\\s",""));
    }

    @org.junit.jupiter.api.Test
    void test1() throws FileNotFoundException {
        String output = Main.getResult("src/test/inp/1.json");
        String expected = getContents("src/test/exp/1.json");

        assertEquals(expected.replaceAll("\\s",""), output.replaceAll("\\s",""));
    }

    @org.junit.jupiter.api.Test
    void test2() throws FileNotFoundException {
        String output = Main.getResult("src/test/inp/2.json");
        String expected = getContents("src/test/exp/2.json");

        assertEquals(expected.replaceAll("\\s",""), output.replaceAll("\\s",""));
    }

    @org.junit.jupiter.api.Test
    void test3() throws FileNotFoundException {
        String output = Main.getResult("src/test/inp/3.json");
        String expected = getContents("src/test/exp/3.json");

        assertEquals(expected.replaceAll("\\s",""), output.replaceAll("\\s",""));
    }

    @org.junit.jupiter.api.Test
    void test4() throws FileNotFoundException {
        String output = Main.getResult("src/test/inp/4.json");
        String expected = getContents("src/test/exp/4.json");

        assertEquals(expected.replaceAll("\\s",""), output.replaceAll("\\s",""));
    }
}