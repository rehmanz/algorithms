package com.rehmanz.stack;

//import com.rehmanz.stack.
import edu.princeton.cs.algs4.stdlib.In;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class StackTest {
    private static final Logger logger = Logger.getLogger(StackTest.class);
    String  dataDir = new File(".").getAbsolutePath() + "/src/test/resources/stack/",
            dataFile = "tobe.txt";
    In data;

    @Before
    public void setUp() throws Exception {
        try {
            logger.debug(dataDir);
            data = new In(dataDir+dataFile);
            //StackOfStrings stack = new StackOfStrings();
//            while (!StdIn.isEmpty()) {
//                String s = StdIn.readString();
//                //logger.entering(getClass().getName(), "doIt");
//
//            }

        }
        catch (Exception e) { System.out.println(e); }
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testStack() {

    }
}