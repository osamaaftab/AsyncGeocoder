package com.alwaysallthetime.asyncgeocoder.util;

import android.location.Address;

import java.util.List;

public class AddressUtility {
    public static String getAddressString(List<Address> addresses) {
        String locality = null;

        for(Address address : addresses) {
            String subLocality = address.getSubLocality();
            if(subLocality != null || locality == null) {
                locality = address.getLocality();
            }

            if(subLocality != null && locality != null) {
                return String.format("%s, %s", subLocality, locality);
            }
        }

        return locality;
    }
}
