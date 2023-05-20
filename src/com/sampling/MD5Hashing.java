package com.sampling;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hashing {
	
	
	
public String getHashValueFor(String password) {
		
		String hashValue=null;
		
		try {
			//create messageDigest instance for md5
			MessageDigest md=MessageDigest.getInstance("MD5");
			
			//add password bytes to digest
			md.update(password.getBytes());
			
			//get hash's bytes
			byte[] bytes=md.digest();
			
			//this bytes[] has bytes in decimal format. convert it to hexadecimal format
			StringBuilder sb=new StringBuilder();
			for(int i=0; i<bytes.length;i++) {
				sb.append(Integer.toString((bytes[i]& 0xff)+0x100, 16).substring(1));
			}
			
			//Getcomplete hashed password in hex format
			hashValue = sb.toString();
			
		}catch(NoSuchAlgorithmException e) {
			e.getMessage();
		}
		
		return hashValue;
	}
public String getPasswordFromHash(String hashval, String guessedPassword) {
	String guess="Incorrect";
	String HashOfGuessedPassword=getHashValueFor(guessedPassword);
	
	if(hashval.equals(HashOfGuessedPassword)) {
		guess="Correct guess!";
	}else {
		guess="Wrong!";
	}
	
	return guess;
}

}
