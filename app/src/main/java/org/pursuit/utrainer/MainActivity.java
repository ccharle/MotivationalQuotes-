package org.pursuit.utrainer;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;


import org.pursuit.utrainer.model.MotivationalQuotes;
import org.pursuit.utrainer.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends FragmentActivity {
    private static final String TAG = "This is my error";
    private TabLayout uTrainerTabLayout;
    private ViewPager programsViewPager;
    private ImageView selectedTabImageView;

    private List<MotivationalQuotes> motivationalQuotesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        setTabImageView();
        tabPositonChange();
        uTrainerTabLayout.setupWithViewPager(programsViewPager);
        setRetrofit();


    }


    private void loadTabPhoto(int tabPosition) {
        switch (tabPosition) {

            case 0: {
                selectedTabImageView.setImageResource(R.drawable.barbell_overhead);

            }

        }
    }

    private void setViews() {
        uTrainerTabLayout = findViewById(R.id.utrainer_tabLayout);
        programsViewPager = findViewById(R.id.programs_viewpager);

        selectedTabImageView = findViewById((R.id.selected_tab_imageView));


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
                        break;

                    }
                    case 1: {
                        selectedTabImageView.setImageResource(R.drawable.pushup);
                        break;
                    }
                    case 2: {
                        selectedTabImageView.setImageResource(R.drawable.chart);
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
                .enqueue(new Callback<MotivationalQuotes.MotivationalQuotesResponse>() {
                    @Override
                    public void onResponse(Call<MotivationalQuotes.MotivationalQuotesResponse> call, Response<MotivationalQuotes.MotivationalQuotesResponse> response) {
                        Log.d(TAG, "OnResponse" + response.body());
                        motivationalQuotesList.addAll(response.body().getMotivationalQuotes());

                    }

                    @Override
                    public void onFailure(Call<MotivationalQuotes.MotivationalQuotesResponse> call, Throwable t) {
                        Log.d(TAG,"OnFailure"+t.getMessage());
                    }
                });


    }
}

