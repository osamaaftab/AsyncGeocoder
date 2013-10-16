package com.alwaysallthetime.asyncgeocoder.request;

import android.location.Address;
import android.location.Geocoder;

import com.alwaysallthetime.asyncgeocoder.response.AsyncGeocoderResponseHandler;

import java.io.IOException;
import java.util.List;

public abstract class AsyncGeocoderRequest {
    private final AsyncGeocoderResponseHandler mResponseHandler;
    protected final Geocoder mGeocoder;

    protected AsyncGeocoderRequest(Geocoder geocoder, AsyncGeocoderResponseHandler responseHandler) {
        mGeocoder = geocoder;
        mResponseHandler = responseHandler;
    }

    public AsyncGeocoderResponseHandler getResponseHandler() {
        return mResponseHandler;
    }

    public abstract List<Address> geocode() throws IOException;
}
