package com.example.lastfmtest.Model;

import java.util.List;

public class Track {
    private String name;
    private String duration;
    private String listeners;
    private String mbid;
    private String url;
    private Streamable streamable;
    private TrackArtist artist;
    private List<Image> image;
    private TrackAttr attr;

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
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

    public Streamable getStreamable() {
        return streamable;
    }

    public TrackArtist getArtist() {
        return artist;
    }

    public List<Image> getImage() {
        return image;
    }

    public TrackAttr getAttr() {
        return attr;
    }
}