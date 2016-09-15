package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;

import org.mockito.Mock;

import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends AndroidTestCase {

    EndpointsAsyncTask task;
    String result;
    @Mock Context mockContext;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        task = new EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String joke){
                // Override the intent to show ShowJokeActivity.
            }
        };
    }
    public void testAsyncReturnType() {

        try {
            task.execute(mockContext);
            result = task.get(10, TimeUnit.SECONDS);
            System.out.println("My result: " + result);
            assertNotNull(result);

        } catch (Exception e) {
            fail("Bad things happened.");
        }
    }
}