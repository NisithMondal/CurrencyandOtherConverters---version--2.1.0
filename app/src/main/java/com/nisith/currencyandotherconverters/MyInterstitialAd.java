package com.nisith.currencyandotherconverters;



import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MyInterstitialAd {

    private InterstitialAd mInterstitialAd;
    private int clickedConverterId;
    private OnInterstitialAdCloseListener onInterstitialAdCloseListener;

    public interface OnInterstitialAdCloseListener{
        void onInterstitialAdClose(int clickedConverterId);
    }

    public MyInterstitialAd(CurrencyActivity currencyActivity) {
        this.onInterstitialAdCloseListener = currencyActivity;
        preparedInterstitialAd(currencyActivity);
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                if (mInterstitialAd != null) {
                    /*When ad is closed ,then onInterstitialAdClose() method is called by passing clicking converter Id.
                      Currency Converter activity class override this method. */
                        onInterstitialAdCloseListener.onInterstitialAdClose(clickedConverterId);
                        //Load Interstitial Ad
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());

                }
            }
        });

    }

    private void preparedInterstitialAd(CurrencyActivity currencyActivity){
        mInterstitialAd = new InterstitialAd(currencyActivity);
        mInterstitialAd.setAdUnitId(currencyActivity.getResources().getString(R.string.app_interstitial_ad));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public void showInterstitialAd(int clickedConverterId){

        if (mInterstitialAd != null) {
            if (mInterstitialAd.isLoaded()) {
                //if ad is Loaded then show the Ads
                mInterstitialAd.show();
                this.clickedConverterId = clickedConverterId;
            }
        }
    }

    public void loadInterstitialAd(){
        //Load Interstitial Ad
        if (mInterstitialAd != null) {
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
        }
    }

    public boolean isAdLoaded(){
        boolean isLoaded = false;
        if (mInterstitialAd != null) {
            isLoaded = mInterstitialAd.isLoaded();
        }
        return isLoaded;
    }


}
