package elgamal.message;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public final class Message
{
    private BigInteger message;
    // split at 60

    public Message(String message)
    {
        this.message = new BigInteger(message.getBytes());
    }

    public Message(BigInteger message)
    {
        this.message = message;
    }

    public BigInteger getMessage()
    {
        return message;
    }

    public void setMessage(BigInteger message)
    {
        this.message = message;
    }

    public String toString()
    {
        return new String(message.toByteArray(), StandardCharsets.UTF_8);
    }
}
