package com.alwaysallthetime.asyncgeocoder;

import android.location.Address;
import android.os.AsyncTask;
import android.util.Log;

import com.alwaysallthetime.asyncgeocoder.data.AsyncGeocoderRequest;
import com.alwaysallthetime.asyncgeocoder.response.AsyncGeocoderResponseHandler;

import java.io.IOException;
import java.util.List;

public class AsyncGeocoderTask extends AsyncTask<AsyncGeocoderRequest, Void, Void> {

    private static final String TAG = "AsyncGeocoderTask";

    @Override
    protected Void doInBackground(AsyncGeocoderRequest... requests) {
        for(AsyncGeocoderRequest request : requests) {
            AsyncGeocoderResponseHandler responseHandler = request.getResponseHandler();
            try {
                List<Address> addresses = request.geocode();
                responseHandler.onSuccess(addresses);
            } catch(IOException e) {
                Log.d(TAG, e.getMessage(), e);
                responseHandler.onException(e);
            }
        }
        return null;
    }
}
