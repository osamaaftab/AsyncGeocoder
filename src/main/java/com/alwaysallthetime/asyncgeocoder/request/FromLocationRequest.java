package com.alwaysallthetime.asyncgeocoder.request;

import android.location.Address;
import android.location.Geocoder;

import com.alwaysallthetime.asyncgeocoder.response.AsyncGeocoderResponseHandler;

import java.io.IOException;
import java.util.List;

public class FromLocationRequest extends AsyncGeocoderRequest {

    private double mLatitude;
    private double mLongitude;

    public FromLocationRequest(double latitude, double longitude, int maxResults, Geocoder geocoder, AsyncGeocoderResponseHandler responseHandler) {
        super(maxResults, geocoder, responseHandler);

        mLatitude = latitude;
        mLongitude = longitude;
    }

    @Override
    public List<Address> geocode(Geocoder geocoder, int maxResults) throws IOException {
        return geocoder.getFromLocation(mLatitude, mLongitude, maxResults);
    }
}
