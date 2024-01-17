package com.javaex.ex04;

public class DigitImpl implements Runnable {
	
	public void run() {
		for(int i = 0; i<=20; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}

}
