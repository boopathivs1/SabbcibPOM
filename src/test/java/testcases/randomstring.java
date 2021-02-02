package testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class randomstring {
	public static List<String>Bznme=new ArrayList<String>();

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String a=Data("test");
System.out.println(a);
	}
	public static String Data(String data) throws InterruptedException {
		Random r = new Random();
		int Low = 1;
		int High = 5;
		int R = r.nextInt(High-Low) + Low;			
	//alphabit	
		String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZABCDSED";		
	int character=(int)(Math.random()*26);	
		System.out.println(character);
		String s=alphabet.substring(character, character+8);	
		
		String bizname=data+s;
		Bznme.add(bizname);
	return bizname;
		}
}
