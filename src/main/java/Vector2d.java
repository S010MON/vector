
public class Vector2d
{
    private double x;
    private double y;

    public Vector2d()
    {
        this.x = 0d;
        this.y = 0d;
    }

    public Vector2d(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2d(double ... v)
    {
        if(v.length != 2)
            throw new RuntimeException("Vector 2d must take in an array of length 2");
        this.x = v[0];
        this.y = v[1];
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double leng()
    {
        return Math.sqrt(Math.pow(this.x, 2)+ Math.pow(this.y, 2));
    }

    public Vector2d norm()
    {
        double leng = this.leng();
        return new Vector2d(this.x/leng, this.y/leng);
    }

    public Vector2d add(Vector2d other)
    {
        return new Vector2d(this.x + other.getX(), this.y + other.getY());
    }

    public Vector2d sub(Vector2d other)
    {
        return new Vector2d(this.x - other.getX(), this.y - other.getY());
    }

    public double cross(Vector2d other)
    {
        double a = (this.getY() * other.getX());
        double b = (this.getX() * other.getY());
        return a - b;
    }

    public double dot(Vector2d other)
    {
        return (this.getX() * other.getX()) + (this.getY() * other.getY());
    }

    public Vector2d scale(double scalar)
    {
        return new Vector2d(this.getX() * scalar, this.getY() * scalar);
    }

    public double dist(Vector2d vector)
    {
        double a = Math.pow((this.getX() - vector.getX()),2);
        double b = Math.pow((this.getY() - vector.getY()),2);
        return Math.sqrt(a + b);
    }

    public Vector2d rotate(double degrees)
    {
        RotationMatrix M = new RotationMatrix(degrees);
        return M.dot(this);
    }

    public Vector2d copy()
    {
        return new Vector2d(x, y);
    }

    @Override
    public boolean equals(Object other)
    {
        if(other instanceof Vector2d)
        {
            Vector2d v = (Vector2d) other;
            return this.getX() == v.getX() && this.getY() == v.getY();
        }
        return false;
    }
}

class RotationMatrix
{
    private double a1;
    private double a2;
    private double b1;
    private double b2;

    /** a matrix in the form:
     * [ a1 a2 ]
     * [ b1 b2 ] */
    public RotationMatrix(double theta)
    {
        double cosA = Math.cos(Math.toRadians(theta));
        double sinA = Math.sin(Math.toRadians(theta));
        this.a1 = cosA;
        this.a2 = -sinA;
        this.b1 = sinA;
        this.b2 = cosA;
    }

    public Vector2d dot(Vector2d v)
    {
        double x = (a2 * v.getY()) + (a1 * v.getX());
        double y = (b2 * v.getY()) + (b1 * v.getX());
        return new Vector2d(x, y);
    }
}