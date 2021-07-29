package connect;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer2 {

	public static void main(String[] args) throws Exception {

		DatagramSocket ds = new DatagramSocket(6666);
		byte[] b1 = new byte[1024];
		DatagramPacket dp = new DatagramPacket(b1, b1.length);
		ds.receive(dp);

		String str = new String(dp.getData());
		System.out.println(str);

		// Mesaj alýndýktan sonra sistemin milisaniyesi
		long recieveTime = System.currentTimeMillis();
		System.out.println(recieveTime);

		byte[] b2 = (str).getBytes();
		InetAddress ia = InetAddress.getLocalHost();
		DatagramPacket dp2 = new DatagramPacket(b2, b2.length, ia, dp.getPort());
		ds.send(dp2);

	}
}
