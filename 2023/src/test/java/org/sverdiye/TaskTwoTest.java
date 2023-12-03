package org.sverdiye;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TaskTwoTest {

    private Map<Integer, Boolean> resultsMap = new HashMap<>();

    @Test
    public void test() {

        var lines = TestUtils.readFile(2);
        for (String line : lines) {
            parseLine(line);
        }

        System.out.println(parseResultMap());
    }

    private void parseLine(String line) {

        String[] partsOfGame = line.split(": ");

        Integer gameId = Integer.parseInt(partsOfGame[0].substring(5));
        String gameResult = partsOfGame[1];
        String[] gameSets = gameResult.split("; ");

        final int maxRed = 12, maxGreen = 13, maxBlue = 14;

        boolean isGamePossible = true;
        for (String set : gameSets) {
            int pulledRed = 0, pulledGreen = 0, pulledBlue = 0;

            var ballPulls = set.split(", ");

            for (String ballPull : ballPulls) {
                String[] pull = ballPull.split(" ");
                String color = pull[1];
                int number = Integer.parseInt(pull[0]);

                switch (color) {
                    case "blue" -> {
                        if ((number > maxBlue)) {
                            isGamePossible = false;
                        }
                    }
                    case "green" -> {
                        if ((number > maxGreen)) {
                            isGamePossible = false;
                        }
                    }
                    case "red" -> {
                        if ((number > maxRed)) {
                            isGamePossible = false;
                        }
                    }

                }
            }
        }
        resultsMap.put(gameId, isGamePossible);
    }

    private Integer parseResultMap() {
        return resultsMap.entrySet().stream().filter(Map.Entry::getValue).mapToInt(Map.Entry::getKey).sum();
    }
}
