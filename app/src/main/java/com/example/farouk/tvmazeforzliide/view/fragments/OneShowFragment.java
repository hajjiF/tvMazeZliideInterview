package com.example.farouk.tvmazeforzliide.view.fragments;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;


import com.example.farouk.tvmazeforzliide.R;
import com.example.farouk.tvmazeforzliide.model.entity.Episode;
import com.example.farouk.tvmazeforzliide.model.entity.Season;
import com.example.farouk.tvmazeforzliide.model.entity.Show;
import com.example.farouk.tvmazeforzliide.presenter.OneShowPresenter;
import com.example.farouk.tvmazeforzliide.view.IOneShowView;
import com.example.farouk.tvmazeforzliide.view.adapters.EpisodesExpendableListViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;



public class OneShowFragment extends Fragment implements IOneShowView {
    public static final String TAG = OneShowFragment.class.getSimpleName();
    OneShowPresenter mOneShowPresenter;
    EpisodesExpendableListViewAdapter mEpisodesExpendableListViewAdapter;
    private int mShowId;
    ProgressBar mProgressBar;
    ImageView mCoverImageView;
    TextView mShowTitleTextView;
    TextView mNetworkTextView;
    TextView mLangagetextView;
    TextView mSummaryTextView;
    RatingBar mRatingBar;
    private ExpandableListView mExpandableListView;

    private OnFragmentInteractionListener mListener;

    public OneShowFragment() {
    }

    public static OneShowFragment newInstance(int showId) {
        OneShowFragment fragment = new OneShowFragment();
        fragment.mShowId = showId;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_show, container, false);
        mProgressBar = view.findViewById(R.id.progressBar);
        mCoverImageView = view.findViewById(R.id.imageView);
        mShowTitleTextView = view.findViewById(R.id.ShowName);
        mLangagetextView = view.findViewById(R.id.ShowLangage);
        mNetworkTextView = view.findViewById(R.id.ShowNetwork);
        mSummaryTextView = view.findViewById(R.id.textView);
        mRatingBar = view.findViewById(R.id.ShowRating);
        mExpandableListView =view.findViewById(R.id.expandableListView);
        mOneShowPresenter = new OneShowPresenter(this);
        mOneShowPresenter.loadOneShow(mShowId);
        mOneShowPresenter.loadEpisodes(mShowId);
        return view;
    }
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mOneShowPresenter.unsubscribe();
        mListener = null;
    }

    @Override
    public void displayLoadingProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayNoShow() {
        createDialogView("can't display show info !");
    }
    @Override
    public void displayShow(Show show) {
        Picasso.with(getActivity()).load(show.getImage().getMedium()).into(mCoverImageView);
        mShowTitleTextView.setText(show.getName());
        mLangagetextView.setText(show.getLanguage());
        mNetworkTextView.setText(show.getNetwork().getName() +" [ "+show.getNetwork().getCountry().getName()+" ]");
        mSummaryTextView.setText(Html.fromHtml(show.getSummary()));
        mRatingBar.setRating((float)show.getRating().getAverage()/2);
    }

    @Override
    public void showError(Throwable e) {
        Log.d("error", e.getMessage());
        createDialogView("error occurred");
    }

    @Override
    public void dismissLoadingProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void displayNoEpisodes() {
        createDialogView("can't display show episodes !");
    }

    @Override
    public void displayEpisodes(List<Season> seasons, List<List<Episode>> episodesBySeason) {
        mEpisodesExpendableListViewAdapter = new EpisodesExpendableListViewAdapter(getActivity().getApplicationContext(),seasons,episodesBySeason);
        mExpandableListView.setAdapter(mEpisodesExpendableListViewAdapter);
    }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
    public void createDialogView(String message){
        Dialog myDialog = new Dialog(getContext());
        myDialog.setContentView(R.layout.no_internet_dialog);
        myDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        myDialog.setCancelable(false);
        myDialog.setCanceledOnTouchOutside(false);
        TextView mMessageTextView = myDialog.findViewById(R.id.tv_message);
        mMessageTextView.setText(message);
        myDialog.show();
    }
}
