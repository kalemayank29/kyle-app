package com.example.kylehirschfelder.navegationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by kylehirschfelder on 6/22/15.
 */
public class Third_Fragment extends Fragment {
    View myView;
    Button medButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.third_layout, container,false);
        medButton = (Button) myView.findViewById(R.id.medButton);

        medButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getActivity(), medicine_inventory.class);
                startActivity(intent);
            }
        });

        return myView;
    }
}
