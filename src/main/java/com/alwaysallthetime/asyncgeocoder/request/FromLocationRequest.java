package com.alwaysallthetime.asyncgeocoder.request;

import android.location.Address;
import android.location.Geocoder;

import com.alwaysallthetime.asyncgeocoder.response.AsyncGeocoderResponseHandler;

import java.io.IOException;
import java.util.List;

public class FromLocationRequest extends AsyncGeocoderRequest {
    private static final String TAG = "FromLocationRequest";

    private double mLatitude;
    private double mLongitude;

    public FromLocationRequest(double latitude, double longitude, int maxResults, Geocoder geocoder, AsyncGeocoderResponseHandler responseHandler) {
        super(maxResults, geocoder, responseHandler);

        mLatitude = latitude;
        mLongitude = longitude;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public int getMaxResults() {
        return mMaxResults;
    }

    @Override
    public List<Address> geocode() throws IOException {
        return mGeocoder.getFromLocation(mLatitude, mLongitude, mMaxResults);
    }
}
