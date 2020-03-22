package com.nisith.currencyandotherconverters;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import androidx.appcompat.app.AppCompatActivity;

public class MyInterstitialAd {

    private boolean isStopThread = false;
    private InterstitialAd mInterstitialAd;
    private AppCompatActivity appCompatActivity;

    public MyInterstitialAd(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
        preparedInterstitialAd(appCompatActivity);
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                if (mInterstitialAd != null) {
                    if (! mInterstitialAd.isLoaded()) {
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    }
                }
            }
        });

    }

    private void preparedInterstitialAd(Context context){
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public void showInterstitialAd(final long adDelay){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (! isStopThread) {
                    appCompatActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (mInterstitialAd != null) {
                                if (mInterstitialAd.isLoaded()) {
                                    //if ad is Loaded then show the Ads
                                    mInterstitialAd.show();
                                } else {
                                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                                }
                            }
                        }
                    });
                    SystemClock.sleep(adDelay);
                }
            }
        }).start();


    }


    public void stopThread(){
        //This method is used to stop the Thread
        isStopThread = true;
    }

}
