/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cardlayout.app;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author hp
 */
public class OneClient {

    public OneClient() {
        System.out.println("Client One");
    }

    public void runc() {
        try {
            String str1 = "Canonical hostname = " + InetAddress.getLocalHost().getCanonicalHostName();
            String str2 = "Local host address = " + InetAddress.getLocalHost().getHostAddress();
            String str3 = "Local hostname = " + InetAddress.getLocalHost().getHostName();

            //Socket s = new Socket("127.0.0.1",5000);
            //Socket s = new Socket("192.168.0.253",5000);
            InetAddress inetAddress = InetAddress.getByName("192.168.0.253");
            Socket s = new Socket(inetAddress, 5000);

            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //System.out.println("Server Message: " + bufferedReader.readLine());

            //BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            //bufferedWriter.write("Hello Server!");
            //bufferedWriter.write(str1);
            //bufferedWriter.write(str2);
            //bufferedWriter.write(str3);
            //bufferedWriter.flush();

            PrintWriter printWriter = new PrintWriter(s.getOutputStream());
            printWriter.print("Hello Server!");
            printWriter.flush();
            //s.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        OneClient client1 = new OneClient();
        client1.runc();
    }
    
}
