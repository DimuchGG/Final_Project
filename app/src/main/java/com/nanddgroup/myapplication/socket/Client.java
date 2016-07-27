package com.nanddgroup.myapplication.socket;

import android.view.View;
import android.widget.Toast;

import com.nanddgroup.myapplication.MainActivity;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Dimuch on 26.07.2016.
 */
public class Client extends Thread {

    String name;
    String dstAddress;
    int dstPort;

    String msgLog = "";
    String msgToSend = "";
    boolean goOut = false;

    public Client(String name, String address, int port) {
        this.name = name;
        dstAddress = address;
        dstPort = port;
    }

    @Override
    public void run() {
        Socket socket = null;
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;

        try {
            socket = new Socket(dstAddress, dstPort);
            dataOutputStream = new DataOutputStream(
                    socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream.writeUTF(name);
            dataOutputStream.flush();

            while (!goOut) {
                if (dataInputStream.available() > 0) {
                    msgLog += dataInputStream.readUTF();

//                    MainActivity.this.runOnUiThread(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            chatMsg.setText(msgLog);
//                        }
//                    });
                }

                if(!msgToSend.equals("")){
                    dataOutputStream.writeUTF(msgToSend);
                    dataOutputStream.flush();
                    msgToSend = "";
                }
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
            final String eString = e.toString();
//            MainActivity.this.runOnUiThread(new Runnable() {
//
//                @Override
//                public void run() {
//                    Toast.makeText(MainActivity.this, "1" + eString, Toast.LENGTH_LONG).show();
//                }
//
//            });
        } catch (IOException e) {
            e.printStackTrace();
            final String eString = e.toString();
//            MainActivity.this.runOnUiThread(new Runnable() {
//
//                @Override
//                public void run() {
//                    Toast.makeText(MainActivity.this, "2" + eString, Toast.LENGTH_LONG).show();
//                }
//
//            });
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

//            MainActivity.this.runOnUiThread(new Runnable() {
//
//                @Override
//                public void run() {
//                    loginPanel.setVisibility(View.VISIBLE);
//                    chatPanel.setVisibility(View.GONE);
//                }
//
//            });
        }

    }

    public void sendMsg(String msg){
        msgToSend = msg;
    }

    public void disconnect(){
        goOut = true;
    }

}
