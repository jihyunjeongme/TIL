package fc.java.part2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class VerySimpleWebServer {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(9090);

        System.out.println("클라이언트 접속을 기다립니다.");
        Socket socket  = ss.accept();

        OutputStream out = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

        InputStream in = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String firstLine = br.readLine();
        List<String> headers = new ArrayList<>();
        String line = null;
        // 빈줄을 만나면 while문을 끝낸다.
        while(!(line = br.readLine()).equals("")){
            headers.add(line);
        }

        // 요청 정보 읽기가 끝.
        System.out.println(firstLine);
        for (int i = 0; i < headers.size(); i++) {
            System.out.println(headers.get(i));
        }

//        byte[] butter = new byte[512];
//        int readCount = 0;

//        while((readCount = in.read(butter)) != -1){
//            System.out.write(butter, 0, readCount);
//        }

        pw.println("HTTP/1.1 200 OK");
        pw.println("name: kim");
        pw.println("email: jihyun@gmail.com");
        pw.println();
        pw.println("<html>");
        pw.println("<h1>hello!!!</h1>");
        pw.println("</html>");
        pw.close();

//        System.out.println(socket.toString());

        ss.close();
        System.out.println("서버가 종료됩니다.");

    }
}
