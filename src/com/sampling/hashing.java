package com.sampling;

public class hashing {

	public static void main(String[] args) {
		
		String password="Paul5085";
		
		MD5Hashing ha=new MD5Hashing();
		String hashValue=ha.getHashValueFor(password);
		
		System.out.println(ha.getPasswordFromHash(hashValue, "Paul5085"));
	}

}
