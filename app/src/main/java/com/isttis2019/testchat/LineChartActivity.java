package com.isttis2019.testchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Random;

public class LineChartActivity extends AppCompatActivity {

    LineChart lineChart;
    ArrayList<Entry> entries=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);



        lineChart=findViewById(R.id.linechart);

        Random rnd=new Random();
        for (int i=0; i<13; i++){
            entries.add(new Entry(i,rnd.nextInt(30)+30));
        }

        LineDataSet dataSet=new LineDataSet(entries, "label"); //여기서곡선 설정
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);

        dataSet.setCubicIntensity(0.2f);
        dataSet.setDrawCircleHole(false);
        dataSet.setDrawFilled(true);  //그래프 밑 색깔
        dataSet.setFillColor(0xFFFFFF00);  //알파값
        dataSet.setColor(0xFFFFFF00);

        LineData data=new LineData(dataSet);

        data.setDrawValues(true); //데이터 값 기본이 true

        lineChart.getDescription().setEnabled(false);
        lineChart.getLegend().setEnabled(false);
        lineChart.getAxisRight().setEnabled(false);

        YAxis yAxis = lineChart.getAxisLeft();
        yAxis.setDrawGridLines(false);
        yAxis.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularityEnabled(true);
        xAxis.setGranularity(1);
        xAxis.setDrawGridLines(false);



        lineChart.setData(data);





    }

    @Override
    public void onBackPressed() {
        finish();

    }
}
