package com.rehmanz.dynamic_connectivity;

import edu.princeton.cs.algs4.stdlib.In;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class QuickFindUFTest {
    private static final Logger logger = Logger.getLogger(QuickUnionUF.class);
    String  dataDir = new File(".").getAbsolutePath() + "/src/test/resources/dynamic_connectivity/",
            dataFile = "tinyUF.txt";
    In data;
    QuickFindUF uf;

    @Before
    public void setUp() throws Exception {
        try {
            logger.debug(dataDir);
            data = new In(dataDir+dataFile);
            int N = data.readInt();
            uf = new QuickFindUF(N);

        }
        catch (Exception e) { System.out.println(e); }
    }

    @After
    public void tearDown() throws Exception {
        data.close();
    }

    @Test
    public void testQuickUnionUF() {
        while (!data.isEmpty()) {
            int p = data.readInt();
            int q = data.readInt();

            if (!uf.connected(p, q)) {
                uf.union(p, q);
                logger.info(p + " " + q);
            }
        }
    }
}