package com.example.lastfmtest.Model;

import java.util.List;

public class ArtistElement {
    private String name;
    private String listeners;
    private String mbid;
    private String url;
    private String streamable;
    private List<Image> image;

    public String getName() {
        return name;
    }

    public String getListeners() {
        return listeners;
    }

    public String getMbid() {
        return mbid;
    }

    public String getUrl() {
        return url;
    }

    public String getStreamable() {
        return streamable;
    }

    public List<Image> getImage() {
        return image;
    }
}