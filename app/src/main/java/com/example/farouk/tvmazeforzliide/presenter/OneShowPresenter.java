package com.example.farouk.tvmazeforzliide.presenter;

import com.example.farouk.tvmazeforzliide.model.entity.Episode;
import com.example.farouk.tvmazeforzliide.model.entity.Season;
import com.example.farouk.tvmazeforzliide.model.entity.Show;
import com.example.farouk.tvmazeforzliide.model.network.ShowService;
import com.example.farouk.tvmazeforzliide.view.IOneShowView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by farouk on 03/06/2018.
 */

public class OneShowPresenter {
    IOneShowView view;
    CompositeDisposable subscriptions = new CompositeDisposable();

    public OneShowPresenter(IOneShowView view) {
        this.view = view;
    }
    public void loadOneShow(int showId){
        view.displayLoadingProgress();
        subscriptions.add(ShowService.getRetrofit().getShowSeasons(showId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(
                        new DisposableObserver<List<Season>>() {
                            @Override
                            public void onNext(List<Season> seasons) {
                                if(seasons.isEmpty()){
                                    view.displayNoEpisodes();
                                }else{
                                    List<List<Episode>> episodesBySeason=new ArrayList<List<Episode>>();
                                    for(Season season : seasons){
                                        ShowService.getRetrofit().getSeasonEpisodes(season.getId())
                                                .observeOn(AndroidSchedulers.mainThread())
                                                .subscribeOn(Schedulers.io())
                                                .subscribeWith(new DisposableObserver<List<Episode>>() {
                                                    @Override
                                                    public void onNext(List<Episode> episodes) {
                                                        episodesBySeason.add(episodes);
                                                        view.displayEpisodes(seasons,episodesBySeason);
                                                    }

                                                    @Override
                                                    public void onError(Throwable e) {
                                                        view.showError(e);
                                                    }

                                                    @Override
                                                    public void onComplete() {
                                                    }
                                                });
                                    }
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                view.showError(e);
                            }

                            @Override
                            public void onComplete() {
                                view.dismissLoadingProgress();
                            }
                        }
                ));
    }
    public void loadEpisodes(int showId){
        view.displayLoadingProgress();
        subscriptions.add(
                ShowService.getRetrofit().getShow(showId)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribeWith(
                                new DisposableObserver<Show>() {
                                    @Override
                                    public void onNext(Show show) {
                                        if (show==null) {
                                            view.displayNoShow();
                                        } else {
                                            view.displayShow(show);
                                        }
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        view.dismissLoadingProgress();
                                        view.showError(e);
                                    }

                                    @Override
                                    public void onComplete() {
                                        view.dismissLoadingProgress();
                                    }
                                }
                        )
        );
    }
    public void unsubscribe(){
        subscriptions.clear();
    }
}
