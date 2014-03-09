package com.lifeplan.config.security.util;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SignatureException;

/**
 * Created on 2/25/14.
 */
public class HMACUtil {

    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";

    public static void main(String[] args) {
        try {
            String clientSecretKey = "clientSecretKey";

            String username = "kanth";
            String publicKey = "mypublickey";
            String authToken = "authToken";
            long d = System.currentTimeMillis();
            String encryptionText = username + authToken + d;
            System.out.println(encryptionText);
            long d1 = System.currentTimeMillis() + 1000;
            String encryptionText1 = username + authToken + d1;
            System.out.println(encryptionText1);
            System.out.println(HMACUtil.calculateRFC2104HMAC(encryptionText, "secretKey"));
            System.out.println(HMACUtil.calculateRFC2104HMAC(encryptionText1, "secretKey"));
            System.out.println(HMACUtil.calculateRFC2104HMAC("", "secretKey"));
        } catch (SignatureException e) {
            e.printStackTrace();
        }
    }

    /**
     * Computes RFC 2104-compliant HMAC signature.
     * * @param data
     * The data to be signed.
     *
     * @param key The signing key.
     * @return The Base64-encoded RFC 2104-compliant HMAC signature.
     * @throws java.security.SignatureException when signature generation fails
     */
    public static String calculateRFC2104HMAC(String data, String key)
            throws java.security.SignatureException {
        String result;
        try {
            // get an hmac_sha1 key from the raw key bytes
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA256_ALGORITHM);

            // get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
            mac.init(signingKey);

            // compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(data.getBytes());

            // base64-encode the hmac
            result = Base64.encode(rawHmac);

        } catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
        return result;
    }
}
