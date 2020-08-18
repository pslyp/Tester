package com.example.tester.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tester.BarChartActivity;
import com.example.tester.BarChartActivityMultiDataset;
import com.example.tester.R;

public class GraphActivity extends AppCompatActivity implements View.OnClickListener {

    private Button barChartButton, barChartMultiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        initInstance();
    }

    private void initInstance() {
        barChartButton = findViewById(R.id.bar_chart_button);
        barChartButton.setOnClickListener(this);
        barChartMultiButton = findViewById(R.id.bar_chart_multi_button);
        barChartMultiButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bar_chart_button :
                startActivity(new Intent(GraphActivity.this, BarChartActivity.class));
                break;
            case R.id.bar_chart_multi_button :
                startActivity(new Intent(GraphActivity.this, BarChartActivityMultiDataset.class));
                break;
        }
    }
}
