package com.example.farouk.tvmazeforzliide;

import android.app.Dialog;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.farouk.tvmazeforzliide.tools.ConnectionReceiver;
import com.example.farouk.tvmazeforzliide.view.fragments.OneShowFragment;
import com.example.farouk.tvmazeforzliide.view.fragments.ShowsFragment;

public class MainActivity extends AppCompatActivity implements ShowsFragment.OnFragmentInteractionListener,
        OneShowFragment.OnFragmentInteractionListener, ConnectionReceiver.ConnectionReceiverListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    ShowsFragment mShowsFragment;
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("TV Maze");
        myDialog = new Dialog(this);
        checkConnection();
    }
    private void loadFragment(){
        if (mShowsFragment == null) {
            mShowsFragment = new ShowsFragment();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame,mShowsFragment,ShowsFragment.TAG)
                .commit();
        myDialog.dismiss();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public void setConnectionListener(ConnectionReceiver.ConnectionReceiverListener listener) {
        ConnectionReceiver.connectionReceiverListener = listener;
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        if(!isConnected) {
            createDialogView();
        }else{
            loadFragment();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        setConnectionListener(this);
    }
    private void checkConnection() {
        boolean isConnected = ConnectionReceiver.isConnected(this);
        if(!isConnected) {
            createDialogView();
        }else{
            loadFragment();
        }
    }
    public void createDialogView(){
        myDialog.setContentView(R.layout.no_internet_dialog);
        myDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        myDialog.setCancelable(false);
        myDialog.setCanceledOnTouchOutside(false);
        Button btnEnvoyer = myDialog.findViewById(R.id.btn_try_again);
        btnEnvoyer.setOnClickListener(view -> checkConnection());
        myDialog.show();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStackImmediate();
        } else {
            super.onBackPressed();
        }
    }
}