package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.redgeckotech.myapplication.backend.myApi.MyApi;
import com.redgeckotech.mylibrary.ShowJokeActivity;

import java.io.IOException;

/**
 * Created by jbekas on 9/14/16.
 */

class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... contexts) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbetter-143501.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        this.context = contexts[0];

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(context, ShowJokeActivity.class);
        intent.putExtra(ShowJokeActivity.EXTRA_JOKE, result);
        context.startActivity(intent);
    }
}
