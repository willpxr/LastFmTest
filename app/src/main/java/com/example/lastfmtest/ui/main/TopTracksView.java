package com.example.lastfmtest.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.lastfmtest.Interface.TopTracksApi;
import com.example.lastfmtest.Model.Tracks;
import com.example.lastfmtest.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TopTracksView extends Fragment {
    private TextView mJsonTxtView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.topartistview, container, false);

        mJsonTxtView = rootView.findViewById(R.id.mJsonTxtView);
        getTracks();
        return rootView;

    }

    private void getTracks(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ws.audioscrobbler.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TopTracksApi topTracksApi = retrofit.create(TopTracksApi.class);
        Call<List<Tracks>> call = topTracksApi.getTrack();

        call.enqueue(new Callback<List<Tracks>>() {
            @Override
            public void onResponse(Call<List<Tracks>> call, Response<List<Tracks>> response) {

                if(!response.isSuccessful()){
                    mJsonTxtView.setText("codigo: "+response.code());
                    return;
                }

                List<Tracks> tracksList = response.body();

                for(Tracks tracks: tracksList){
                    String content = "";
                    content += "track: " + Tracks.getTrack() + "\n\n";
                    mJsonTxtView.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Tracks>> call, Throwable t) {
                mJsonTxtView.setText(t.getMessage());

            }
        });






        }
    }

