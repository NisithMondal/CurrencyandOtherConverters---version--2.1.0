package com.nisith.currencyandotherconverters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Toolbar appToolbar = findViewById(R.id.app_toolbar);
        TextView appToolbarTitle = findViewById(R.id.app_toolbar_title);
        ImageView audioSoundIcon = findViewById(R.id.audio_enable_image_view);
        setSupportActionBar(appToolbar);
        setTitle("");
        appToolbarTitle.setText("Help");
        audioSoundIcon.setVisibility(View.GONE);
        appToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        appToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




        //show Banner Ads
        showSmallBannerAd();




    }

    private void showSmallBannerAd(){
        //For showing Small Banner Ads
        //For AdMob Ads
        //For Banner Ads
        AdView smallTopBannedAdView = findViewById(R.id.small_top_banner_ad);
        AdView smallMiddleBannerAdView = findViewById(R.id.large_middle_banner_ad);
        smallTopBannedAdView.loadAd(new AdRequest.Builder().build());
        smallMiddleBannerAdView.loadAd(new AdRequest.Builder().build());
    }

}
