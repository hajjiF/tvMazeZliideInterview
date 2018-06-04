package com.example.farouk.tvmazeforzliide.model.entity;

import java.util.List;

/**
 * Created by farouk on 03/06/2018.
 */

public class Show {

    /**
     * id : 1
     * url : http://www.tvmaze.com/shows/1/under-the-dome
     * name : Under the Dome
     * type : Scripted
     * language : English
     * genres : ["Drama","Science-Fiction","Thriller"]
     * status : Ended
     * runtime : 60
     * premiered : 2013-06-24
     * officialSite : http://www.cbs.com/shows/under-the-dome/
     * schedule : {"time":"22:00","days":["Thursday"]}
     * rating : {"average":6.5}
     * weight : 90
     * network : {"id":2,"name":"CBS","country":{"name":"United States","code":"US","timezone":"America/New_York"}}
     * webChannel : null
     * externals : {"tvrage":25988,"thetvdb":264492,"imdb":"tt1553656"}
     * image : {"medium":"http://static.tvmaze.com/uploads/images/medium_portrait/0/1.jpg","original":"http://static.tvmaze.com/uploads/images/original_untouched/0/1.jpg"}
     * summary : <p><b>Under the Dome</b> is the story of a small town that is suddenly and inexplicably sealed off from the rest of the world by an enormous transparent dome. The town's inhabitants must deal with surviving the post-apocalyptic conditions while searching for answers about the dome, where it came from and if and when it will go away.</p>
     * updated : 1507165279
     * _links : {"self":{"href":"http://api.tvmaze.com/shows/1"},"previousepisode":{"href":"http://api.tvmaze.com/episodes/185054"}}
     */

    private int id;
    private String url;
    private String name;
    private String type;
    private String language;
    private String status;
    private int runtime;
    private String premiered;
    private String officialSite;
    private Schedule schedule;
    private Rating rating;
    private int weight;
    private Network network;
    private Object webChannel;
    private Externals externals;
    private Image image;
    private String summary;
    private int updated;
    private List<String> genres;

    public Rating getRating() {
        return rating;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public String getOfficialSite() {
        return officialSite;
    }

    public void setOfficialSite(String officialSite) {
        this.officialSite = officialSite;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    public Externals getExternals() {
        return externals;
    }

    public void setExternals(Externals externals) {
        this.externals = externals;
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

    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}
