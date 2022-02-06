import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestVector2d
{
    @Test void createDefaultVector()
    {
        Vector2d v = new Vector2d();
        assertEquals(0d, v.getX());
        assertEquals(0d, v.getY());
    }

    @Test void createSpecifiedVector()
    {
        Vector2d v = new Vector2d(10,-10);
        assertEquals(10d, v.getX());
        assertEquals(-10d, v.getY());
    }

    @Test void createArrayVector()
    {
        double[] a = {10, -10};
        Vector2d v = new Vector2d(a);
        assertEquals(10d, v.getX());
        assertEquals(-10d, v.getY());
    }

    @Test void createArrayVectorTooLarge()
    {
        double[] a = {10, 11, 12};
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            new Vector2d(a);
        });
        assertEquals("Vector 2d must take in an array of length 2", exception.getMessage());
    }

    @Test void createArrayVectorTooSmall()
    {
        double[] a = {10};
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            new Vector2d(a);
        });
        assertEquals("Vector 2d must take in an array of length 2", exception.getMessage());
    }

    @Test void addVectorPos()
    {
        Vector2d v = new Vector2d(10,10);
        Vector2d u = new Vector2d(0.5,0.5);
        Vector2d t = v.add(u);
        assertEquals(10.5d, t.getX());
        assertEquals(10.5d, t.getY());
    }

    @Test void addVectorNeg()
    {
        Vector2d v = new Vector2d(10,10);
        Vector2d u = new Vector2d(-0.5,-0.5);
        Vector2d t = v.add(u);
        assertEquals(9.5d, t.getX());
        assertEquals(9.5d, t.getY());
    }

    @Test void subVectorPos()
    {
        Vector2d v = new Vector2d(10,10);
        Vector2d u = new Vector2d(0.5,0.5);
        Vector2d t = v.sub(u);
        assertEquals(9.5d, t.getX());
        assertEquals(9.5d, t.getY());
    }

    @Test void subVectorNeg()
    {
        Vector2d v = new Vector2d(10,10);
        Vector2d u = new Vector2d(-0.5,-0.5);
        Vector2d t = v.sub(u);
        assertEquals(10.5d, t.getX());
        assertEquals(10.5d, t.getY());
    }

    @Test void scaleVectorPos()
    {
        Vector2d v = new Vector2d(10,10);
        Vector2d t = v.scale(10);
        assertEquals(100d, t.getX());
        assertEquals(100d, t.getY());
    }

    @Test void scaleVectorNeg()
    {
        Vector2d v = new Vector2d(10,10);
        Vector2d t = v.scale(-1);
        assertEquals(-10d, t.getX());
        assertEquals(-10d, t.getY());
    }

    @Test void testDotPos()
    {
        Vector2d v = new Vector2d(10,10);
        Vector2d u = new Vector2d(10,10);
        double dotProduct = u.dot(v);
        assertEquals(200, dotProduct);
    }

    @Test void testDotNeg()
    {
        Vector2d v = new Vector2d(10,10);
        Vector2d u = new Vector2d(-12,-7);
        double dotProduct = u.dot(v);
        assertEquals(-190, dotProduct);
    }

    @Test void testCrossPos()
    {
        Vector2d v = new Vector2d(40,0);
        Vector2d u = new Vector2d(0,40);
        double crossProduct = u.cross(v);
        assertEquals(1600, crossProduct);
    }

    @Test void testCrossNeg()
    {
        Vector2d v = new Vector2d(10,10);
        Vector2d u = new Vector2d(-12,-7);
        double crossProduct = u.cross(v);
        assertEquals(50, crossProduct);
    }

    @Test void rotate360()
    {
        Vector2d u = new Vector2d(0,10);
        Vector2d v = u.rotate(360);
        assertEquals(v.getX(), u.getX(), 0.001);
        assertEquals(v.getY(), u.getY(), 0.001);
    }

    @Test void rotate180()
    {
        Vector2d u = new Vector2d(0,10);
        Vector2d v = u.rotate(180);
        assertEquals(v.getX(), 0, 0.001);
        assertEquals(v.getY(), -10, 0.001);
    }

    @Test void rotate90()
    {
        Vector2d u = new Vector2d(0,10);
        Vector2d v = u.rotate(90);
        assertEquals(v.getX(), -10, 0.001);
        assertEquals(v.getY(), 0, 0.001);
    }

    @Test void rotate9()
    {
        Vector2d u = new Vector2d(10,0);
        u = u.rotate(9);
        assertEquals(9.87, u.getX(), 0.01);
        assertEquals(1.56, u.getY(), 0.01);
    }
}