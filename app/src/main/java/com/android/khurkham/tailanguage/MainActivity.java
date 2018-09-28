package com.android.khurkham.tailanguage;
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
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    private HomeFragment homeFragment = new HomeFragment();
    private Menubooks1 menubooks1Fragment = new Menubooks1();
    private Menubooks2 menubooks2Fragment = new Menubooks2();
    private Menubooks3 menubooks3Fragment = new Menubooks3();
    private Menubooks4 menubooks4Fragment = new Menubooks4();
    private Menubooks5 menubooks5Fragment = new Menubooks5();
    private Menubooks6 menubooks6Fragment = new Menubooks6();

    private ShareFragment shareFragment = new ShareFragment();
    private SendFragment sendFragment = new SendFragment();

    private Fragment fragmentCurrent;
    private int currentMenuItem;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window w = getWindow(); // in Activity's onCreate() for instance
//           // w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//
//            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }



        setContentView(R.layout.activity_main);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("XXXXXXXX" , "click");
                onBackPressed();
            }
        });

        drawer.addDrawerListener(toggle);

        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);


        currentMenuItem = R.id.nav_menu_books1;//default first item
        this.getSupportFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        if (fragmentCurrent instanceof Menubooks1) {
                            currentMenuItem = R.id.nav_menu_books1;
                            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                            toggle.setDrawerIndicatorEnabled(true);

                        } else if (fragmentCurrent instanceof Menubooks2) {
                            currentMenuItem = R.id.nav_menu_books2;
                            toggle.setDrawerIndicatorEnabled(false);
                            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                        } else if (fragmentCurrent instanceof Menubooks3) {
                            currentMenuItem = R.id.nav_menu_books3;
                            toggle.setDrawerIndicatorEnabled(false);
                            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                        } else if (fragmentCurrent instanceof Menubooks4) {
                            currentMenuItem = R.id.nav_menu_books4;
                            toggle.setDrawerIndicatorEnabled(false);
                            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                        } else if (fragmentCurrent instanceof Menubooks5) {
                            currentMenuItem = R.id.nav_menu_books5;
                            toggle.setDrawerIndicatorEnabled(false);
                            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                        } else if (fragmentCurrent instanceof Menubooks6) {
                            currentMenuItem = R.id.nav_menu_books6;
                            toggle.setDrawerIndicatorEnabled(false);
                            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                        } else if (fragmentCurrent instanceof ShareFragment) {
                            currentMenuItem = R.id.nav_share;
                            toggle.setDrawerIndicatorEnabled(false);
                            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                        } else {
                            currentMenuItem = R.id.nav_send;
                            toggle.setDrawerIndicatorEnabled(false);
                            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                        }
                        navigationView.setCheckedItem(currentMenuItem);
                    }
                });

        if (savedInstanceState == null) {
            addFragment(menubooks1Fragment);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (fragmentCurrent.equals(menubooks1Fragment)) {
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                super.onBackPressed();
            } else {
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                replaceFragment(menubooks1Fragment);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragmentSelected = null;
        int id = item.getItemId();
        if (id == currentMenuItem) {
            drawer.closeDrawer(GravityCompat.START);
            return false;
        }
        if (id == R.id.nav_menu_books1) {
            fragmentSelected = menubooks1Fragment;

        } else if (id == R.id.nav_menu_books2) {
            fragmentSelected = menubooks2Fragment;

        } else if (id == R.id.nav_menu_books3) {
            fragmentSelected = menubooks3Fragment;

        } else if (id == R.id.nav_menu_books4) {
            fragmentSelected = menubooks4Fragment;

        } else if (id == R.id.nav_menu_books5) {
            fragmentSelected = menubooks5Fragment;

        } else if (id == R.id.nav_menu_books6) {
            fragmentSelected = menubooks6Fragment;

        } else if (id == R.id.nav_share) {
            fragmentSelected = shareFragment;
        } else if (id == R.id.nav_send) {
            fragmentSelected = sendFragment;
        }
        currentMenuItem = id;
        replaceFragment(fragmentSelected);

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void addFragment(Fragment fragment) {
        fragmentCurrent = fragment;
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, fragment).commit();
        navigationView.setCheckedItem(currentMenuItem);
    }

    private void replaceFragment(Fragment fragment) {
        fragmentCurrent = fragment;
        navigationView.setCheckedItem(currentMenuItem);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}