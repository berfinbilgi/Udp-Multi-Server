package connect;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServerClient {

	public static void main(String[] args) throws Exception {

		DatagramSocket ds = new DatagramSocket(9999);
		byte[] b1 = new byte[1024];
		DatagramPacket dp = new DatagramPacket(b1, b1.length);
		ds.receive(dp);

		String str = new String(dp.getData());

		// 1
		DatagramSocket dsocket1 = new DatagramSocket();
		InetAddress ia1 = InetAddress.getLocalHost();
		DatagramPacket dpacket1 = new DatagramPacket(str.getBytes(), str.length(), ia1, 5000);
		dsocket1.send(dpacket1);

		// 2
		DatagramSocket dsocket2 = new DatagramSocket();
		InetAddress ia2 = InetAddress.getLocalHost();
		DatagramPacket dpacket2 = new DatagramPacket(str.getBytes(), str.length(), ia2, 6666);
		dsocket2.send(dpacket2);

		// 3
		DatagramSocket dsocket3 = new DatagramSocket();
		InetAddress ia3 = InetAddress.getLocalHost();
		DatagramPacket dpacket3 = new DatagramPacket(str.getBytes(), str.length(), ia3, 4160);
		dsocket3.send(dpacket3);

		// client e geri gonderme...
		byte[] b2 = (str).getBytes();
		InetAddress ia = InetAddress.getLocalHost();
		DatagramPacket dp4 = new DatagramPacket(b2, b2.length, ia, dp.getPort());
		ds.send(dp4);

	}

}
