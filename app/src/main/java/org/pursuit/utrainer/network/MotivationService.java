package org.pursuit.utrainer.network;

import org.pursuit.utrainer.model.MotivationalQuotes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface    MotivationService {
    @GET("ccharle/413794a17f39cf61fefadc77bfbde4f7/raw/1cc06dd53505a61c275a6fb98e2f51097e7d995f/gistfile1.txt")
    Call<MotivationalQuotes.MotivationalQuotesResponse> getQuotes();
}
