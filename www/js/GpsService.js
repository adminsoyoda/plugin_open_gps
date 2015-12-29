var GpsService = {
    on: function(successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'GpsService',
            'on', 
            [{                  

            }]
        ); 
     },
     off: function(successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'GpsService',
            'off', 
            [{                  

            }]
        ); 
     }
}
