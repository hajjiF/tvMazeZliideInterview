package com.example.farouk.tvmazeforzliide.view;

import com.example.farouk.tvmazeforzliide.model.entity.Show;

import java.util.List;


/**
 * Created by farouk on 03/06/2018.
 */

public interface IShowsView {
    void displayNoShows();

    void displayLoadingProgress();

    void displayShows(List<Show> shows);

    void showError(Throwable e);

    void dismissLoadingProgress();
}
