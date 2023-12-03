package org.sverdiye;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TaskOneTest {

    @Test
    public void partOne() {
        List<String> lines = TestUtils.readFile(1);


        List<List<Integer>> linesWithOutLetters = new ArrayList<>();
        Integer sum = 0;
        for (String line : lines) {
            ArrayList<Integer> newList = new ArrayList<>();
            linesWithOutLetters.add(newList);
            for (int i = 0; i < line.length(); i++) {

                char myChar = line.charAt(i);
                if (Character.isDigit(myChar)) {
                    newList.add(Character.getNumericValue(myChar));
                } else {
                    int mappedDigit = isWordedDigit(line, i);
                    if (mappedDigit > -1) newList.add(mappedDigit);
                }
            }
            sum += Integer.parseInt("" + newList.getFirst() + newList.getLast());
        }
        System.out.println(sum);
    }

    private int isWordedDigit(String line, int index) {
        List<String> wordedDigits = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        int min = wordedDigits.stream().reduce((s1, s2) -> s1.length() < s2.length() ? s1 : s2).get().length();
        if (line.length() < min)
            return -1;

        for (int i = 0; i < wordedDigits.size(); i++) {
            if (line.startsWith(wordedDigits.get(i), index)) {
                return i;
            }
        }
        return -1;
    }
}
