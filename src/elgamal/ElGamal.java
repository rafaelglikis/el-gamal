package elgamal;

import elgamal.keys.PrivateKey;
import elgamal.keys.PublicKey;
import elgamal.message.EncryptedMessage;
import elgamal.message.Message;
import elgamal.utils.Utils;

import java.math.BigInteger;
import java.util.Random;

/**
 * Security of the elgamal.ElGamal algorithm depends on the difficulty of computing discrete logs
 * in a large prime modulus
 * <p>
 * - Theorem 1 : a in [Z/Z[p]] then a^(p-1) [p] = 1
 * - Theorem 2 : the order of an element split the order group
 */
public final class ElGamal
{
    private PublicKey publicKey;
    private PrivateKey privateKey;
    private int keySize;

    public ElGamal()
    {
        this.generateKeys(128);
        keySize = 128;
    }

    /**
     * Generate the public key and the secret key for the elgamal.ElGamal encryption.
     *
     * @param n key size
     */
    public void generateKeys(int n)
    {
        keySize = n;
        // (a) take a random prime p with generatePrime() function. p = 2 * p' + 1 with prime(p') = true
        BigInteger p = Utils.generatePrime(n, 10, new Random());
        // (b) take a random element in [Z/Z[p]]* (p' order)
        BigInteger g = Utils.randomNumber(p, new Random());
        BigInteger pPrime = p.subtract(BigInteger.ONE).divide(new BigInteger("2"));
        

        while (!g.modPow(pPrime, p).equals(BigInteger.ONE)) {
            if (g.modPow(pPrime.multiply(new BigInteger("2")), p).equals(BigInteger.ONE))
                g = g.modPow(new BigInteger("2"), p);
            else
                g = Utils.randomNumber(p, new Random());
        }

        // (c) take x random in [0, p' - 1]
        BigInteger x = Utils.randomNumber(pPrime.subtract(BigInteger.ONE), new Random());
        BigInteger h = g.modPow(x, p);
        // secret key is (p, x) and public key is (p, g, h)
        this.publicKey = new PublicKey(p, g, h);
        this.privateKey = new PrivateKey(p, x);
    }

    /**
     * encrypt elgamal.ElGamal
     *
     * @param publicKey PublicKey
     * @param msg message
     */
    public EncryptedMessage encrypt(Message msg, PublicKey publicKey) throws Exception
    {
        BigInteger message = msg.getMessage();
        BigInteger p = publicKey.getP();
        BigInteger g = publicKey.getG();
        BigInteger h = publicKey.getH();
        
        if (p.compareTo(msg.getMessage()) != 1)
            throw new Exception("Message is to long!");


        BigInteger pPrime = p.subtract(BigInteger.ONE).divide(new BigInteger("2"));
        // TODO [0, N -1] or [1, N-1] ?
        BigInteger r = Utils.randomNumber(pPrime, new Random());
        // encrypt couple (g^r, m * h^r)
        return new EncryptedMessage(
                g.modPow(r, p),
                message.multiply(h.modPow(r, p))
        );
    }

    /**
     * decrypt elgamal.ElGamal
     *
     * @return the decrypted message
     */
    public Message decrypt(EncryptedMessage encryptedMessage)
    {
        BigInteger gr = encryptedMessage.getGr();
        BigInteger mhr = encryptedMessage.getMhr();
        BigInteger p = this.privateKey.getP();
        BigInteger x = this.privateKey.getX();

        BigInteger hr = gr.modPow(x, p);

        return new Message(mhr.multiply(hr.modInverse(p)).mod(p));
    }

    public PublicKey getPublicKey()
    {
        return publicKey;
    }
    
    public PrivateKey getPrivateKey()
    {
        return privateKey;
    }
}