
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestVector3d
{
    Vector3d a = new Vector3d(2,5,-4);
    Vector3d b = new Vector3d(-2,-3,-5);

    @Test void testGetX()
    {
        Vector3d v = new Vector3d(-1.1, 0.1, 1.1);
        assertEquals(-1.1, v.getX());
    }

    @Test void testGetY()
    {
        Vector3d v = new Vector3d(-1.1, 0.1, 1.1);
        assertEquals(0.1, v.getY());
    }

    @Test void testGetZ()
    {
        Vector3d v = new Vector3d(-1.1, 0.1, 1.1);
        assertEquals(1.1, v.getZ());
    }

    @Test void testAdd()
    {
        Vector3d a = new Vector3d(-1.1, 0.1, 1.1);
        Vector3d b = new Vector3d( 0.5, 0.6, 0.7);
        Vector3d ab = a.add(b);
        assertEquals(-1.1+0.5, ab.getX());
        assertEquals( 0.1+0.6, ab.getY());
        assertEquals( 1.1+0.7, ab.getZ());
    }

    @Test void testSub()
    {
        Vector3d a = new Vector3d(-1.1, 0.1, 1.1);
        Vector3d b = new Vector3d( 0.5, 0.6, 0.7);
        Vector3d ab = a.sub(b);
        assertEquals(-1.1-0.5, ab.getX());
        assertEquals( 0.1-0.6, ab.getY());
        assertEquals( 1.1-0.7, ab.getZ());
    }

    @Test void testMul()
    {
        Vector3d a = new Vector3d(-1.1, 0.1, 1.1);
        Vector3d b = a.mul(0.5);
        assertEquals(-1.1*0.5, b.getX());
        assertEquals( 0.1*0.5, b.getY());
        assertEquals( 1.1*0.5, b.getZ());
    }

    @Test
    void testNorm()
    {
        Vector3d q = a.norm();
        assertEquals(0.29814239699997197, q.getX());
        assertEquals(0.7453559924999299, q.getY());
        assertEquals(-0.5962847939999439, q.getZ());
    }

    @Test void testDist()
    {
        Vector3d a = new Vector3d(3.0, 4.0,  8.0);
        Vector3d b = new Vector3d(0.5, 0.25, 0.5);
        assertEquals(8.75, a.dist(b));
    }

    @Test
    void testDotProduct()
    {
        assertEquals(1,a.dot(b));
    }


    @Test
    void testScalarMultiple()
    {
        Vector3d q = a.mul(5);
        assertEquals(10, q.getX());
        assertEquals(25, q.getY());
        assertEquals(-20, q.getZ());
    }
    @Test
    void testDistance()
    {
        assertEquals(9, a.dist(b));
    }

    @Test
    void testEquals()
    {
        Vector3d trial1 = new Vector3d(1, 2, 3);
        Vector3d trial2 = new Vector3d(1, 2, 3);
        assertEquals(true, trial1.equals(trial2));
    }

    @Test void testToString()
    {
        Vector3d v = new Vector3d(-1.1, 2.1, -3.1);
        String stringV = "[-1.1,2.1,-3.1]";
        assertEquals(stringV, v.toString());
    }
}