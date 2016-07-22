package com.nanddgroup.myapplication;

import android.os.Bundle;
import android.support.annotation.StringRes;
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private MyFragment myFragment;
    private boolean fragmentAdd = false;
    private int idFriendLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //хз что тут происходит
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        drawer.openDrawer(Gravity.LEFT);
        toggle.syncState();

        //
        ListView lvFriends = (ListView) findViewById(R.id.lvFriends);
        final ArrayList<Friend> alFriends = new ArrayList<>();
        fillFriendList(alFriends);
        lvFriends.setAdapter(new FriendAdapter(getApplicationContext(),
                R.layout.custom_friend, alFriends));

        myFragment = new MyFragment();

        lvFriends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                idFriendLogo = alFriends.get(position).getImageID();

                if (!fragmentAdd) {
                    fragmentAdd = true;
                    getFragmentManager().beginTransaction()
                            .replace(R.id.contentMain, myFragment)
                            .commit();
                }

                drawer.closeDrawers();
                setTitle(alFriends.get(position).getsName());
            }
        });
    }


    public void clickSend(View v) {
//        Toast.makeText(getBaseContext(), sFriendName, Toast.LENGTH_SHORT).show();
        TextView etMessage = (TextView) findViewById(R.id.etMessage);
        switch (v.getId()) {
            case R.id.ivSend:
                myFragment.updateList(new Message(R.drawable.my_logo, etMessage.getText().toString(), true));
                etMessage.setText(null);
                break;
            case R.id.bSendFriend:
                myFragment.updateList(new Message(idFriendLogo, "Friend message", false));
                break;
        }
    }

    private void fillFriendList(ArrayList<Friend> alFriends) {
        alFriends.add(new Friend("", getImageID()));
        alFriends.add(new Friend("Petya", getImageID()));
        alFriends.add(new Friend("Kolya", getImageID()));
        alFriends.add(new Friend("Dimuch", getImageID()));
        alFriends.add(new Friend("Stas", getImageID()));
        alFriends.add(new Friend("Nikita", getImageID()));
        alFriends.add(new Friend("vasya", getImageID()));
        alFriends.add(new Friend("petya", getImageID()));
        alFriends.add(new Friend("kolya", getImageID()));
        alFriends.add(new Friend("dimuch", getImageID()));
        alFriends.add(new Friend("stas", getImageID()));
        alFriends.add(new Friend("nikita", getImageID()));
        alFriends.add(new Friend("1nikita", getImageID()));
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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
