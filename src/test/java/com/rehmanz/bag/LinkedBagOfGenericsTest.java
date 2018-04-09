package com.rehmanz.bag;

import edu.princeton.cs.algs4.stdlib.In;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class LinkedBagOfGenericsTest {
    private static final Logger logger = Logger.getLogger(LinkedBagOfGenericsTest.class);
    String  dataDir = new File(".").getAbsolutePath() + "/src/test/resources/bag/",
            dataInputFile = "marblesInput.txt",
            dataExpectedFile = "marblesExpected.txt";
    In dataInput,
       dataExpected;
    LinkedBagOfGenerics bag = new LinkedBagOfGenerics<String>();

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
        for (Object s : bag) {
            logger.debug(s);
        }
    }

    @Test
    public void testStack() {
        while (!dataInput.isEmpty()) {
            String item = dataInput.readString();
            bag.add(item);
        }

        String dataExpectedStr = dataExpected.readAll().trim();

        // iteration test
        String iterateActual = "";
        for (Object s : bag) {
            iterateActual += " " + (s);
        }
        assertEquals("Actual and expected values don't match",
                     iterateActual.trim(), dataExpectedStr);

    }
}