package com.shc.distanceCalc;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FareForPuneTest extends TestCase {

    FareForPune ffp;
    @Before
    public void setUp() throws Exception {
        ffp=new FareForPune();

    }

    @Test
    public void testMain() throws Exception {
    ffp.main(null);
        Assert.assertEquals("Equal :","Ticket Price : 20.0 Rs.",ffp.out);

    }
}