package elgamal.keys;

import java.math.BigInteger;

public class PrivateKey
{
    private BigInteger x;

    public PrivateKey(BigInteger x)
    {
        this.x = x;
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
