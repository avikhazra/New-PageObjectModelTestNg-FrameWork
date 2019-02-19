package com.portal.automation.appException;

public class Test {

	public static void main(String[] args) {
		String s1="Kreissparkasse Ravensburg";
		String s2="Kreissparkasse Ravensburg";
		System.out.println(s1.contains(s2));
		System.out.println(s1.equals(s2));
		System.out.println(s1==s2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1.toUpperCase().contains(s2.toUpperCase()));
		char c1=s1.charAt(14);
		char c2=s2.charAt(14);
		System.out.println((int)c1);
		System.out.println((int)c2);
	

	}

}
