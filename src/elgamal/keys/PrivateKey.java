package elgamal.keys;

import java.math.BigInteger;

public class PrivateKey
{
    private BigInteger p;
    private BigInteger x;

    public PrivateKey(BigInteger p, BigInteger x)
    {
        this.p = p;
        this.x = x;
    }

    public BigInteger getP()
    {
        return p;
    }

    public void setP(BigInteger p)
    {
        this.p = p;
    }

    public BigInteger getX()
    {
        return x;
    }

    public void setX(BigInteger x)
    {
        this.x = x;
    }
}
