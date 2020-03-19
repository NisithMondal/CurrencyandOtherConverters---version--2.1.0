package com.nisith.currencyandotherconverters;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class CurrencyHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_history);
        Toolbar appToolbar = findViewById(R.id.app_toolbar);
        TextView appToolbarTitle = findViewById(R.id.app_toolbar_title);
        RecyclerView historyRecyclerView = findViewById(R.id.history_recycler_view);
        setSupportActionBar(appToolbar);
        setTitle("");
        appToolbarTitle.setText("Convert History");
        appToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        appToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
