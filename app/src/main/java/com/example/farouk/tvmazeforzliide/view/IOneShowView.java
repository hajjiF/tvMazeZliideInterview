package com.example.farouk.tvmazeforzliide.view;

import com.example.farouk.tvmazeforzliide.model.entity.Episode;
import com.example.farouk.tvmazeforzliide.model.entity.Season;
import com.example.farouk.tvmazeforzliide.model.entity.Show;

import java.util.List;



/**
 * Created by farouk on 03/06/2018.
 */

public interface IOneShowView {
    void displayLoadingProgress();

    void displayNoShow();

    void displayShow(Show show);

    void showError(Throwable e);

    void dismissLoadingProgress();

    void displayNoEpisodes();

    void displayEpisodes(List<Season> seasons, List<List<Episode>> episodesBySeason);
}
