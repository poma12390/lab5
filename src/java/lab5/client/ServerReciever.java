package lab5.client;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ServerReciever {
    DatagramChannel dc; ByteBuffer buf;
    InetAddress host;
    int port = 1290;
    SocketAddress addr;
    int len;
    public byte[] receive (byte[] arr){
        try {
            host = InetAddress.getLocalHost();
            addr = new InetSocketAddress(host,port);
            dc = DatagramChannel.open();

        } catch (UnknownHostException e) {
            System.out.println("NO HOST");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buf = ByteBuffer.wrap(arr);
        try {
            dc.send(buf, addr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        len = arr.length;
        return new byte[10];
    }

 }
