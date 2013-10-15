package com.alwaysallthetime.asyncgeocoder.response;

import android.location.Address;

import java.util.List;

public interface AsyncGeocoderResponseHandler {
    public void onSuccess(List<Address> addresses);
    public void onException(Exception exception);
}
