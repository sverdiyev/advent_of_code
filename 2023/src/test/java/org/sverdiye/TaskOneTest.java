package org.sverdiye;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TaskOneTest {

    @Test
    public void partOne() {
        List<String> lines = TestUtils.readFile(1);


        List<List<Character>> linesWithOutLetters = new ArrayList<>();
        Integer sum = 0;
        for (String line : lines) {
            ArrayList<Character> newList = new ArrayList<>();
            linesWithOutLetters.add(newList);
            for (char ch : line.toCharArray()) {
                if (Character.isDigit(ch)) {
                    newList.add(ch);
                }
            }
            sum += Integer.parseInt("" + newList.getFirst() + newList.getLast());
        }
        System.out.println(sum);
    }
}
