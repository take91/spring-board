package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class UserPwHash {
	public String getSHA256(String plainText) {
		String shaString = "";

		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(plainText.getBytes());
			byte[] bytedata = sh.digest();
			StringBuffer sf = new StringBuffer();

			for (byte b : bytedata) {
				sf.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
			}

			shaString = sf.toString();

		} catch (Exception e) {
			e.printStackTrace();
			shaString = null;
		}

		return shaString;
	}
}
