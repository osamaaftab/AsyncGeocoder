package com.alwaysallthetime.asyncgeocoder.request;

import android.location.Address;
import android.location.Geocoder;

import com.alwaysallthetime.asyncgeocoder.response.AsyncGeocoderResponseHandler;

import java.io.IOException;
import java.util.List;

public class FromLocationNameRequest extends AsyncGeocoderRequest {

    private String mLocationName;
    private double mLowerLeftLatitude;
    private double mLowerLeftLongitude;
    private double mUpperRightLatitude;
    private double mUpperRightLongitude;

    public FromLocationNameRequest(String locationName, int maxResults, Geocoder geocoder, AsyncGeocoderResponseHandler responseHandler) {
        super(maxResults, geocoder, responseHandler);
        mLocationName = locationName;
    }

    public FromLocationNameRequest(String locationName, double lowerLeftLatitude, double lowerLeftLongitude, double upperRightLatitude, double upperRightLongitude, int maxResults, Geocoder geocoder, AsyncGeocoderResponseHandler responseHandler) {
        super(maxResults, geocoder, responseHandler);

        mLowerLeftLatitude = lowerLeftLatitude;
        mLowerLeftLongitude = lowerLeftLongitude;
        mUpperRightLatitude = upperRightLatitude;
        mUpperRightLongitude = upperRightLongitude;
    }

    @Override
    public List<Address> geocode() throws IOException {
        if(mLowerLeftLatitude != 0 || mLowerLeftLongitude != 0 || mUpperRightLongitude != 0 || mUpperRightLatitude != 0) {
            return mGeocoder.getFromLocationName(mLocationName, mMaxResults, mLowerLeftLatitude, mLowerLeftLongitude, mUpperRightLatitude, mUpperRightLongitude);
        } else {
            return mGeocoder.getFromLocationName(mLocationName, mMaxResults);
        }
    }
}
