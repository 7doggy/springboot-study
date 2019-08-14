package com.lichun.springboot.springbootstudy.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class NetUtils {

    /***
     *  true:already in using  false:not using
     * @param port
     */
    public static boolean isLoclePortUsing(int port){
        boolean flag = true;
        try {
            flag = isPortUsing("127.0.0.1", port);
        } catch (Exception e) {
        }
        return flag;
    }

    /***
     *  true:already in using  false:not using
     * @param host
     * @param port
     * @throws UnknownHostException
     */
    public static boolean isPortUsing(String host,int port) throws UnknownHostException {
        boolean flag = true;
//      InetAddress theAddress = InetAddress.getByName(host);
        try {
//          Socket socket = new Socket(theAddress,port);
            ServerSocket socket = new ServerSocket(port);
            flag = false;
            socket.close();
        } catch (IOException e) {

        }
        return flag;
    }
}
