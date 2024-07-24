package network.socketchannel.playground;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

public class SocketClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        InetSocketAddress crunchifyAddr = new InetSocketAddress("localhost", 1111);
        long clientId = System.currentTimeMillis()%9;
        //  selectable channel for stream-oriented connecting sockets
        SocketChannel crunchifyClient = SocketChannel.open(crunchifyAddr);
        log("Connecting to Server on port 1111...");
        ArrayList<String> companyDetails = new ArrayList<String>();
        // create a ArrayList with companyName list
        companyDetails.add("Facebook"+clientId);
        companyDetails.add("Twitter"+clientId);
        companyDetails.add("IBM"+clientId);
        companyDetails.add("Google"+clientId);
        companyDetails.add("Crunchify" +clientId);

        while(true) {
            for (String companyName : companyDetails) {
                byte[] message = new String(companyName).getBytes();
                ByteBuffer buffer = ByteBuffer.wrap(message);
                crunchifyClient.write(buffer);
                log("sending: " + companyName);
                buffer.clear();
                // wait for 2 seconds before sending next message
                Thread.sleep(100);
            }
            Thread.sleep(100);
        }

        // close(): Closes this channel.
        // If the channel has already been closed then this method returns immediately.
        // Otherwise it marks the channel as closed and then invokes the implCloseChannel method in order to complete the close operation.
       // crunchifyClient.close();
    }
    private static void log(String str) {

        System.out.println(str);
    }
}
