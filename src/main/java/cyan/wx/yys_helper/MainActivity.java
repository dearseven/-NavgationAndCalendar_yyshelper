package cyan.wx.yys_helper;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

import java.util.List;

import cyan.wx.yys_helper.common.RecyclerViewCalenar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, RecyclerViewCalenar.Parent<RecyclerViewCalenar.Day> {
    private List<RecyclerViewCalenar.Day> days = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "back home", Snackbar.LENGTH_LONG)
                        .setAction("click me to back!", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent home = new Intent(Intent.ACTION_MAIN);
                                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                home.addCategory(Intent.CATEGORY_HOME);
                                startActivity(home);
                            }
                        }).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //初始化日历
        RecyclerViewCalenar a = new RecyclerViewCalenar(this, R.id.calendar_rv, R.id.lastMonth, R.id.nextMonth, R.id.showYandM);
        a.changeDayColor(2016, 10, 22, "#FF0000");
        a.changeDesColor(2016, 10, 11, "#00FF00");
        a.changeDes(2016, 10, 1, "嘿");
        a.changeBgiColor(2016, 10, 30, "#ff00ff");
        a.reshow();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.delay_5) {
            // Handle the camera action
        } else if (id == R.id.delay_10) {

        } else if (id == R.id.delay_15) {

        } else if (id == R.id.delay_20) {

        } else if (id == R.id.delay_30) {

        } else if (id == R.id.see_daily_activities) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //-----------日历的parent接口-------------
    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public View findAndroidViewById(int id) {
        return findViewById(id);
    }

    @Override
    public void clickDate(int y, int m, int d) {
        Toast.makeText(this, y + " " + m + " " + d, Toast.LENGTH_SHORT).show();
    }


}

