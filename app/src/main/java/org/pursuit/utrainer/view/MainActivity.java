package org.pursuit.utrainer.view;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import org.pursuit.utrainer.R;
import org.pursuit.utrainer.controller.ViewPagerAdapter;
import org.pursuit.utrainer.fragment.DisplayWorkOutFragment;
import org.pursuit.utrainer.fragment.WorkOutProgramsFragment;
import org.pursuit.utrainer.model.MotivationalQuotes;
import org.pursuit.utrainer.model.ProgramsDetail;
import org.pursuit.utrainer.model.WorkoutPrograms;
import org.pursuit.utrainer.network.RetrofitSingleton;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements WorkOutProgramsFragment.OnFragmentInteractionListener, DisplayWorkOutFragment.OnProgramFragmentInteractionListener {
    private static final String TAG = "This is my error";
    private TabLayout uTrainerTabLayout;
    private ViewPager programsViewPager;
    private ImageView selectedTabImageView;
    private TextView quotesTextView;
    private String motivationalQuotes;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private String onConnectionFailure;
    private Toolbar toolbar;
    private List<MotivationalQuotes> motivationalQuotesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onProgramTabSelected();
        messageTimer();
        setViews();
        onNavItemSelection();
        setTabImageView();
        //tabPositonChange();
//        uTrainerTabLayout.setupWithViewPager(programsViewPager);
        setRetrofit();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setViews() {

        //uTrainerTabLayout = findViewById(R.id.utrainer_tabLayout);
        //programsViewPager = findViewById(R.id.main_viewpager);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.menu_button);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        selectedTabImageView = findViewById((R.id.selected_tab_imageView));
        quotesTextView = findViewById(R.id.motivationalquotes_textview);


    }

    private void loadTabPhoto(int tabPosition) {
        switch (tabPosition) {

            case 0: {
                selectedTabImageView.setImageResource(R.drawable.barbell_overhead);

            }

        }
    }

    private void setTabImageView() {

        loadTabPhoto(0);

    }

//    private void tabPositonChange() {
//        uTrainerTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//                int tabPosition = tab.getPosition();
//                loadTabPhoto(tabPosition);
//                switch (tabPosition) {
//
//                    case 0: {
//                        selectedTabImageView.setImageResource(R.drawable.barbell_overhead);
//                        onProgramTabSelected();
//
//
//                        break;
//
//                    }
//                    case 1: {
//                        selectedTabImageView.setImageResource(R.drawable.pushup);
//                        randomQuoteGenerator();
//                        break;
//                    }
//                    case 2: {
//                        selectedTabImageView.setImageResource(R.drawable.chart);
//                        randomQuoteGenerator();
//                        break;
//
//                    }
//                    case 3: {
//                        selectedTabImageView.setImageResource(R.drawable.history);
//                        break;
//
//                    }
//                    default:
//                        break;
//                }
//            }
//
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//    }

    public void setRetrofit() {
        RetrofitSingleton.getInstance()
                .getMotivationService()
                .getQuotes()
                .enqueue(new Callback<MotivationalQuotes.MotivationalResponse>() {
                    @Override
                    public void onResponse(Call<MotivationalQuotes.MotivationalResponse> call, Response<MotivationalQuotes.MotivationalResponse> response) {
                        Log.d(TAG, "OnResponse" + response.body());
                        motivationalQuotesList.addAll(response.body().getMotivational());
                        randomQuoteGenerator();

                    }

                    @Override
                    public void onFailure(Call<MotivationalQuotes.MotivationalResponse> call, Throwable t) {
                        Log.d(TAG, "OnFailure" + t.getMessage());
                        onConnectionFailure = getResources().getString(R.string.onConnectionFailure);
                        quotesTextView.setText(onConnectionFailure);
                    }
                });


    }

    private void randomQuoteGenerator() {
        Random random = new Random();
        int quoteChoice = random.nextInt(motivationalQuotesList.size());

        MotivationalQuotes motive = motivationalQuotesList.get(quoteChoice);

        //List<Method> methods = new ArrayList<>();
        List<Method> quotesList = Arrays.asList(motive.getClass().getMethods());

        Log.d(MainActivity.class.getName(), "onMethodList: " + Arrays.toString(motive.getClass().getMethods()));

        int secondRandom = random.nextInt(10 - 3 + 1) + 3;

        try {
            motivationalQuotes = String.valueOf((quotesList.get(secondRandom).invoke(motive)));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        quotesTextView.setText(motivationalQuotes);
    }

    private void onProgramTabSelected() {

       //uTrainerTabLayout.setupWithViewPager(programsViewPager);
        WorkOutProgramsFragment workOutProgramsFragment = new WorkOutProgramsFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, workOutProgramsFragment)
                .addToBackStack("workoutprograms")
                .commit();


    }


    private void preLoadedPrograms() {
        WorkoutPrograms PHAT = new WorkoutPrograms("P.H.A.T");


    }


    @Override
    public void onFragmentInteraction() {
        DisplayWorkOutFragment displayWorkOutFragment = new DisplayWorkOutFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, displayWorkOutFragment)
                .commit();


    }

    @Override
    public void onFragmentInteraction(String workout) {
        DisplayWorkOutFragment displayWorkOutFragment = DisplayWorkOutFragment.newInstance(workout);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, displayWorkOutFragment)
                .addToBackStack(displayWorkOutFragment.getClass().getSimpleName())
                .commit();
    }

    public void onNavItemSelection() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                drawerLayout.closeDrawers();

                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here

                return true;
            }
        });
    }

    public void messageTimer() {
        Thread thread = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(180000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                randomQuoteGenerator();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        thread.start();
    }
}

