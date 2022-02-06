import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestVector
{
    @Test void createVector2d()
    {
        Vector v = new Vector(1, 2);
        assertEquals(1d, v.get(0));
        assertEquals(2d, v.get(1));
        assertEquals(2, v.dims());
    }

    @Test void createVector3d()
    {
        Vector v = new Vector(1, 2, 3);
        assertEquals(1d, v.get(0));
        assertEquals(2d, v.get(1));
        assertEquals(3d, v.get(2));
        assertEquals(3, v.dims());
    }

    @Test void outOfDimensionIndex()
    {
        Vector v = new Vector(1, 2, 3);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            v.get(4);
        });
        assertEquals("Cannot access dim 4 in vector length 3", exception.getMessage());
    }

    @Test void copy()
    {
        Vector v = new Vector(1, 2, 3);
        Vector u = v.copy();
        assertEquals(1d, u.get(0));
        assertEquals(2d, u.get(1));
        assertEquals(3d, u.get(2));
        assertEquals(3, u.dims());
    }

    @Test void equalsObject()
    {
        Vector v = new Vector(1, 2, 3);
        Double u = 10d;
        assertFalse(v.equals(u));
    }

    @Test void equalsDims()
    {
        Vector v = new Vector(1, 2, 3);
        Vector u = new Vector(1, 2, 3, 4);
        assertNotEquals(v, u);
    }

    @Test void equalsValues()
    {
        Vector v = new Vector(1, 2, 3);
        Vector u = new Vector(1, 2, 2);
        assertNotEquals(v, u);
    }

    @Test void equalsTrue()
    {
        Vector v = new Vector(1, 2, 3);
        Vector u = new Vector(1, 2, 3);
        assertEquals(v, u);
    }

    @Test void add2dPos()
    {
        Vector v = new Vector(10,10);
        Vector u = new Vector(0.5,0.5);
        Vector t = v.add(u);
        assertEquals(10.5d, t.get(0));
        assertEquals(10.5d, t.get(1));
    }

    @Test void add2dNeg()
    {
        Vector v = new Vector(10,10);
        Vector u = new Vector(-0.5,-0.5);
        Vector t = v.add(u);
        assertEquals(9.5d, t.get(0));
        assertEquals(9.5d, t.get(1));
    }

    @Test void sub2dPos()
    {
        Vector v = new Vector(10,10);
        Vector u = new Vector(0.5,0.5);
        Vector t = v.sub(u);
        assertEquals(9.5d, t.get(0));
        assertEquals(9.5d, t.get(1));
    }

    @Test void sub2dNeg()
    {
        Vector v = new Vector(10,10);
        Vector u = new Vector(-0.5,-0.5);
        Vector t = v.sub(u);
        assertEquals(10.5d, t.get(0));
        assertEquals(10.5d, t.get(1));
    }

    @Test void add3d()
    {
        Vector a = new Vector(-1.1, 0.1, 1.1);
        Vector b = new Vector( 0.5, 0.6, 0.7);
        Vector ab = a.add(b);
        assertEquals(-1.1+0.5, ab.get(0));
        assertEquals( 0.1+0.6, ab.get(1));
        assertEquals( 1.1+0.7, ab.get(2));
    }

    @Test void sub3d()
    {
        Vector a = new Vector(-1.1, 0.1, 1.1);
        Vector b = new Vector( 0.5, 0.6, 0.7);
        Vector ab = a.sub(b);
        assertEquals(-1.1-0.5, ab.get(0));
        assertEquals( 0.1-0.6, ab.get(1));
        assertEquals( 1.1-0.7, ab.get(2));
    }

    @Test void mul2dPos()
    {
        Vector v = new Vector(10,10);
        Vector t = v.mul(10);
        assertEquals(100d, t.get(0));
        assertEquals(100d, t.get(1));
    }

    @Test void mul2dNeg()
    {
        Vector v = new Vector(10,10);
        Vector t = v.mul(-1);
        assertEquals(-10d, t.get(0));
        assertEquals(-10d, t.get(1));
    }

    @Test void mul3dPos()
    {
        Vector a = new Vector(-1.1, 0.1, 1.1);
        Vector b = a.mul(0.5);
        assertEquals(-1.1*0.5, b.get(0));
        assertEquals( 0.1*0.5, b.get(1));
        assertEquals( 1.1*0.5, b.get(2));
    }

    @Test void mul3dNeg()
    {
        Vector a = new Vector(-1.1, 0.1, 1.1);
        Vector b = a.mul(-0.5);
        assertEquals(-1.1*-0.5, b.get(0));
        assertEquals( 0.1*-0.5, b.get(1));
        assertEquals( 1.1*-0.5, b.get(2));
    }

    @Test void div2dPos()
    {
        Vector v = new Vector(10,10);
        Vector t = v.div(10);
        assertEquals(1d, t.get(0));
        assertEquals(1d, t.get(1));
    }

    @Test void div2dNeg()
    {
        Vector v = new Vector(10,10);
        Vector t = v.div(-1);
        assertEquals(-10d, t.get(0));
        assertEquals(-10d, t.get(1));
    }

    @Test void div3dPos()
    {
        Vector a = new Vector(-1.1, 0.1, 1.1);
        Vector b = a.div(0.5);
        assertEquals(-1.1/0.5, b.get(0));
        assertEquals( 0.1/0.5, b.get(1));
        assertEquals( 1.1/0.5, b.get(2));
    }

    @Test void div3dNeg()
    {
        Vector a = new Vector(-1.1, 0.1, 1.1);
        Vector b = a.div(-0.5);
        assertEquals(-1.1/-0.5, b.get(0));
        assertEquals( 0.1/-0.5, b.get(1));
        assertEquals( 1.1/-0.5, b.get(2));
    }

    @Test void dotPos()
    {
        Vector v = new Vector(10,10);
        Vector u = new Vector(10,10);
        double dotProduct = u.dot(v);
        assertEquals(200, dotProduct);
    }

    @Test void dotNeg()
    {
        Vector v = new Vector(10,10);
        Vector u = new Vector(-12,-7);
        double dotProduct = u.dot(v);
        assertEquals(-190, dotProduct);
    }

    @Test void dotMismatch()
    {
        Vector v = new Vector(1, 2, 3);
        Vector u = new Vector(1, 2, 3, 4);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            v.dot(u);
        });
        assertEquals("Dimension mismatch v:3 is not equal to u:4" , exception.getMessage());
    }

}
