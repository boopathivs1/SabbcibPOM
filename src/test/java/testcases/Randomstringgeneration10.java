package testcases;

import java.util.Random;

public class Randomstringgeneration10 {
	public static String output=null;
	public static void main(String[] args) throws InterruptedException {
	
		
		System.out.println(Data());
	}
	public static String Data() throws InterruptedException {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder(20);
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
	output = sb.toString();
		//System.out.println(output);
	
		
		return output;

	}
}
