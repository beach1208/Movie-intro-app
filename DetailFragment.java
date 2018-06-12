package com.example.nagi.lab4;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {




    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }



    public void setDetails(int img_id, int text_id){
        ImageView imageView = getActivity().findViewById(R.id.detailImage);
        imageView.setImageResource(img_id);

        // 2. textView
        TextView textView = getActivity().findViewById(R.id.detailText);
        Scanner scan = new Scanner(getResources().openRawResource(text_id));
        String allText = "";
        while (scan.hasNextLine()){
            allText += scan.nextLine();
        }
        scan.close();


        textView.setText(allText);
    }





}
