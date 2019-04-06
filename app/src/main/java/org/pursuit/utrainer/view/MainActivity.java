package org.pursuit.utrainer.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
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

public class MainActivity extends FragmentActivity implements WorkOutProgramsFragment.OnFragmentInteractionListener, DisplayWorkOutFragment.OnProgramFragmentInteractionListener {
    private static final String TAG = "This is my error";
    private TabLayout uTrainerTabLayout;
    private ViewPager programsViewPager;
    private ImageView selectedTabImageView;
    private TextView quotesTextView;
    private String motivationalQuotes;
    private List<MotivationalQuotes> motivationalQuotesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onProgramTabSelected();
        setViews();
        setTabImageView();
        tabPositonChange();
        // uTrainerTabLayout.setupWithViewPager(programsViewPager);
        setRetrofit();


    }


    private void setViews() {
        uTrainerTabLayout = findViewById(R.id.utrainer_tabLayout);
         programsViewPager = findViewById(R.id.main_viewpager);

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

    private void tabPositonChange() {
        uTrainerTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int tabPosition = tab.getPosition();
                loadTabPhoto(tabPosition);
                switch (tabPosition) {

                    case 0: {
                        selectedTabImageView.setImageResource(R.drawable.barbell_overhead);
                        onProgramTabSelected();


                        break;

                    }
                    case 1: {
                        selectedTabImageView.setImageResource(R.drawable.pushup);
                        randomQuoteGenerator();
                        break;
                    }
                    case 2: {
                        selectedTabImageView.setImageResource(R.drawable.chart);
                        randomQuoteGenerator();
                        break;

                    }
                    case 3: {
                        selectedTabImageView.setImageResource(R.drawable.history);
                        break;

                    }
                    default:
                        break;
                }
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

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
                        quotesTextView.setText("Connection Error");
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

        WorkOutProgramsFragment workOutProgramsFragment = new WorkOutProgramsFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, workOutProgramsFragment)
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
                .commit();
    }
}

