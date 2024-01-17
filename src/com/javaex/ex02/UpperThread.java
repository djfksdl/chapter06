package com.javaex.ex02;

public class UpperThread extends Thread{
	//필드
	//생성자
	//메소드
	
	public void run() {
		for(char c= 'A'; c<='Z'; c++) {
			System.out.println(c);
			
			try {
				Thread.sleep(1000);
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}
}
