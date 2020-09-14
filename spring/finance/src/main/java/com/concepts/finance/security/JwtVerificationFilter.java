package com.concepts.finance.security;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.jwt.crypto.sign.SignatureVerifier;
import org.springframework.util.ResourceUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtVerificationFilter extends OncePerRequestFilter {

    private boolean verifyToken(String authToken) {
        try {
            File file = ResourceUtils.getFile("classpath:fin.pub");

            byte[] readAllBytes = Files.readAllBytes(file.toPath());
            // Base64.Decoder decoder = Base64.getDecoder();
            X509EncodedKeySpec ks = new X509EncodedKeySpec(readAllBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            RSAPublicKey publicKey = (RSAPublicKey) kf.generatePublic(ks);
            SignatureVerifier verifier = new RsaVerifier(publicKey);
            Jwt decodedToken = JwtHelper.decodeAndVerify(authToken, verifier);
            System.out.println(decodedToken);

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

        // TODO Auto-generated method stub
        return true;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader == null) {
            throw new BadCredentialsException("No authorization header found.");
        }
        String authToken = authHeader.replace("Bearer", "").trim();
        if (!verifyToken(authToken)) {
            throw new BadCredentialsException("Bearer token invalid.");
        }
        filterChain.doFilter(request, response);
    }

}
