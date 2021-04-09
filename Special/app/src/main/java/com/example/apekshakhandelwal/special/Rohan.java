package com.example.apekshakhandelwal.special;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Rohan extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rohan);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    void launchS(View v)
    {
        intent=new Intent(this,news.class);
        intent.putExtra("newsName","sports");
        startActivity(intent);

    }
    void launchG(View v)
    {
        intent=new Intent(this,news.class);
        intent.putExtra("newsName","government");
        startActivity(intent);
    }
    void launchT(View v)
    {
        intent=new Intent(this,news.class);
        intent.putExtra("newsName","technology");
        startActivity(intent);
    }
    void launchB(View v)
    {
        intent=new Intent(this,news.class);
        intent.putExtra("newsName","bollywood");
        startActivity(intent);
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
        getMenuInflater().inflate(R.menu.rohan, menu);
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
    Intent intent;

    void login(View v)
    {
        intent=new Intent(this,Lock.class);
        startActivity(intent);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.sports) {
            intent=new Intent(this,news.class);
            intent.putExtra("newsName","sports");
            startActivity(intent);
        } else if (id == R.id.bollywood) {
            intent=new Intent(this,news.class);
            intent.putExtra("newsName","bollywood");
            startActivity(intent);
        } else if (id == R.id.Technology) {
            intent=new Intent(this,news.class);
            intent.putExtra("newsName","technology");
            startActivity(intent);
        } else if (id == R.id.Government) {
            intent=new Intent(this,news.class);
            intent.putExtra("newsName","government");
            startActivity(intent);
        } else if (id == R.id.nav_share) {
            intent=new Intent(this,news.class);
            intent.putExtra("newsName","nav_share");
            startActivity(intent);
        } else if (id == R.id.nav_send) {
            intent=new Intent(this,news.class);
            intent.putExtra("newsName","nav_send");
            startActivity(intent);
        }else if (id == R.id.photos) {
            intent=new Intent(this,gallery.class);
            startActivity(intent);
        } else if (id == R.id.video) {
            intent=new Intent(this,video.class);
            startActivity(intent);
        } else if (id == R.id.audio) {
            intent=new Intent(this,audio.class);
            startActivity(intent);
        } else if (id == R.id.text) {
            intent=new Intent(this,word.class);
            startActivity(intent);
        }

        else if(id==R.id.Contact) {
            intent= new Intent(this,Contact.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
