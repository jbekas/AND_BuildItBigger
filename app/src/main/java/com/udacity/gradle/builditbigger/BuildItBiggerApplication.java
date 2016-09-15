package com.udacity.gradle.builditbigger;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by jbekas on 9/14/16.
 */

public class BuildItBiggerApplication  extends Application {

    @Override
    public void onCreate() {

        super.onCreate();

        Timber.plant(new Timber.DebugTree());
    }
}

