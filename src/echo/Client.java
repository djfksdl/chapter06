package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client { // 기본샘플

	public static void main(String[] p) throws IOException {
		// 통신이 목적이라 키자마자 소켓 만들어낼거임
		Socket socket = new Socket();

		System.out.println("<클라이언트 시작>");
		System.out.println("===============");
		System.out.println("서버에 연결을 요청합니다.");

		socket.connect(new InetSocketAddress("192.168.0.29", 10001)); // 여기는 바로 연결(보내버림) -> 서버에서 accept작동됨

		// 서버가 켜져있어야 우리가 주소를 찾을 수 있음
		System.out.println("서버에 연결되었습니다.");

		// 메세지 내보내기

		/*
		 * OutputStream out = new
		 * FileOutputStream("C:\\javaStudy\\MS949-copy.txt");//여기까지는 빨대 꼽은 상태 -> 꼽는순간 안에
		 * 내요잉 초기화되어서 같은 파일이름으로 하면 못읽음(일부러 실험한거) OutputStreamWriter osw = new
		 * OutputStreamWriter(out,"MS949"); //MS949로 바꿔주세요 BufferedWriter bw = new
		 * BufferedWriter(osw); 이전에 썼던거랑 비교하려고 놓음
		 */

		// 메세지 보내기용 스트림
//		OutputStream out = new FileOutputStream("C:\\javaStudy\\song.txt");//원래 파일은 이렇게 짰었음
		OutputStream os = socket.getOutputStream(); // 주소를 socket한테 내놓으라고함.
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8"); // out을 osw로 줬다.그래서 os주소를 넣어야함
		BufferedWriter bw = new BufferedWriter(osw);
		// 이전에 짯던것과 것과 똑같이 쓰면 됨
		
		
		//println만들기
		/*OutputStream pos = System.out;
		OutputStreamWriter posw = new OutputStreamWriter(pos, "UTF-8");
		BufferedWriter pbw = new BufferedWriter(posw);
		
		pbw.write("println 테스트");
		pbw.newLine();
		pbw.flush();*/

		// 메세지 받기용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isw = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isw);

		// 반복(/q라고하면 끝내기)

		// +키보드 입력
		// 스캐너준비
		 Scanner sc = new Scanner(System.in);// 외부인 키보드랑 연결하는것
		// 키보드는 매번 new할 필요가 없다. 키보드는 한번만 올리고, 입력만 반복했었음
		//스캐너 원리
		/*InputStream sc = System.in;
		InputStreamReader scIsr = new InputStreamReader(sc, "UTF-8");
		BufferedReader scBr = new BufferedReader(scIsr);*/

		while (true) {
			
			//키보드입력
			String str = sc.nextLine();
//			String str = scBr.readLine();//스캐너 원리

			if (str.equals("/q")) { // == 이걸쓰기만해도 new가 된다. 주소를 비교하는거라 같을 수가 없다. 값을 비교하는거니까 equals()메소드를 써줌.
				// /q는 무조건 만들어지니까 "/q".equals(str)로 하는게 null포인트를 막을 수 있다. (1교시 거의 마지막 화면!)
				break;
			}
			// 메세지 보내기
//			bw.write("안녕하세요");//write까지 짬
			bw.write(str);// 키보드로 입력한 값을 보내기
			bw.newLine();// 줄바꿈까지 해주기
			// buffered가 모아서 보내는데 양이 안찰수있다. 안녕하세요가 넘 짧을 수도 있음그래서 억지로 보내라는거 있음
			bw.flush();// 양 안차도 강제로 보내는 역할

			// 메세지 받기용
			String reMsg = br.readLine();
			System.out.println("server:[ " + reMsg + " ]");
		}

		System.out.println("====================================");
		System.out.println("<클라이언트 종료>");


		// 닫기- 이게 반복되면 다 끝나버림
		sc.close(); // 오류가 2번남. while안에만 작동하는 지역변수라서 스캐너 뉴를 위로 빼준다. 그리고 한번은 닿을수없다(break를 안해서 빠져나갈길이
					// 없으니까!)
		br.close();
		bw.close();
		socket.close();

	}
}
