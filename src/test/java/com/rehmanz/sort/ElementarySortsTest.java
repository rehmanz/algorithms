package com.rehmanz.sort;

import edu.princeton.cs.algs4.stdlib.In;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import static org.junit.Assert.assertArrayEquals;

public class ElementarySortsTest {
    private static final Logger logger = Logger.getLogger(ElementarySortsTest.class);
    String  dataDir = new File(".").getAbsolutePath() + "/src/test/resources/sort/",
            unsortedItemsFile = "unsortedItems.txt",
            sortedItemsFile = "sortedItems.txt";
    In dataInput,
       dataExpected;
    SelectionSort selectionSort = new SelectionSort();

    @Before
    public void setUp() throws Exception {
        try {
            dataInput = new In(dataDir+unsortedItemsFile);
            dataExpected = new In(dataDir+sortedItemsFile);
        }
        catch (Exception e) { logger.error(e); }
    }

    @After
    public void tearDown() throws Exception {
        dataInput.close();
        dataExpected.close();
    }


    @Test
    public void testSelectionSort() {
        Integer size = Integer.valueOf(dataInput.readLine());
        Integer[] inputItemsArray = new Integer[size];
        Integer[] expectedItemsArray = new Integer[size];

        for (int i = 0; i < size; i++) {
            Integer inputItem = Integer.valueOf(dataInput.readString());
            inputItemsArray[i] = inputItem;

            Integer expectedItem = Integer.valueOf(dataExpected.readString());
            expectedItemsArray[i] = expectedItem;
        }

        selectionSort.sort(inputItemsArray);
        assertArrayEquals(inputItemsArray, expectedItemsArray);
    }
}