package elgamal.utils;

import java.math.BigInteger;
import java.util.Random;

public final class Utils
{
    /**
     * Return a prime p = 2 * p' + 1
     *
     * @param nb_bits   is the prime representation
     * @param certainty probability to find a prime integer
     * @param prg       random
     * @return p
     */
    public static BigInteger generatePrime(int nb_bits, int certainty, Random prg)
    {
        BigInteger pPrime = new BigInteger(nb_bits, certainty, prg);
        // p = 2 * pPrime + 1
        BigInteger p = pPrime.multiply(new BigInteger("2")).add(BigInteger.ONE);

        while (!p.isProbablePrime(certainty)) {
            pPrime = new BigInteger(nb_bits, certainty, prg);
            p = pPrime.multiply(new BigInteger("2")).add(BigInteger.ONE);
        }

        return p;
        //return new BigInteger("2456037405492238266955614353403832150268620906464759815524439");
    }

    /**
     * Return a random integer in [0, N - 1]
     *
     * @param N
     * @param prg
     * @return
     */
    public static BigInteger randomNumber(BigInteger N, Random prg)
    {
        return new BigInteger(N.bitLength() + 100, prg).mod(N);
    }
}
