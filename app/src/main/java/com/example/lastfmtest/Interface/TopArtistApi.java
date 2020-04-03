package com.example.lastfmtest.Interface;

import com.example.lastfmtest.Model.Topartists;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TopArtistApi {
    @GET("2.0/?method=geo.gettoptracks&country=spain&api_key=829751643419a7128b7ada50de590067&format=json")
    Call<List<Topartists>> getTopArtist();
}
