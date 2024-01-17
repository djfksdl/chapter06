package com.javaex.ex03;

public class DigitThreadImpl implements Runnable {//implements 시키면 처음에 에러난다. 그안에 있는 메소드를 구현하지 않았기 때문. 확인하려면 자동 만들어주는걸로 확인해보면 됨
	
	public void run() {
		for(int i = 0; i<= 20; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
