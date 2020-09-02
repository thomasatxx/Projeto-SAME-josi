/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controler;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author User
 */
public class SHA256 {
    
    public String criptografar(String password) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
        byte digestMessage[] = algoritmo.digest(password.getBytes("UTF-8"));
        StringBuilder hexPassword = new StringBuilder();
        for (byte aByte : digestMessage) {
            hexPassword.append(String.format("%02X", 0xFF & aByte));
        }
        return hexPassword.toString();
    }
    
}
