package com.example.farouk.tvmazeforzliide.model.network;

import com.example.farouk.tvmazeforzliide.model.entity.Cast;
import com.example.farouk.tvmazeforzliide.model.entity.Episode;
import com.example.farouk.tvmazeforzliide.model.entity.Season;
import com.example.farouk.tvmazeforzliide.model.entity.Show;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by farouk on 03/06/2018.
 */

public interface IShowService {

    @GET("shows/{showId}/cast")
    Observable<List<Cast>> getShowCasts(@Path("showId") int showId);

    @GET("seasons/{seasonId}/episodes")
    Observable<List<Episode>> getSeasonEpisodes(@Path("seasonId") int seasonId);

    @GET("shows/{showId}/seasons")
    Observable<List<Season>> getShowSeasons(@Path("showId") int showId);

    @GET("shows")
    Observable<List<Show>> getAllShows();

    @GET("shows/{showId}")
    Observable<Show> getShow(@Path("showId") int showId);

}
