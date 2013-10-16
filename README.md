AsyncGeocoder
=============

A simple library that runs [Android Geocoder](http://developer.android.com/reference/android/location/Geocoder.html "Geocoder") tasks asynchronously.

As Google's documentation suggests, Geocoder methods may require network calls and will block until results are returned. For this reason, it's nice to have Geocoder methods execute asynchronously, in separate threads. This is what this library aims to accomplish. 

Usage
-----
There are two main types of requests that correspond to the Geocoder methods: ``FromLocationRequest`` and ``FromLocationNameRequest``.

To use either of these requests, simply get the ``AsyncGeocoder`` instance and call the proper method on it.

```java
AsyncGeocoder.getInstance(context).getFromLocation(lat, lon, 5, new AsyncGeocoderResponseHandler() {
    @Override
    public void onSuccess(final List<Address> addresses) {
        //got me some Addresses!
    }

    @Override
    public void onException(Exception exception) {
        Log.d(TAG, exception.getMessage(), exception);
        //whoops
    }
});
```
It's important to note that just as when using the ``Geocoder`` class directly, you should always check ``Geocoder.isPresent()`` before attempting to use these methods.
