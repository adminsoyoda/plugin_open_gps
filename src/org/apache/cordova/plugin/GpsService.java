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

public class GpsService extends CordovaPlugin{

    @Override
    public boolean execute(String action, final JSONArray args, CallbackContext callbackContext) {
        PluginResult result = new PluginResult(Status.OK);
        boolean value=false;
        if ("on".equals(action)){
             value=switchOn();
        }else if ("off".equals(action)){
             value=switchOff();
        }else if ("provider_enabled".equals(action)){
             value=isProviderEnabled();
        }else{
            result = new PluginResult(Status.INVALID_ACTION);
			      callbackContext.sendPluginResult(result);
        }
        callbackContext.success(value);
        return value;
    }

    public boolean switchOn(){
  		final Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
  		cordova.getActivity().startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
      return true;
    }

    public boolean switchOff(){
      return true;
    }
    
    public boolean isProviderEnabled(){
      LocationManager handle=(LocationManager) cordova.getActivity().getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
	    boolean isGPSEnabled = handle.isProviderEnabled(LocationManager.GPS_PROVIDER);	
	    return isGPSEnabled;
	  }

}
