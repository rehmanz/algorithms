package com.rehmanz.queue;

import edu.princeton.cs.algs4.stdlib.In;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class LinkedQueueOfGenericsTest {
    private static final Logger logger = Logger.getLogger(LinkedQueueOfGenericsTest.class);
    String  dataDir = new File(".").getAbsolutePath() + "/src/test/resources/queue/",
            dataInputFile = "taskInput.txt",
            dataExpectedFile = "outputExpected.txt";
    In dataInput,
       dataExpected;
    LinkedQueueOfGenerics q = new LinkedQueueOfGenerics<String>();

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
    public void testQueue() {
        while (!dataInput.isEmpty()) {
            String item = dataInput.readString();
            q.enqueue(item);

        }

        String dataActual = "";
        while (!q.isEmpty()) {
            dataActual += " " + (q.dequeue());
        }

        assertEquals("Actual and expected values don't match",
                     dataActual.toString().trim(),
                     dataExpected.readAll().trim());
    }
}