package org.pursuit.utrainer.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static RetrofitSingleton ourInstance = null;
    private MotivationService motivationService;

    private RetrofitSingleton(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    motivationService = retrofit.create(MotivationService.class);
    }
public static RetrofitSingleton getInstance(){
        if(ourInstance == null){
            ourInstance = new RetrofitSingleton();


        }
        return ourInstance;


}
    public MotivationService getMotivationService(){return motivationService;}


}
