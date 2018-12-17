package elgamal.message;

import java.math.BigInteger;

public final class EncryptedMessage
{
    private BigInteger gr;
    private BigInteger mhr;

    public EncryptedMessage(BigInteger gr, BigInteger mhr)
    {
        this.gr = gr;
        this.mhr = mhr;
    }

    public BigInteger getGr()
    {
        return gr;
    }

    public void setGr(BigInteger gr)
    {
        this.gr = gr;
    }

    public BigInteger getMhr()
    {
        return mhr;
    }

    public void setMhr(BigInteger mhr)
    {
        this.mhr = mhr;
    }
}
