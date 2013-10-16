AsyncGeocoder
=============

A simple library that runs [Android Geocoder](http://developer.android.com/reference/android/location/Geocoder.html "Geocoder") tasks asynchronously.

As Google's documentation suggests, Geocoder methods may require network calls and will block until results are returned. For this reason, it's nice to have Geocoder methods execute asynchronously, in separate threads. This is what this library aims to accomplish. 

Getting Started
---------------
AsyncGeocoder contains Android Studio project files (namely, AsyncGeocoder.iml and build.gradle). So, if you're using this code in an existing Android Studio project, you may be able to get by by adding it as a submodule at the root of your project and importing it as a module. After doing so, make sure you do the following:

* Add ``include ':AsyncGeocoder'`` to your top-level settings.gradle, 
* Add ``compile project(':AsyncGeocoder')`` to your ``dependencies`` block in build.gradle.
* Add a module dependency for AsyncGeocoder to your project in the Project Structure dialog.

Android Studio is still young and these steps may change (or be automated by the tooling).

If you're not using Android Studio, feel free to use this code however you'd like.

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

License
-------
MIT. See LICENSE.md file.
