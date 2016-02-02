package tw.test;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import tw.boardgame.Computer;

import static org.junit.Assert.*;

public class ComputerTest extends TestCase {


    Computer comp;

    @Before
    public void setUp() throws Exception {
        comp=new Computer();
    }


    /**
     * Test Cases for Different user Input
     * @throws Exception
     */
    @Test
    public void testChekForHitOrMiss() throws Exception {
      Assert.assertEquals("HIT", comp.chekForHitOrMiss("A2"));
      Assert.assertEquals("MISS", comp.chekForHitOrMiss("A9"));
      Assert.assertEquals("MISS", comp.chekForHitOrMiss("A8"));
      Assert.assertEquals("MISS", comp.chekForHitOrMiss("B2"));

      Assert.assertEquals("HIT", comp.chekForHitOrMiss("A1"));
      Assert.assertEquals("HIT", comp.chekForHitOrMiss("A3"));
      Assert.assertEquals("SINK", comp.chekForHitOrMiss("A4"));

      Assert.assertEquals("HIT", comp.chekForHitOrMiss("C1"));
      Assert.assertEquals("HIT", comp.chekForHitOrMiss("C2"));
      Assert.assertEquals("HIT", comp.chekForHitOrMiss("C3"));
      Assert.assertEquals("HIT", comp.chekForHitOrMiss("C4"));
      Assert.assertEquals("SINK", comp.chekForHitOrMiss("C5"));

      Assert.assertEquals("HIT", comp.chekForHitOrMiss("E1"));
      Assert.assertEquals("HIT", comp.chekForHitOrMiss("E2"));
      Assert.assertEquals("SINK", comp.chekForHitOrMiss("E3"));

      Assert.assertEquals("HIT", comp.chekForHitOrMiss("G1"));
      Assert.assertEquals("YOU WIN", comp.chekForHitOrMiss("G2"));


    }
}