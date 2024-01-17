package com.javaex.ex04;

public class LowerImpl implements Runnable{
	public void run() {
		for(char l = 'a'; l<='z'; l++) {
			System.out.println(l);
			try {
				Thread.sleep(1000);				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}
