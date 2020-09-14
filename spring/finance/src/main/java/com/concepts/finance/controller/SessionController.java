package com.concepts.finance.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.jwt.crypto.sign.SignatureVerifier;
import org.springframework.security.jwt.crypto.sign.Signer;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @RequestMapping(value = "/start-session", method = RequestMethod.POST)
    public ResponseEntity<byte[]> startSession() throws NoSuchAlgorithmException {
        Map<String, String> headers = new HashMap<>();
        headers.put("alg", "HS256");
        headers.put("typ", "JWT");

        String claims = "{\"sub\": \"nglearning\",\r\n" + "  \"scopes\": [\r\n" + "    {\r\n"
                + "      \"authority\": \"ROLE_ADMIN\"\r\n" + "    }\r\n" + "  ],\r\n"
                + "  \"iss\": \"http://ng.learnspace.com\",\r\n" + "  \"iat\": 1508607322,\r\n"
                + "  \"exp\": 1508625322}";
        Signer signer = null;

        try {
            File file = ResourceUtils.getFile("classpath:fin.key");
            PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(Files.readAllBytes(file.toPath()));
            KeyFactory kf = KeyFactory.getInstance("RSA");
            RSAPrivateKey privateKey = (RSAPrivateKey) kf.generatePrivate(ks);
            signer = new RsaSigner(privateKey);
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InvalidKeySpecException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Jwt token = JwtHelper.encode(claims, signer, headers);
        return ResponseEntity.ok(token.bytes());
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> headers = new HashMap<>();
        headers.put("alg", "HS256");
        headers.put("typ", "JWT");

        String claims = "{\"sub\": \"nglearning\",\r\n" + "  \"scopes\": [\r\n" + "    {\r\n"
                + "      \"authority\": \"ROLE_ADMIN\"\r\n" + "    }\r\n" + "  ],\r\n"
                + "  \"iss\": \"http://ng.learnspace.com\",\r\n" + "  \"iat\": 1508607322,\r\n"
                + "  \"exp\": 1508625322}";

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048, new SecureRandom());
        KeyPair keyPair = generator.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        Signer signer = new RsaSigner(privateKey);
        System.out.println(publicKey.getFormat());

        Jwt token = JwtHelper.encode(claims, signer, headers);
        // System.out.println(token);

        String tokenString = new String(token.bytes());
        System.out.println(tokenString);

        // SignatureVerifier verifier = new RsaVerifier(publicKey);
        // Jwt decodedToken = JwtHelper.decodeAndVerify(tokenString, verifier);
        // System.out.println(decodedToken);

        String outFile = "fin";

        FileOutputStream out = new FileOutputStream(outFile + ".key");
        out.write(privateKey.getEncoded());
        out.close();

        FileOutputStream out1 = new FileOutputStream(outFile + ".pub");
        // out.write("-----BEGIN RSA PUBLIC KEY-----\n");
        out1.write(publicKey.getEncoded());
        // out.write("\n-----END RSA PUBLIC KEY-----\n");
        out1.close();

        File file = new File("fin.pub");
        byte[] readAllBytes = Files.readAllBytes(file.toPath());
        X509EncodedKeySpec ks = new X509EncodedKeySpec(readAllBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        RSAPublicKey publicKey1 = (RSAPublicKey) kf.generatePublic(ks);
        SignatureVerifier verifier = new RsaVerifier(publicKey1);
        Jwt decodedToken = JwtHelper.decodeAndVerify(tokenString, verifier);
        System.out.println(decodedToken);
    }
}
