import java.math.BigInteger;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws GeneralSecurityException {


       /* System.out.println("For Public Key KeySpec:===================\n");

        System.out.println("Your Public Key Big Prime Number (512) bit length (modulus param): ");
        BigInteger pubPrime = BigInteger.probablePrime(512,new Random());
        System.out.println(" Hex:  " + pubPrime.toString(16) + "\n");
        System.out.println(" Dec:  " + pubPrime.toString(10) + "\n");

        BigInteger pubSmallPrime = BigInteger.probablePrime(8,new Random());
        System.out.println("Your Public Key Small Prime Number (8) bit length (publicExponent param): ");
        System.out.println(" Hex:  " + pubSmallPrime.toString(16) + "\n");
        System.out.println(" Dec:  " + pubSmallPrime.toString(10) + "\n");

        System.out.println("End Public Key KeySpec:===================\n");

        System.out.println("For Private Key KeySpec:===================\n");


        System.out.println("Your Private Key Big Prime Number (512) bit length (modulus param): ");
        BigInteger privatePrime = BigInteger.probablePrime(512,new Random());
        System.out.println(" Hex:  " + privatePrime.toString(16) + "\n");
        System.out.println(" Dec:  " + privatePrime.toString(10) + "\n");

        BigInteger privateSmallPrime1 = BigInteger.probablePrime(8,new Random());
        System.out.println("=====Your Private Key Small Prime Number (8) bit length (publicExponent param): =======");
        System.out.println(" Hex:  " + privateSmallPrime1.toString(16) + "\n");
        System.out.println(" Dec:  " + privateSmallPrime1.toString(10) + "\n");







        BigInteger privateSmallPrime2 = BigInteger.probablePrime(16,new Random());
        System.out.println("=====Your Private Key Small Prime Number (16) bit length (publicExponent param):  =======");
        System.out.println(" Hex:  " + privateSmallPrime2.toString(16) + "\n");
        System.out.println(" Dec:  " + privateSmallPrime2.toString(10) + "\n");



        System.out.println("End Private Key KeySpec:===================\n");*/


        System.out.println("Public Key KeySpec:===================\n");
        PublicKey publicKey =getPublicKey();
        KeyFactory keyFacPublic = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec pkSpecpublic = keyFacPublic.getKeySpec(publicKey, RSAPublicKeySpec.class);
        System.out.println("Modulus : " + pkSpecpublic.getModulus().toString(16));
        System.out.println("Public exponent : " + pkSpecpublic.getPublicExponent().toString(16));

        System.out.println("Private Key KeySpec:===================\n");
        PrivateKey priv =getPrivateKey();

        KeyFactory keyFac = KeyFactory.getInstance("RSA");
        RSAPrivateCrtKeySpec pkSpec = keyFac.getKeySpec(priv, RSAPrivateCrtKeySpec.class);
        System.out.println("Modulus : " + pkSpec.getModulus().toString(16));
        System.out.println("Public exponent : " + pkSpec.getPublicExponent().toString(16));
        System.out.println("Private exponent : " + pkSpec.getPrivateExponent().toString(16));
        System.out.println("Prime primeP  : " + pkSpec.getPrimeP().toString(16));
        System.out.println("Prime primeQ  : " + pkSpec.getPrimeQ().toString(16));
        System.out.println("Prime exponent p : " + pkSpec.getPrimeExponentP().toString(16));
        System.out.println("Prime exponent q : " + pkSpec.getPrimeExponentQ().toString(16));
        System.out.println("crtCoefficient : " + pkSpec.getCrtCoefficient().toString(16));



    }

    private static PrivateKey getPrivateKey() throws GeneralSecurityException
    {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(512);
        return kpg.generateKeyPair().getPrivate();
    }

    private static PublicKey getPublicKey() throws GeneralSecurityException
    {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(512);
        return kpg.generateKeyPair().getPublic();
    }

}
