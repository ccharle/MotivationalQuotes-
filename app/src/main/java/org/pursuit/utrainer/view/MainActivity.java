package org.pursuit.utrainer.view;

import android.arch.persistence.room.Room;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.utrainer.R;
import org.pursuit.utrainer.database.UTrainerDatabase;
import org.pursuit.utrainer.database.WorkOutDatabase;
import org.pursuit.utrainer.fragment.DisplayHistoryFragment;
import org.pursuit.utrainer.fragment.DisplayWorkOutFragment;
import org.pursuit.utrainer.fragment.MainScreenFragment;
import org.pursuit.utrainer.fragment.WorkOutProgramsFragment;
import org.pursuit.utrainer.model.MotivationalQuotes;
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

public class MainActivity extends AppCompatActivity implements WorkOutProgramsFragment.OnFragmentInteractionListener,
        DisplayWorkOutFragment.OnProgramFragmentInteractionListener,
        DisplayHistoryFragment.OnHistoryFragmentInteractionListener {
    private static final String TAG = "This is my error";
    private ImageView selectedTabImageView;
    private TextView quotesTextView;
    private String motivationalQuotes;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private String onConnectionFailure;
    private Toolbar toolbar;
    private UTrainerDatabase uTrainerDatabase;
    private List<MotivationalQuotes> motivationalQuotesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uTrainerDatabase = Room.databaseBuilder(this, UTrainerDatabase.class, "db - workout").build();
        setViews();
        //messageTimer();
        onNavItemSelection();
        // setTabImageView();

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

            case R.id.nav_program:

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


    private void initiateMainFragment() {
        MainScreenFragment mainScreenFragment = new MainScreenFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, mainScreenFragment)
                .commit();


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
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            // set item as selected to persist highlight
            menuItem.setChecked(true);
            // close drawer when item is tapped
            drawerLayout.closeDrawers();

            switch (menuItem.getItemId()) {

                case R.id.nav_program:
                    onProgramTabSelected();
                    break;

                case R.id.nav_progress:
                    initiateMainFragment();
                    break;

            }
            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            return true;
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


    public void addWorkout() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                WorkOutDatabase workOutDatabase = new WorkOutDatabase();
                workOutDatabase.setExerciseName("Barbell Curl");
            }
        }).start();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

