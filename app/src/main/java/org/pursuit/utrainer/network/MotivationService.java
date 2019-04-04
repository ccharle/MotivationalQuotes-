package org.pursuit.utrainer.network;

import org.pursuit.utrainer.model.MotivationalQuotes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface    MotivationService {
    @GET("/ccharle/MotivationalQuotes-/master/MotivationalQuotes.json")
    Call<MotivationalQuotes.MotivationalResponse> getQuotes();
}
