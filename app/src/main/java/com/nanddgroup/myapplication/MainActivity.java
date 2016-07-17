package com.nanddgroup.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        ListView lv = (ListView) findViewById(R.id.lvFriends);
        ArrayList<Friend> alFriends = new ArrayList<Friend>();
//        for (int i = 0; i < 20; i++) {
//            alFriends.add(new Friend("Vasya_#" + i, getImageID("Vasya")));
//        }
        alFriends.add(new Friend("Vasya", getImageID("Vasya")));
        alFriends.add(new Friend("Petya", getImageID("Petya")));
        alFriends.add(new Friend("Kolya", getImageID("Kolya")));
        alFriends.add(new Friend("Dimuch", getImageID("Dimuch")));
        alFriends.add(new Friend("Stas", getImageID("Stas")));
        alFriends.add(new Friend("Nikita", getImageID("Nikita")));
        alFriends.add(new Friend("vasya", getImageID("vasya")));
        alFriends.add(new Friend("petya", getImageID("petya")));
        alFriends.add(new Friend("kolya", getImageID("kolya")));
        alFriends.add(new Friend("dimuch", getImageID("dimuch")));
        alFriends.add(new Friend("stas", getImageID("stas")));
        alFriends.add(new Friend("nikita", getImageID("nikita")));
        alFriends.add(new Friend("1nikita", getImageID("1nikita")));
        MyAdapter myAdapter = new MyAdapter(getApplicationContext(),
                R.layout.custom_friend, alFriends);
        lv.setAdapter(myAdapter);

    }

    public int getImageID(String sName) {
        int imageID = R.drawable.logo;
        switch (sName.toCharArray()[0]) {
            case 'A':
            case 'a': imageID = R.drawable.a;
                break;
            case 'B':
            case 'b': imageID = R.drawable.b;
                break;
            case 'C':
            case 'c': imageID = R.drawable.c;
                break;
            case 'D':
            case 'd': imageID = R.drawable.d;
                break;
            case 'E':
            case 'e': imageID = R.drawable.e;
                break;
            case 'F':
            case 'f': imageID = R.drawable.f;
                break;
            case 'G':
            case 'g': imageID = R.drawable.g;
                break;
            case 'H':
            case 'h': imageID = R.drawable.h;
                break;
            case 'I':
            case 'i': imageID = R.drawable.i;
                break;
            case 'J':
            case 'j': imageID = R.drawable.j;
                break;
            case 'K':
            case 'k': imageID = R.drawable.k;
                break;
            case 'L':
            case 'l': imageID = R.drawable.l;
                break;
            case 'M':
            case 'm': imageID = R.drawable.m;
                break;
            case 'N':
            case 'n': imageID = R.drawable.n;
                break;
            case 'O':
            case 'o': imageID = R.drawable.o;
                break;
            case 'P':
            case 'p': imageID = R.drawable.p;
                break;
            case 'Q':
            case 'q': imageID = R.drawable.q;
                break;
            case 'R':
            case 'r': imageID = R.drawable.r;
                break;
            case 'S':
            case 's': imageID = R.drawable.s;
                break;
            case 'T':
            case 't': imageID = R.drawable.t;
                break;
            case 'U':
            case 'u': imageID = R.drawable.u;
                break;
            case 'V':
            case 'v': imageID = R.drawable.v;
                break;
            case 'W':
            case 'w': imageID = R.drawable.w;
                break;
            case 'X':
            case 'x': imageID = R.drawable.x;
                break;
            case 'Y':
            case 'y': imageID = R.drawable.y;
                break;
            case 'Z':
            case 'z': imageID = R.drawable.z;
                break;
            default: imageID = R.drawable.logo;
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
