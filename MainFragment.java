package com.example.nagi.lab4;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        GridLayout gridLayout = getActivity().findViewById(R.id.grid_movies);
        for(int i = 0; i < gridLayout.getChildCount();i++){

            final ImageButton imgbutton = (ImageButton) gridLayout.getChildAt(i);

            imgbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String imgTag = v.getTag().toString();
                    if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                        Intent intent = new Intent(getActivity(),DetailsActivity.class);
                        intent.putExtra("movie_name",imgTag);
                        startActivity(intent);
                    }else {
                        int text_id = getResources().getIdentifier(imgTag,"raw",getActivity().getPackageName());
                        int img_id = getResources().getIdentifier(imgTag,"drawable",getActivity().getPackageName());
                        DetailFragment df = (DetailFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.frag_detail);
                        df.setDetails(img_id,text_id);
                    }

                }
            });
        }
    }
}

