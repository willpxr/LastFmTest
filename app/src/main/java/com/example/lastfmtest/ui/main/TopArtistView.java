package com.example.lastfmtest.ui.main;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.lastfmtest.Interface.TopArtistApi;
import com.example.lastfmtest.Model.Topartists;
import com.example.lastfmtest.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TopArtistView extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.topartistview, container, false);

        TextView mJsonTxtView = rootView.findViewById(R.id.mJsonTxtView);
        getTopArtist();
        return rootView;

    }



    private void   getTopArtist(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ws.audioscrobbler.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TopArtistApi TopArtistApi =retrofit.create(TopArtistApi.class);


        Call<List<Topartists>> call =  TopArtistApi.getTopArtist();
        call.enqueue(new Callback<List<Topartists>>() {
            @Override
            public void onResponse(Call<List<Topartists>> call, Response<List<Topartists>> response) {
                TextView mJsonTxtView = null;
                if (!response.isSuccessful()){
                    mJsonTxtView.setText("Codigo: " +response.code());
                    return;
                }
                List<Topartists> Topartistlist = response.body();

                for(Topartists topartists: Topartistlist){
                    String content = "" + ("ArtistElement: " + topartists.getArtist() + "\n\n");
                    mJsonTxtView.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Topartists>> call, Throwable t) {


            }
        });
    }
}
