package com.example.a1.Analyzing;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a1.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class AnalyzingActivity extends AppCompatActivity {

    BarChart barChart;

    // variable for our bar data set.
    BarDataSet barDataSet1, barDataSet2;

    // array list for storing entries.
    ArrayList barEntries;

    // creating a string array for displaying days.
    String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Thursday", "Friday", "Saturday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyzing);
        barChart = findViewById(R.id.barchart);
        barDataSet1 = new BarDataSet(getBarEntriesOne(), "First Set");
        barDataSet1.setColor(getResources().getColor(R.color.individual_bar1));
        barDataSet2 = new BarDataSet(getBarEntriesTwo(), "Second Set");
        barDataSet2.setColor(getResources().getColor(R.color.individual_bar2));
        BarData data = new BarData(barDataSet1, barDataSet2);
        barChart.setData(data);
        barChart.getDescription().setEnabled(false);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMaximum(6);
        float barSpace = 0.1f;
        float groupSpace = 0.5f;
        data.setBarWidth(0.15f);
        barChart.getXAxis().setAxisMinimum(0);
        barChart.animate();
        xAxis.setDrawGridLines(false);
        barChart.groupBars(0, groupSpace, barSpace);
        barChart.invalidate();
    }
    private ArrayList<BarEntry> getBarEntriesOne() {
        barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(1f, 4));
        barEntries.add(new BarEntry(2f, 6));
        barEntries.add(new BarEntry(3f, 8));
        barEntries.add(new BarEntry(4f, 2));
        barEntries.add(new BarEntry(5f, 4));
        barEntries.add(new BarEntry(6f, 1));
        return barEntries;
    }

    // array list for second set.
    private ArrayList<BarEntry> getBarEntriesTwo() {
        barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(1f, 8));
        barEntries.add(new BarEntry(2f, 12));
        barEntries.add(new BarEntry(3f, 4));
        barEntries.add(new BarEntry(4f, 1));
        barEntries.add(new BarEntry(5f, 7));
        barEntries.add(new BarEntry(6f, 3));
        return barEntries;
    }
}