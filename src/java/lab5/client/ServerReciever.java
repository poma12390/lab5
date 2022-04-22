package lab5.client;

import lab5.exceptions.ServerNotFoundException;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ServerReciever {
    DatagramChannel dc;
    ByteBuffer buf;
    ByteBuffer buf1;
    InetAddress host;
    int port = 1290;
    SocketAddress addr;

    int len;
    public byte[] receive (byte[] arr){
        try {
            host = InetAddress.getLocalHost();
            dc = DatagramChannel.open();

        } catch (UnknownHostException e) {
            System.out.println("NO HOST");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buf = ByteBuffer.wrap(arr);
        try {
            addr = new InetSocketAddress(host,port);
            dc.send(buf, addr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        len = arr.length;
        return catcher();
    }
    private byte[] catcher(){
        try {
            dc.configureBlocking(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (buf1 != null){
            buf1.clear();
        }
        for (int i =0; i<5; i++) {
            sleep(1000);

            try {
                addr = dc.receive(buf);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (addr != null){
                break;
            }
            if (i <4){
            System.out.println("Trying to connect to server");
            }
            else throw new ServerNotFoundException();
        }

        return null;
    }
    private void sleep(int mils){
        try {
            Thread.sleep(mils);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

 }
