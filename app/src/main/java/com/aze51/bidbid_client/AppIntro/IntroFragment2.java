package com.aze51.bidbid_client.AppIntro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.aze51.bidbid_client.ApplicationController;
import com.aze51.bidbid_client.R;

/**
 * Created by Leekh on 2016-07-07.
 */
public class IntroFragment2 extends Fragment {
    CheckBox tutorialCheckBox;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.app_intro_2, container, false);

        return view;
    }
}
