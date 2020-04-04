package com.nisith.currencyandotherconverters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class AboutAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        Toolbar appToolbar = findViewById(R.id.app_toolbar);
        TextView appToolbarTitle = findViewById(R.id.app_toolbar_title);
        ImageView audioSoundIcon = findViewById(R.id.audio_enable_image_view);
        setSupportActionBar(appToolbar);
        setTitle("");
        appToolbarTitle.setText("About This App");
        audioSoundIcon.setVisibility(View.GONE);
        appToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        appToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        clickableTextForPlayStoreAppRating();

        //show Banner Ads
        showSmallBannerAd();

    }




    private void showSmallBannerAd(){
        //For showing Small Banner Ads
        //For AdMob Ads
        //For Banner Ads
        AdView smallTopBannedAdView = findViewById(R.id.small_top_banner_ad);
        AdView smallMiddleBannerAdView1 = findViewById(R.id.small_middle_banner_ad1);
        smallTopBannedAdView.loadAd(new AdRequest.Builder().build());
        smallMiddleBannerAdView1.loadAd(new AdRequest.Builder().build());
    }


    private void clickableTextForPlayStoreAppRating(){
        //To create a short clickable text of a large text
        //This method create a clickable text.When you click that clickable text, then this link open google play store app to gige rating this application
        TextView clickableRankTextView = findViewById(R.id.rank_text_view);
        String text = "Click here to Give Rating This Application";
        SpannableString spannableString = new SpannableString(text);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                giveRatingThisApplication();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
            }
        };
        spannableString.setSpan(clickableSpan,0,text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        clickableRankTextView.setText(spannableString);
        clickableRankTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }



    private void giveRatingThisApplication(){
        //This Method open Google Play Store to give rating this Application
        try{
            //If play store app is installed in that device, then do the following
            Intent playStoreIntent = new Intent();
            playStoreIntent.setAction(Intent.ACTION_VIEW);
            playStoreIntent.setData(Uri.parse("market://details?id="+getPackageName()));
            startActivity(playStoreIntent);
        }catch (ActivityNotFoundException e){
            //If play store app is not installed in that device, then the following code open play store app in web browser.
            Intent playStoreIntent1 = new Intent();
            playStoreIntent1.setAction(Intent.ACTION_VIEW);
            playStoreIntent1.setData(Uri.parse("http://play.google.com/store/apps/details?id="+getPackageName()));
            startActivity(playStoreIntent1);
        }

    }






}
