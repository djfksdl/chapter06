package com.javaex.ex01;

public class Ex01 {

	public static void main(String[] args) throws InterruptedException { //이런 예외도 있다. 자동완성. 스레드 눌러서 던져버린거임
		
		DigitThread d  = new DigitThread();
//		d.numPrint(); //준비되면 알아서 찍어. 끝나면 알아서 끝내/ 준비가 빨리되면 얘부터찍힐수있고 아니면 for문이 찍힌다.
		d.start(); //공평하게아닌, 자기스케쥴대로 실행됨. 영어랑 숫자랑 섞어나옴
		
		for(char ch='A'; ch<='Z'; ch++){//숫자로 인식
			System.out.println(ch);;
			Thread.sleep(1000);
		}
	}

}
