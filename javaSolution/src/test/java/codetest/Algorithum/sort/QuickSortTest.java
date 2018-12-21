package codetest.Algorithum.sort;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void sort() {
        QuickSort quickSort = new QuickSort();
        int[] array = new int[] { 3, 4, 6, 5, 9, 8, 1};
        int[] expectArray = new int[] { 1, 3, 4, 5, 6, 8, 9};
        quickSort.sort(array);
        Assert.assertArrayEquals(array, expectArray);

//        String test = "test string 123";
//        System.out.println(test.matches("[\\w\\s]*"));
//        Pattern pattern = Pattern.compile(".*?(\\d+)");
//        Matcher matcher = pattern.matcher(test);
//        int i = 0;
//        while (matcher.find())
//        {
//            i++;
//            System.out.println(i + matcher.group(1));
//        }
//
//        try(BufferedReader reader = new BufferedReader(new FileReader("/Users/caolu/github/gitlab/code_test/pom.xml"))) {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/caolu/github/gitlab/code_test/pom.xml.bk"));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//                writer.write(line + "\n");
//            }
//            writer.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        final String EXAMPLE_TEST = "This is my small example "
//                + "string which I'm going to " + "use for pattern matching.";
//
//        System.out.println(EXAMPLE_TEST.matches("\\w.*"));
//        String[] splitString = (EXAMPLE_TEST.split("\\s+"));
//        System.out.println(splitString.length);// should be 14
//        for (String string : splitString) {
//            System.out.println(string);
//        }
//        // replace all whitespace with tabs
//        System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));
//
//        Pattern pattern = Pattern.compile("\\w+");
//        // in case you would like to ignore case sensitivity,
//        // you could use this statement:
//        // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(EXAMPLE_TEST);
//        // check all occurance
//        while (matcher.find()) {
//            System.out.print("Start index: " + matcher.start());
//            System.out.print(" End index: " + matcher.end() + " ");
//            System.out.println(matcher.group());
//        }
//        // now create a new pattern and matcher to replace whitespace with tabs
//        Pattern replace = Pattern.compile("\\s+");
//        Matcher matcher2 = replace.matcher(EXAMPLE_TEST);
//        System.out.println(matcher2.replaceAll("\t"));
    }
}