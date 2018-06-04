package com.example.farouk.tvmazeforzliide.presenter;

import com.example.farouk.tvmazeforzliide.model.entity.Show;
import com.example.farouk.tvmazeforzliide.model.network.ShowService;
import com.example.farouk.tvmazeforzliide.view.IShowsView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by farouk on 03/06/2018.
 */

public class ShowsPresenter {
    IShowsView view;
    CompositeDisposable subscriptions = new CompositeDisposable();

    public ShowsPresenter(IShowsView view) {
        this.view = view;
    }

    public void loadShows() {
        view.displayLoadingProgress();
        subscriptions.add(
                ShowService.getRetrofit().getAllShows().observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io()).subscribeWith(
                        new DisposableObserver<List<Show>>() {
                            @Override
                            public void onNext(List<Show> shows) {
                                if (shows.isEmpty()) {
                                    view.displayNoShows();
                                } else {
                                    view.displayShows(shows);
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
                )
        );
    }
    public void unsubscribe(){
        subscriptions.clear();
    }
}
