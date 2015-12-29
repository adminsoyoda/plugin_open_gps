package org.apache.cordova.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import android.os.Bundle;
import android.location.LocationManager;
import android.provider.Settings;
import android.content.Intent;
import android.net.Uri;


import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.content.Context;

public class GpsService extends CordovaPlugin implements LocationListener  {

    private LocationManager handle=null;
    @Override
    public boolean execute(String action, final JSONArray args, CallbackContext callbackContext) {
        PluginResult result = new PluginResult(Status.OK);
        if ("on".equals(action)){
             switchOn();
        }else if ("off".equals(action)){
             switchOff();
        } else{
            result = new PluginResult(Status.INVALID_ACTION);
        callbackContext.sendPluginResult(result);
      
      }
      return true;
    }

    public void switchOn(){
     /* if (handle==null){
            handle = (LocationManager) cordova.getActivity().getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        }
        boolean isGPSEnabled = handle.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!isGPSEnabled){
          android.content.ContentResolver contentResolver = cordova.getActivity().getApplicationContext().getContentResolver();
          Intent intent = new Intent("android.location.GPS_ENABLED_CHANGE");
		  intent.putExtra("enabled", true);
		  cordova.getActivity().getApplicationContext().sendBroadcast(intent);
		}*/
	final Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
	startActivity(intent);
    }

    public void switchOff(){
/*       if (handle==null){
            handle = (LocationManager) cordova.getActivity().getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        }
        boolean isGPSEnabled = handle.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (isGPSEnabled){
          android.content.ContentResolver contentResolver = cordova.getActivity().getApplicationContext().getContentResolver();
          Settings.Secure.setLocationProviderEnabled(contentResolver, LocationManager.GPS_PROVIDER, false);
        }*/
    }

     @Override
     public void onLocationChanged(Location location) {
     }
 
    @Override
     public void onProviderDisabled(String provider) {
     }
     
    @Override
     public void onProviderEnabled(String provider) {
     }
     
    @Override
     public void onStatusChanged(String provider, int status, Bundle extras) {
     }

}
