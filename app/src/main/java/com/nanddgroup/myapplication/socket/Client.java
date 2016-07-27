package com.nanddgroup.myapplication.socket;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.util.Log;

import com.google.gson.Gson;
import com.nanddgroup.myapplication.MainActivity;
import com.nanddgroup.myapplication.MyDialog;
import com.nanddgroup.myapplication.item_list.Message;
import com.nanddgroup.myapplication.item_list.Profile;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * Created by Dimuch on 26.07.2016.
 */
public class Client extends Thread {

    Profile profile;
    Message message;
    String ipAddress;
    int port;
    Activity activity;

    String msgLog = "";
    Message msgToSend;
    boolean goOut = false;

    public Client(Activity activity, Profile profile, String address, int port) {
        this.activity = activity;
        this.profile = profile;
        this.ipAddress = address;
        this.port = port;

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void run() {
        Socket socket = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStreamReader inputStreamReader = null;

        try {
            socket = new Socket(ipAddress, port);
            outputStreamWriter = new OutputStreamWriter (socket.getOutputStream(), StandardCharsets.UTF_8);
            inputStreamReader = new InputStreamReader(socket.getInputStream());

            Gson gson = new Gson();

            String jsonRepresentation = gson.toJson(profile);
            outputStreamWriter.write(jsonRepresentation);
            outputStreamWriter.flush();

            String jsonProfile = String.valueOf(inputStreamReader.read());
            profile = gson.fromJson(jsonProfile, Profile.class);

            while (!goOut) {
                if (true) {
                    String jsonInputMessage = String.valueOf(inputStreamReader.read());
                    message = gson.fromJson(jsonInputMessage, Message.class);

                    activity.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            MyDialog.myFragment.updateList(message);
                        }
                    });
                }

                if(true){
                    String jsonOutputMessage = gson.toJson(msgToSend);
                    outputStreamWriter.write(jsonOutputMessage);
                    outputStreamWriter.flush();
                }
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
            final String eString = e.toString();
        } catch (IOException e) {
            e.printStackTrace();
            final String eString = e.toString();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

    public void sendMsg(Message message){
        msgToSend = message;
    }

    public void disconnect(){
        goOut = true;
    }

}
