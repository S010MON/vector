
public class Vector
{
    private double[] v;

    public Vector(double... v)
    {
        this.v = new double[v.length];
        for (int i = 0; i < v.length; i++)
        {
            this.v[i] = v[i];
        }
    }

    public int dims()
    {
        return v.length;
    }

    public double get(int i)
    {
        if (i >= v.length)
            throw new RuntimeException("Cannot access dim " + i + " in vector length " + v.length);
        return v[i];
    }

    public Vector copy()
    {
        return new Vector(v);
    }

    public Vector add(Vector u)
    {
        double[] out = new double[this.v.length];
        for (int i = 0; i < out.length; i++)
        {
            out[i] = get(i) + u.get(i);
        }
        return new Vector(out);
    }

    public Vector sub(Vector u)
    {
        double[] out = new double[this.v.length];
        for (int i = 0; i < out.length; i++)
        {
            out[i] = get(i) - u.get(i);
        }
        return new Vector(out);
    }

    public Vector mul(double d)
    {
        double[] out = new double[this.v.length];
        for (int i = 0; i < out.length; i++)
        {
            out[i] = get(i) * d;
        }
        return new Vector(out);
    }

    public Vector div(double d)
    {
        double[] out = new double[this.v.length];
        for (int i = 0; i < out.length; i++)
        {
            out[i] = get(i) / d;
        }
        return new Vector(out);
    }

    public double dot(Vector u)
    {
        if (u.dims() != v.length)
            throw new RuntimeException("Dimension mismatch v:" + v.length + " is not equal to u:" + u.dims());

        double sum = 0;
        for(int i = 0; i < v.length; i ++)
        {
            sum = sum + (get(i) * u.get(i));
        }
        return sum;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("[");
        for(double d: v)
        {
            sb.append(v).append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o)
    {
        if(! (o instanceof Vector))
            return false;

        Vector u = (Vector) o;
        if(u.dims() != this.dims())
            return false;

        for(int i = 0; i < v.length; i++)
        {
            if(u.get(i) != v[i])
                return false;
        }

        return true;
    }
}
