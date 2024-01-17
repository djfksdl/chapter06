package com.javaex.ex02;

public class Multithread {
	public static void main(String[] args) {
		Thread thread1 = new DigitThread();
		Thread thread2 = new LowerThread();
		Thread thread3 = new UpperThread();
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		//thread1.run()을 하게 되면 부모꺼 안씀.그냥 순서대로 진행이 됨
	}
}
