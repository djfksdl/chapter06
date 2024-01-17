package com.javaex.ex02;

public class LowerThread extends Thread{
	//필드
	//생성자
	//메소드
	
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
