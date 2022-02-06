import java.lang.Math;

public class Vector3d
{
    protected double x;
    protected double y;
    protected double z;

    public Vector3d()
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Vector3d(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getZ()
    {
        return z;
    }

    public double leng()
    {
        return Math.sqrt(Math.pow(this.x, 2)+ Math.pow(this.y, 2)+ Math.pow(this.z,2));
    }

    public Vector3d norm()
    {
        return this.div(this.leng());
    }

    public Vector3d add(Vector3d other)
    {
        return new Vector3d(this.x + other.getX(), this.y + other.getY(), this.z + other.getZ());
    }

    public Vector3d sub(Vector3d other)
    {
        return new Vector3d(this.x - other.getX(), this.y - other.getY(), this.z - other.getZ());
    }

    public Vector3d mul(double scaler)
    {
        return new Vector3d(this.x * scaler, this.y * scaler, this.z * scaler);
    }

    public Vector3d div(double scaler)
    {
        return new Vector3d(this.x / scaler, this.y / scaler, this.z / scaler);
    }

    public double dot(Vector3d other)
    {
        return (this.x*other.getX()) + (this.y*other.getY() + (this.z*other.getZ()));
    }

    public double dist(Vector3d other)
    {
        return Math.sqrt(
                Math.pow(other.getX() - this.x, 2) +
                Math.pow(other.getY() - this.y, 2) +
                Math.pow(other.getZ() - this.z,2)
        );
    }

    public Vector3d copy()
    {
        return new Vector3d(this.x, this.y, this.z);
    }

    @Override
    public boolean equals(Object o)
    {
        Vector3d v = (Vector3d) o;
        if((v.getX() == x) && (v.getY() == y) && (v.getZ() == z))
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        return "["+ this.x + ","+this.y + ","+this.z+"]";
    }
}