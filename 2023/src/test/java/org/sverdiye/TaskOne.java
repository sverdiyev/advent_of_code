package org.sverdiye;

import org.junit.jupiter.api.Test;

import java.util.List;

public class TaskOne {

    @Test
    public void partOne() {
        List<String> lines = TestUtils.readFile(1);
        System.out.println(lines);

    }
}
