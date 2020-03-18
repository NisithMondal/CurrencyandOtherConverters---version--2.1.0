package com.nisith.currencyandotherconverters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AllCurrencyNameActivity extends AppCompatActivity implements AllcurrencyRecyclerViewAdapter.OnCardViewClickListener {

    private int clickedCurrencyLayoutId;
    private ArrayList<CountryAndCurrency> allCountryAndCurrenciesArrayList;
    private AllcurrencyRecyclerViewAdapter allcurrencyRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_currency_name);
        Toolbar appToolbar = findViewById(R.id.app_toolbar);
        TextView toolbarTitle = appToolbar.findViewById(R.id.app_toolbar_title);
        RecyclerView allCurrencyRecyclerView = findViewById(R.id.recycler_view);
        setSupportActionBar(appToolbar);
        setTitle("");
        toolbarTitle.setText("All Currencies");
        appToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        appToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_bar_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.search_bar);
        final SearchView searchView = (android.support.v7.widget.SearchView)menuItem.getActionView();
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
        finish();
    }

    private ArrayList<CountryAndCurrency> setCountryAndCurrenciesArrayList(String []allCountriesName,String []allCurrenciesName){
        ArrayList<CountryAndCurrency> mallCountryAndCurrenciesArrayList = new ArrayList<>();
        for (int i = 0; i < allCountriesName.length; i++) {
            mallCountryAndCurrenciesArrayList.add(new CountryAndCurrency(allCountriesName[i],allCurrenciesName[i]));
        }
        return mallCountryAndCurrenciesArrayList;
    }
}
