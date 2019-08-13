package com.example.datapassingfromfragmentdemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FirstFragment extends Fragment {

    public interface OnCountChangeListener {
        void onCountChange(int count);
    }

    private int mCounter = 0;
    private OnCountChangeListener mListener;

    private static final String TAG = "CountChangeListener";


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        mListener = (OnCountChangeListener) getActivity();

        Button btnIncrement = view.findViewById(R.id.btn_increment);
        Button btnDecrement = view.findViewById(R.id.btn_decrement);
        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter += 1;
                mListener.onCountChange(mCounter);
            }
        });
        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter  -= 1;
                mListener.onCountChange(mCounter);
            }
        });
        return view;
    }

   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }*/
}
