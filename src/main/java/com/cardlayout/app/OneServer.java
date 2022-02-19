/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cardlayout.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author hp
 */
public class OneServer extends Thread {

    ServerSocket ss = null;
    
    public OneServer() {
        System.out.println("Server One");
        //while(true) {
            try {
                //128 means the server can listen to 128 clients
                ss = new ServerSocket(5000, 128);
            } catch(IOException e) {
                e.printStackTrace();
            }
            start();
        //}
    }
    
    public void run() {
        while(true) {
            try {
                Thread.sleep(6000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Socket s = ss.accept();
                System.out.println("Canonical hostname = " + s.getInetAddress().getCanonicalHostName());
                System.out.println("Host address = " + s.getInetAddress().getHostAddress());
                System.out.println("Hostname = " + s.getInetAddress().getHostName());

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
                //BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                //bufferedWriter.write("Hello Client!");
                String str1 = bufferedReader.readLine();
                System.out.println("Client Message: " + str1);
                //s.close();
                //ss.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String args[]) {
        OneServer server1 = new OneServer();
        //server1.runs();
    }
    
}
