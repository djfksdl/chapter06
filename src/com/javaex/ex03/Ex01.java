package com.javaex.ex03;

public class Ex01 {

	public static void main(String[] args) throws InterruptedException {
		
		//출장 1~20까지 출력하는 것
		DigitThreadImpl dt = new DigitThreadImpl();//2. 일단 메모리에 올린다. 3. ()안에 dt라는 주소를 넣어줌
		Thread thread = new Thread(dt); //1. 아무 연관없는데 일단 써줌. 근데 digitThread안에 있는 run() 일을 시키고싶은거임
		thread.start();// 4. 오버라이딩은 직접 달려있어야하는데 Thread랑 DigitThreadImpl이랑은 관계없음. 다만 Thread가 DigitThreadImpl의 주소를 가지고있게 됨. run()이 실행되게 Thread가 만들어놓고, DigitThreadImpl이 run()될 수 있게 함.
		//start()안에 출장 기능이있어서 절대 run()이라고 쓰지않는다.
		
		//상관없이 내가 하고싶은 것
		for(char ch='A'; ch<='Z'; ch++) {
			System.out.println(ch);
			Thread.sleep(1000); //안쪽코드가 트라이 캐치써도되는데 뭘로 처리할지 몰라서 밖으로 던진거임. 그래서 쓰레드.슬립밖으로 던진거라 오류생김. 그냥 여기에 트라이캐치 써줘도됨.
		}
	}

}
