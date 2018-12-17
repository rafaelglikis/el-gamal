package elgamal.keys;

import java.math.BigInteger;

public class PublicKey
{
    private BigInteger p;
    private BigInteger g;
    private BigInteger h;

    public PublicKey(BigInteger p, BigInteger g, BigInteger h)
    {
        this.p = p;
        this.g = g;
        this.h = h;
    }

    public BigInteger getP()
    {
        return p;
    }

    public void setP(BigInteger p)
    {
        this.p = p;
    }

    public BigInteger getG()
    {
        return g;
    }

    public void setG(BigInteger g)
    {
        this.g = g;
    }

    public BigInteger getH()
    {
        return h;
    }

    public void setH(BigInteger h)
    {
        this.h = h;
    }
}
