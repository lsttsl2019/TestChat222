package com.isttis2019.testchat;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.Random;

public class TestActivity extends AppCompatActivity {

    BarChart barChart;

    ArrayList<BarEntry> entries=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        barChart=findViewById(R.id.bar_chart);

        Random rnd= new Random();
        for(int i=0; i<13 ; i++){
            entries.add(new BarEntry(i, rnd.nextInt(30)+70));
        }

        BarDataSet dataSet=new BarDataSet(entries , "label");


        BarData data=new BarData(dataSet);

        data.setDrawValues(true);
        data.setValueTextSize(0);


        barChart.setData(data);
        barChart.setDrawValueAboveBar(true);
        barChart.setHighlightFullBarEnabled(true);
        barChart.getDescription().setEnabled(false);
        barChart.getLegend().setEnabled(false);
        barChart.getAxisRight().setEnabled(false);


            barChart.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    switch (event.getAction()){

                        //바에 리스너
                        case MotionEvent.ACTION_DOWN:
                            AlertDialog.Builder builder=new AlertDialog.Builder(TestActivity.this);
                            builder.setMessage("Hello").create().show();

                            break;
                    }
                    return true;
                }
            });



        XAxis xAxis=barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        xAxis.setGranularity(1);




    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
