import java.io.*;
import java.io.IOException;
import java.net.*;

public class ClientSocketMain {
	Socket s;
	DataInputStream din;
	DataOutputStream dout;
	BufferedReader br;
	
	public void startConnection() {
		try {
			s = new Socket("127.0.0.1",1201);

			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());

			br = new BufferedReader(new InputStreamReader(System.in));

			String msgin = "", msgout = "";

			while (!msgin.equals("end")) {
				dout.writeUTF(String.valueOf(3));
				msgin = din.readUTF();
				System.out.println(msgin);
			}
			s.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void closeConnection() {
		try{
			din.close();
			dout.close();
			br.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}