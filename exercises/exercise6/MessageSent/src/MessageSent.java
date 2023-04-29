import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.Base64;

public class MessageSent {

    public static void main(String[] args) throws Exception {

        // Generate AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(192);
        SecretKey aesKey = keyGen.generateKey();

        // Initialize cipher for AES encryption and decryption
        Cipher aesCipher = Cipher.getInstance("AES/GCM/NoPadding");

        // Generate RSA key pair for Alice and Bob
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(1024);
        KeyPair aliceKeyPair = keyPairGen.generateKeyPair();
        KeyPair bobKeyPair = keyPairGen.generateKeyPair();

        // Initialize cipher for RSA encryption and decryption
        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        // Alice sends an encrypted message to Bob using symmetric encryption
        String plainText = "Hello Bob, this is Alice.";
        byte[] iv = new byte[10]; // Initialization vector for AES/GCM
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        aesCipher.init(Cipher.ENCRYPT_MODE, aesKey, new GCMParameterSpec(128, iv));
        byte[] cipherText = aesCipher.doFinal(plainText.getBytes());
        System.out.println("Encrypted message: " + Base64.getEncoder().encodeToString(cipherText));

        // Bob receives the encrypted message from Alice and decrypts it using symmetric encryption
        aesCipher.init(Cipher.DECRYPT_MODE, aesKey, new GCMParameterSpec(128, iv));
        byte[] decryptedText = aesCipher.doFinal(cipherText);
        System.out.println("Decrypted message: " + new String(decryptedText));

        // Alice sends an encrypted message to Bob using asymmetric encryption
        plainText = "Hello Bob, this is Alice sending you a message with asymmetric encryption.";
        rsaCipher.init(Cipher.ENCRYPT_MODE, bobKeyPair.getPublic());
        cipherText = rsaCipher.doFinal(plainText.getBytes());
        System.out.println("Encrypted message: " + Base64.getEncoder().encodeToString(cipherText));

        // Bob receives the encrypted message from Alice and decrypts it using asymmetric encryption
        rsaCipher.init(Cipher.DECRYPT_MODE, bobKeyPair.getPrivate());
        decryptedText = rsaCipher.doFinal(cipherText);
        System.out.println("Decrypted message: " + new String(decryptedText));

        // Alice signs a message and sends it to Bob
        plainText = "Hello Bob, this is Alice and I have signed this message.";
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(aliceKeyPair.getPrivate());
        signature.update(plainText.getBytes());
        byte[] signatureBytes = signature.sign();
        System.out.println("Signed message: " + Base64.getEncoder().encodeToString(signatureBytes));

        // Bob receives the signed message from Alice and verifies the signature
        signature.initVerify(aliceKeyPair.getPublic());
        signature.update(plainText.getBytes());
        boolean verified = signature.verify(signatureBytes);
        System.out.println("Is the signature verified? " + verified);
    }
}

