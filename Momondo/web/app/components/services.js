'use strict';

/* Place your Global Services in this File */

// Demonstrate how to register services
angular.module('myApp.services', [])
  .service('flightService', function() {
  var flightInfoList = [];

  var addFlightInfo = function(flightInfo) {
      flightInfoList.push(flightInfo);
  };

  var getFlightInfo = function(){
      return flightInfoList;
  };

  return {
    addFlightInfo: addFlightInfo,
    getFlightInfo: getFlightInfo
  };

});