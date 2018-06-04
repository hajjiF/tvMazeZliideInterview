package com.example.farouk.tvmazeforzliide.view.fragments;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.farouk.tvmazeforzliide.R;
import com.example.farouk.tvmazeforzliide.model.entity.Show;
import com.example.farouk.tvmazeforzliide.presenter.ShowsPresenter;
import com.example.farouk.tvmazeforzliide.view.IShowsView;
import com.example.farouk.tvmazeforzliide.view.adapters.ShowsGridAdapter;

import java.util.List;



public class ShowsFragment extends Fragment implements IShowsView {

    public static final String TAG = ShowsFragment.class.getSimpleName();
    ShowsPresenter mShowsPresenter;
    ShowsGridAdapter mShowsGridAdapter;
    List<Show> mShowList;
    ProgressBar mProgressBar;
    GridView mGridView;
    SearchView mSearchView;



    private OnFragmentInteractionListener mListener;

    public ShowsFragment() {
        // Required empty public constructor
    }

    public static ShowsFragment newInstance(String arg) {
        ShowsFragment fragment = new ShowsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shows, container, false);
        mProgressBar = view.findViewById(R.id.progressBarShowsGrid);
        mGridView = view.findViewById(R.id.gridView);
        mSearchView = view.findViewById(R.id.searchViewFilterGrid);
        mShowsPresenter = new ShowsPresenter(this);
        mShowsPresenter.loadShows();
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
        mListener = null;
        mShowsPresenter.unsubscribe();
    }

    @Override
    public void displayNoShows() {
        Log.d("list of shows", "no shows found");
        createDialogView("can't display shows");
    }

    @Override
    public void displayLoadingProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayShows(List<Show> shows) {
        mShowList = shows;
        mShowsGridAdapter = new ShowsGridAdapter(getContext(), mShowList);
        mGridView.setAdapter(mShowsGridAdapter);
        mGridView.setOnItemClickListener((parent, view, position, id) -> {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame, OneShowFragment.newInstance(mShowsGridAdapter.getItem(position).getId()),OneShowFragment.TAG)
                    .addToBackStack(OneShowFragment.TAG)
                    .commit();
        });
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                mShowsGridAdapter.getFilter().filter(s.toString());
                return true;
            }
        });
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
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
