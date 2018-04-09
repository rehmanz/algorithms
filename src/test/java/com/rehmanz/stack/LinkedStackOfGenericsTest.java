package com.rehmanz.stack;

import edu.princeton.cs.algs4.stdlib.In;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class LinkedStackOfGenericsTest {
    private static final Logger logger = Logger.getLogger(LinkedStackOfGenericsTest.class);
    String  dataDir = new File(".").getAbsolutePath() + "/src/test/resources/stack/",
            dataInputFile = "toBeInput.txt",
            dataExpectedFile = "toBeExpected.txt";
    In dataInput,
       dataExpected;
    LinkedStackOfGenerics stack = new LinkedStackOfGenerics<String>();

    @Before
    public void setUp() throws Exception {
        try {
            dataInput = new In(dataDir+dataInputFile);
            dataExpected = new In(dataDir+dataExpectedFile);

        }
        catch (Exception e) { logger.error(e); }
    }

    @After
    public void tearDown() throws Exception {
        dataInput.close();
        dataExpected.close();
    }

    @Test
    public void testIterable() {
        for (Object s : stack) {
            logger.debug(s);
        }
    }

    @Test
    public void testStack() {
        while (!dataInput.isEmpty()) {
            String item = dataInput.readString();
            if (item.equals("-")) {
                stack.pop();
            } else {
                stack.push(item);
            }
        }

        String dataExpectedStr = dataExpected.readAll().trim();

        // iteration test
        String iterateActual = "";
        for (Object s : stack) {
            iterateActual += " " + (s);
        }
        assertEquals("Actual and expected values don't match",
                     iterateActual.trim(), dataExpectedStr);

        // push and pop test
        String dataActual = "";
        while (!stack.isEmpty()) {
            dataActual += " " + (stack.pop());
        }
        assertEquals("Actual and expected values don't match",
                     dataActual.toString().trim(), dataExpectedStr);
    }
}