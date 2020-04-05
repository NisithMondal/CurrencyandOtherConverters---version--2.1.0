package com.nisithmondaltechnology.unitnumberandcurrencyallconverter;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class AllCurrencyNameActivity extends AppCompatActivity implements AllcurrencyRecyclerViewAdapter.OnCardViewClickListener {

    private int clickedCurrencyLayoutId;
    private ArrayList<CountryAndCurrency> allCountryAndCurrenciesArrayList;
    private AllcurrencyRecyclerViewAdapter allcurrencyRecyclerViewAdapter;
    private TextSpeaker textSpeaker;
    private SoundStateSharedPreference soundStateSharedPreference;
    private ToolbarSoundIconHandaler toolbarSoundIconHandaler;
    private ImageView toolbarSoundIconImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_currency_name);
        Toolbar appToolbar = findViewById(R.id.app_toolbar);
        TextView toolbarTitle = appToolbar.findViewById(R.id.app_toolbar_title);
        toolbarSoundIconImageView = appToolbar.findViewById(R.id.audio_enable_image_view);
        RecyclerView allCurrencyRecyclerView = findViewById(R.id.recycler_view);
        setSupportActionBar(appToolbar);
        setTitle("");
        toolbarTitle.setText("All Currencies");
        appToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        appToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyBoard();
                finish();
            }
        });
        allCurrencyRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        allCurrencyRecyclerView.setHasFixedSize(true);
        String []allCountriesName = getResources().getStringArray(R.array.countries_name);
        String []allCurrenciesName = getResources().getStringArray(R.array.all_currencies);
        allCountryAndCurrenciesArrayList = setCountryAndCurrenciesArrayList(allCountriesName,allCurrenciesName);
        allcurrencyRecyclerViewAdapter =new AllcurrencyRecyclerViewAdapter(allCountryAndCurrenciesArrayList,this);
        allCurrencyRecyclerView.setAdapter(allcurrencyRecyclerViewAdapter);
        Intent requestIntent = getIntent();//this intent object came from CurrencyActivity
        clickedCurrencyLayoutId = requestIntent.getIntExtra("clicked_currency_layout_id",-1);
        textSpeaker = new TextSpeaker(getApplicationContext());
        soundStateSharedPreference = new SoundStateSharedPreference(this);
        toolbarSoundIconHandaler = new ToolbarSoundIconHandaler(this,textSpeaker);
        toolbarSoundIconHandaler.setToolbarSoundIconState(toolbarSoundIconImageView);//set toolbar sound icon state(voume off or volume on) at the begining of this activity
        toolbarSoundIconImageView.setOnClickListener(toolbarSoundIconHandaler);
        //To show Banner Ad
        showSmallBannerAd();


    }

    private void closeKeyBoard(){
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }


    private void showSmallBannerAd(){
        //For showing Small Banner Ads
        //For AdMob Ads
        //For Banner Ads
        AdView smallBannedAdView = findViewById(R.id.small_banner_ad);
        smallBannedAdView.loadAd(new AdRequest.Builder().build());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_bar_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.search_bar);
        final SearchView searchView = (androidx.appcompat.widget.SearchView)menuItem.getActionView();
        searchView.setQueryHint("Enter Country name");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Filter filter = allcurrencyRecyclerViewAdapter.getFilter();
                filter.filter(searchView.getQuery());
                /*This Method will tells the last enter Character in search View or Edit text. But it will not speak anything when character is removed from
                  edit text Field */
                String soundState = soundStateSharedPreference.getSoundState();
                if(soundState.equalsIgnoreCase(getString(R.string.enable))) {
                    //The soundState saved in sharedPreference  if enabled then only text to speech converTion is performed
                    textSpeaker.speakLastCharacterOfSearchView(String.valueOf(s));
                }
                return true;
            }
        });
        return true;
    }





    @Override
    public void onCardViewClick(int position) {
        Intent resultIntent = new Intent();
        String selectedCurrencyName = allCountryAndCurrenciesArrayList.get(position).getCurrencyName();
        resultIntent.putExtra("currency_name",selectedCurrencyName);
        resultIntent.putExtra("clicked_currency_layout_id",clickedCurrencyLayoutId);
        setResult(RESULT_OK,resultIntent);
        closeKeyBoard();
        finish();
    }

    private ArrayList<CountryAndCurrency> setCountryAndCurrenciesArrayList(String []allCountriesName,String []allCurrenciesName){
        ArrayList<CountryAndCurrency> mallCountryAndCurrenciesArrayList = new ArrayList<>();
        for (int i = 0; i < allCountriesName.length; i++) {
            mallCountryAndCurrenciesArrayList.add(new CountryAndCurrency(allCountriesName[i],allCurrenciesName[i]));
        }
        return mallCountryAndCurrenciesArrayList;
    }


    @Override
    protected void onDestroy() {
        if (textSpeaker != null) {
            //this will release memory of textSpeaker object from Ram. This is Important
            textSpeaker.closeTextSpeaker();
        }
        super.onDestroy();

    }

}
