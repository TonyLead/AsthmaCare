package com.asthmacare.asus.asthma.view.examview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.support.design.widget.NavigationView;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.asthmacare.asus.asthma.R;
import com.asthmacare.asus.asthma.view.examview.examview.ExamFragment;
import com.asthmacare.asus.asthma.view.examview.remindersview.RemindersFragment;

public class ActivityFragments extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private String mId;
    private Fragment fragment;
    private Class fragmentClass;
    private FragmentManager fragmentManager;
    private String fname;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        mId = intent.getStringExtra("id"); //work
        Log.d("qwerty",mId);







        fragment = null;
        fragmentClass = null;
        fragmentManager = getSupportFragmentManager();
        fragmentClass = HelloFragment.class;

        try {
            fragment = (Fragment) fragmentClass.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        fragmentManager.beginTransaction().add(R.id.container, fragment).commit();


        //
      //  Intent kek = getIntent();
      //  String kek1 = kek.getStringExtra("ExamFragment");
      //  if(kek1 != null) {
//            Log.d("Please", kek1);
      //  }

/*
        if(kek1 == null){
        }else {
            fragmentClass = ExamFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            fragmentManager.beginTransaction().replace(R.id.container,fragment).commit();

        }

*/











        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String testMeNeed = intent.getStringExtra("ExamFragment");
        if(testMeNeed.equals("ExamFragment")){
        Log.d("MyFirstFragment", testMeNeed);
        fragmentClass = ExamFragment.class;
                try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        }
        }


    @Override
    public void onBackPressed() {

        openQuitDialog();
       /* DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.exam, menu);
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

        /*
        fragment = null;
        fragmentClass = null;
        if(fragmentClass == null) {
            fragmentClass = HelloFragment.class;
        }
        */

        if (id == R.id.nav_camera) {
            fragmentClass = ExamFragment.class;
        } else if (id == R.id.nav_gallery) {
            fragmentClass = ResultsFragment.class;


        } else if (id == R.id.nav_slideshow) {
            fragmentClass = RemindersFragment.class;

        } else if (id == R.id.nav_share) {
            final Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String textToSend="";
            intent.putExtra(Intent.EXTRA_TEXT, textToSend);
            try
            {
                startActivity(Intent.createChooser(intent, "Описание действия"));
            }
            catch (android.content.ActivityNotFoundException ex)
            {
                Toast.makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_SHORT).show();
            }
        }
       // if(fragment == null) {
            try {
                fragment = (Fragment) fragmentClass.newInstance();
                Bundle bundle = new Bundle();
                bundle.putString("id", mId);
                fragment.setArguments(bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
       // }

        // Вставляем фрагмент, заменяя текущий фрагмент
      //   fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container,fragment).commit();
        // Выделяем выбранный пункт меню в шторке
        item.setChecked(true);
        // Выводим выбранный пункт в заголовке
        setTitle(item.getTitle());


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


        return true;
    }





    private void openQuitDialog() {

        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                ActivityFragments.this);
        quitDialog.setTitle("Выход");
        quitDialog.setMessage("Вы действительно хотите выйти?");

        quitDialog.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                finish();
            }
        });

        quitDialog.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });

        quitDialog.show();

    }



}

