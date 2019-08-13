package com.example.datapassingfromfragmentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnCountChangeListener {

    private TextView mTvCounter;

    private SecondFragment mSecondFragment;

    private static final String TAG = "CountChangeListener";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvCounter = findViewById(R.id.tv_counter);



      mSecondFragment = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_two);
       mSecondFragment = new SecondFragment();
    }

    @Override
    public void onCountChange(int count) {
        Log.d(TAG, "onCountChange: " + count);
        mTvCounter.setText(String.valueOf(count));
        mSecondFragment.setCounterToView(count);

    }

}
