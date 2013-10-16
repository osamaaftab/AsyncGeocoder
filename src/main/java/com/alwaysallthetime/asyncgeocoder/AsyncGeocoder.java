package com.alwaysallthetime.asyncgeocoder;

import android.content.Context;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Build;

import com.alwaysallthetime.asyncgeocoder.request.AsyncGeocoderRequest;
import com.alwaysallthetime.asyncgeocoder.request.FromLocationRequest;
import com.alwaysallthetime.asyncgeocoder.response.AsyncGeocoderResponseHandler;

import java.util.Locale;

public class AsyncGeocoder {
    private static final String TAG = "AsyncGeocoder";

    private static AsyncGeocoder mInstance;

    public static AsyncGeocoder getInstance(Context context) {
        if(mInstance == null) {
            mInstance = new AsyncGeocoder(context);
        }
        return mInstance;
    }

    private Geocoder mGeocoder;

    private AsyncGeocoder(Context context) {
        mGeocoder = new Geocoder(context, Locale.getDefault());
    }

    public void getFromLocation(double latitude, double longitude, int maxResults, AsyncGeocoderResponseHandler responseHandler) {
        execute(new FromLocationRequest(latitude, longitude, maxResults, mGeocoder, responseHandler));
    }

    private void execute(AsyncGeocoderRequest request) {
        AsyncGeocoderTask task = new AsyncGeocoderTask();
        // AsyncTask was changed in Honeycomb to execute in serial by default, at which time
        // executeOnExecutor was added to specify parallel execution.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, request);
        } else {
            task.execute(request);
        }
    }
}
