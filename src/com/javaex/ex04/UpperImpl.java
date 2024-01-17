package com.javaex.ex04;

public class UpperImpl implements Runnable{
	public void run() {
		for(char u = 'A'; u<='Z'; u++) {
			System.out.println(u);
			try {
				Thread.sleep(1000);				
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
	}
}
