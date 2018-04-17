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
    public void testSort() {
        Integer size = Integer.valueOf(dataInput.readLine());
        Integer[] inputItemsSelectionArray = new Integer[size];
        Integer[] inputItemsInsertionArray = new Integer[size];
        Integer[] inputItemsShellArray = new Integer[size];
        Integer[] inputItemsMergeArray = new Integer[size];
        Integer[] expectedItemsArray = new Integer[size];

        for (int i = 0; i < size; i++) {
            Integer inputItem = Integer.valueOf(dataInput.readString());
            inputItemsSelectionArray[i] = inputItem;
            inputItemsInsertionArray[i] = inputItem;
            inputItemsShellArray[i] = inputItem;
            inputItemsMergeArray[i] = inputItem;

            Integer expectedItem = Integer.valueOf(dataExpected.readString());
            expectedItemsArray[i] = expectedItem;
        }

        SelectionSort.sort(inputItemsSelectionArray);
        assertArrayEquals(inputItemsSelectionArray, expectedItemsArray);

        InsertionSort.sort(inputItemsInsertionArray);
        assertArrayEquals(inputItemsInsertionArray, expectedItemsArray);

        ShellSort.sort(inputItemsShellArray);
        assertArrayEquals(inputItemsShellArray, expectedItemsArray);

        MergeSort.sort(inputItemsMergeArray);
        assertArrayEquals(inputItemsMergeArray, expectedItemsArray);
    }
}