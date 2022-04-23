package lab5.client;

import lab5.server.ClientReceiver;

public class ServerCaller {

    public void sendToServer(byte[] test) {
        ClientReceiver clientReceiverOnServer = new ClientReceiver();
        clientReceiverOnServer.requestFromClient(test);
    }

//    DatagramChannel dc;
//    ByteBuffer buf;
//    ByteBuffer buf1;
//    InetAddress host;
//    int port = 1290;
//    SocketAddress addr;
//
//    int len;
//    public byte[] sendToServer(byte[] arr){
//        try {
//            host = InetAddress.getLocalHost();
//            dc = DatagramChannel.open();
//
//        } catch (UnknownHostException e) {
//            System.out.println("NO HOST");
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        buf = ByteBuffer.wrap(arr);
//        try {
//            addr = new InetSocketAddress(host,port);
//            dc.send(buf, addr);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        len = arr.length;
//        return catcher();
//    }

 }
