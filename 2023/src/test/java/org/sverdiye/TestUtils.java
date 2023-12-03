package org.sverdiye;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class TestUtils {

    public static List<String> readFile(int nOfTask) {
        String filePath = "data/%s.txt".formatted(nOfTask);
        try {
            URL resourceUri = TestUtils.class.getClassLoader().getResource(filePath);
            Stream<String> lines = Files.lines(Path.of(resourceUri.toURI()));

            return lines.toList();
        } catch (Exception e) {
            System.err.println("Error while reading file");
            throw new RuntimeException();
        }
    }
}
