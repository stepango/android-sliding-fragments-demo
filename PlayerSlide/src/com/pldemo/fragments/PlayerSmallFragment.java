package com.pldemo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pldemo.R;

/**
 * Created by IntelliJ IDEA.
 * User: sone
 * Date: 22.12.12
 * Time: 16:46
 */
public class PlayerSmallFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_player, container, false);
    }
}
