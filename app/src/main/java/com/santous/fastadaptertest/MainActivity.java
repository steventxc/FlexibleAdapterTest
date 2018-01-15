package com.santous.fastadaptertest;

import android.os.Bundle;

import com.santous.fastadaptertest.flexible.FlexibleFragment;

import me.yokeyword.fragmentation.SupportActivity;

public class MainActivity extends SupportActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadRootFragment(R.id.container, FlexibleFragment.newInstance());
    }
}
