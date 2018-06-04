package com.example.farouk.tvmazeforzliide.model.entity;

/**
 * Created by farouk on 03/06/2018.
 */

public class Season {

    /**
     * id : 1
     * url : http://www.tvmaze.com/seasons/1/under-the-dome-season-1
     * number : 1
     * name :
     * episodeOrder : 13
     * premiereDate : 2013-06-24
     * endDate : 2013-09-16
     * network : {"id":2,"name":"CBS","country":{"name":"United States","code":"US","timezone":"America/New_York"}}
     * webChannel : null
     * image : {"medium":"http://static.tvmaze.com/uploads/images/medium_portrait/24/60941.jpg","original":"http://static.tvmaze.com/uploads/images/original_untouched/24/60941.jpg"}
     * summary :
     */

    private int id;
    private String url;
    private int number;
    private String name;
    private int episodeOrder;
    private String premiereDate;
    private String endDate;
    private Network network;
    private Object webChannel;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEpisodeOrder() {
        return episodeOrder;
    }

    public void setEpisodeOrder(int episodeOrder) {
        this.episodeOrder = episodeOrder;
    }

    public String getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(String premiereDate) {
        this.premiereDate = premiereDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public Object getWebChannel() {
        return webChannel;
    }

    public void setWebChannel(Object webChannel) {
        this.webChannel = webChannel;
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
