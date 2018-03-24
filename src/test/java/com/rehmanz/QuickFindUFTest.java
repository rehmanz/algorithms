package com.rehmanz;

import com.rehmanz.dynamice_connectivity.QuickFindUF;
import edu.princeton.cs.algs4.stdlib.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;

public class QuickFindUFTest {
    String  dataDir = new File(".").getAbsolutePath() + "/src/test/resources/data/",
            dataFile = "tinyUF.txt";
    In data;
    QuickFindUF uf;

    @Before
    public void setUp() throws Exception {
        try {
            System.out.println(dataDir);
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
                System.out.println(p + " " + q);
            }
        }
    }
}