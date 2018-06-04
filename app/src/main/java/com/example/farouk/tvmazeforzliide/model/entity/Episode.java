package com.example.farouk.tvmazeforzliide.model.entity;

/**
 * Created by farouk on 03/06/2018.
 */

public class Episode {

    /**
     * id : 1
     * url : http://www.tvmaze.com/episodes/1/under-the-dome-1x01-pilot
     * name : Pilot
     * season : 1
     * number : 1
     * airdate : 2013-06-24
     * airtime : 22:00
     * airstamp : 2013-06-25T02:00:00+00:00
     * runtime : 60
     * image : {"medium":"http://static.tvmaze.com/uploads/images/medium_landscape/1/4388.jpg","original":"http://static.tvmaze.com/uploads/images/original_untouched/1/4388.jpg"}
     * summary : <p>When the residents of Chester's Mill find themselves trapped under a massive transparent dome with no way out, they struggle to survive as resources rapidly dwindle and panic quickly escalates.</p>
     */

    private int id;
    private String url;
    private String name;
    private int season;
    private int number;
    private String airdate;
    private String airtime;
    private String airstamp;
    private int runtime;
    private Image image;
    private String summary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAirdate() {
        return airdate;
    }

    public void setAirdate(String airdate) {
        this.airdate = airdate;
    }

    public String getAirtime() {
        return airtime;
    }

    public void setAirtime(String airtime) {
        this.airtime = airtime;
    }

    public String getAirstamp() {
        return airstamp;
    }

    public void setAirstamp(String airstamp) {
        this.airstamp = airstamp;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
