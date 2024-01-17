package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server { //기본샘플

	public static void main(String[] args) throws IOException{  

		//서버소켓생성
		ServerSocket serverSocket = new ServerSocket();
		
		//바인딩
		serverSocket.bind(new InetSocketAddress("192.168.0.29", 10001)); //aaa를 ()안에 넣어줌, 이 아이피와 포트번호를 감시한다.
//		InetSocketAddress aaa = 주소 어쩌고. ;어차피 한번쓸거라 굳이 이름을 만들지 않는다.
		
		//서버시작
		System.out.println("<서버시작>");
		System.out.println("==================");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		//클라이언트가 접속을 하면 accept()가 실행됨
		Socket socket = serverSocket.accept();//위에서 지켜보고있다가 누가 오면 바로 실행 될 수 있도록 대기(원래는 메소드 바로 실행되었는데 얘는 누가 와야 실행됨)!  얘네가 소켓 만들어좀. new로 해서 반대쪽과 연결되는!
//		소켓도 클래스라 필드,메소드,생성자 가지고 있음. 주소를 가지고있음.
		System.out.println("[클라이언트가 연결되었습니다.]");
		
		//in 메세지 받기용 스트림
		InputStream is = socket.getInputStream(); //어디 짜고 있는지 그림 잘보기/ 1011 1111로 빨아들임 
		InputStreamReader isr = new InputStreamReader(is,"UTF-8");//is를 갖고있고 utf형식이다. ppt 보라색부분/ 숫자를 읽음
		BufferedReader br = new BufferedReader(isr);
		
		//메세지 보내기용 스트림
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter isw = new OutputStreamWriter(os,"UTF-8");//번역기 역할
		BufferedWriter bw = new BufferedWriter(isw);
		
		
		while(true) {
			//메세지 받기
			String msg =br.readLine();
			if(msg == null) {//null은 주소가 없단 뜻. 그래서 == 로 비교해줘야함
				break;
			}
			System.out.println("받은 메세지: " + msg);
			
			//메세지 보내기
			bw.write(msg); //받은거 그대로 보내주는 거임. 에코(메아리) 줄바꿈 기호는 들어가지않음. 글씨만 줌
			bw.newLine(); // 그래서 줄바꿈도 새로 해줘야함. 
			bw.flush();
		}
			
		System.out.println("=======================");
		System.out.println("<서버종료>");
		
		//닫기
		bw.close(); //오류남. 탈출조건이 없으니까
		br.close();
		socket.close();
		serverSocket.close();
		
		//이게 홈페이지에서 돌아가는 프로그램임
		
		
	}

}
