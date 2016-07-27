package com.nanddgroup.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.nanddgroup.myapplication.adapters.FriendAdapter;
import com.nanddgroup.myapplication.item_list.Friend;
import com.nanddgroup.myapplication.item_list.Profile;
import com.nanddgroup.myapplication.socket.Client;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{
    @BindView(R.id.lvFriends) ListView lvFriends;
    @BindView(R.id.drawerLayout) DrawerLayout drawerLayout;
    @BindView(R.id.header) LinearLayout header;
    @BindView(R.id.bConnectServer) Button bConnectServer;

    private MyDialog myDialog;
    public static Profile myProfile;
    private ArrayList<Friend> alFriends;
    public static Client client = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        if (ProfileActivity.isProfileOpen) {
            ProfileActivity.isProfileOpen = false;
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }

        //хз что тут происходит
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
//        drawerLayout.openDrawer(Gravity.LEFT);
        toggle.syncState();

        //список активных друзей
        alFriends = new ArrayList<>();
        fillFriendList();
        lvFriends.setAdapter(new FriendAdapter(getApplicationContext(),
                R.layout.custom_friend, alFriends));

        //список профайлов
        myProfile = new Profile();
        fillMyProfile();

        lvFriends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawerLayout.closeDrawers();
                setTitle(alFriends.get(position).getsName());
            }
        });

        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });

        bConnectServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyDialog();
            }
        });
    }

    private void fillMyProfile() {
        myProfile.setsName("User");
        myProfile.setImageID(R.drawable.my_logo);
        myProfile.setStatus("Status");
    }

    private void fillFriendList() {
        alFriends.add(new Friend(new Profile()));
//        alFriends.add(new Friend("Petya", getImageID()));
//        alFriends.add(new Friend("Kolya", getImageID()));
//        alFriends.add(new Friend("Dimuch", getImageID()));
//        alFriends.add(new Friend("Stas", getImageID()));
//        alFriends.add(new Friend("Nikita", getImageID()));
//        alFriends.add(new Friend("vasya", getImageID()));
//        alFriends.add(new Friend("petya", getImageID()));
//        alFriends.add(new Friend("kolya", getImageID()));
//        alFriends.add(new Friend("dimuch", getImageID()));
//        alFriends.add(new Friend("stas", getImageID()));
//        alFriends.add(new Friend("nikita", getImageID()));
//        alFriends.add(new Friend("1nikita", getImageID()));
    }

    public int getImageID() {
        int imageID;
        switch ((int) (10*Math.random())) {
            case 0:
                imageID = R.drawable.logo_0;
                break;
            case 1:
                imageID = R.drawable.logo_1;
                break;
            case 2:
                imageID = R.drawable.logo_2;
                break;
            case 3:
                imageID = R.drawable.logo_3;
                break;
            case 4:
                imageID = R.drawable.logo_4;
                break;
            case 5:
                imageID = R.drawable.logo_5;
                break;
            case 6:
                imageID = R.drawable.logo_6;
                break;
            case 7:
                imageID = R.drawable.logo_7;
                break;
            case 8:
                imageID = R.drawable.logo_8;
                break;
            case 9:
                imageID = R.drawable.logo_9;
                break;
            default: imageID = R.drawable.logo_0;
        }
        return imageID;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.abSettings) {

            showMyDialog();
//            Log.wtf("my", "set");
            return true;
        }
        if (id == R.id.abDisconnect) {

            if(client==null){
                return true;
            }
            client.disconnect();
//            Log.wtf("my", "dis");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showMyDialog() {
        myDialog = new MyDialog();
        myDialog.show(getFragmentManager(), "tag");
    }

}
