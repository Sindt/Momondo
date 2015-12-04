'use strict';
var app = angular.module('myApp.view5', ['ngRoute']);

app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/view5', {
            templateUrl: 'app/view5/view5.html'
        });
    }]);

app.controller("View5Ctrl", ["$http", "$scope", function ($http, $scope, InfoFactory) {

        $scope.getAllFlightinfo = function () {
            var self = this;
            $http({
                method: "GET",
                url: "api/link"
            }).then(function succesCallback(response) {
                self.data = response.data;
            }).then(function errorCallback(response) {
                self.error = "Error";
            });
        };
        $scope.getAllFlightinfo();

        //TEST CODE
        alert(InfoFactory.getFlightId());
        InfoFactory.setFlightId("MH370");
        alert(InfoFactory.getFlightId());


        $scope.sendFlightData = function (InfoFactory) {
            InfoFactory.setFlightId("MH700");
            alert(InfoFactory.getFlightId());
        };
    }]);

app.factory('InfoFactory', function () {

    var flightId = "MH117";
    var IF = {};

    IF.setFlightId = function (nextFlightId) {
        flightId = nextFlightId;
    };
    IF.getFlightId = function () {
        return flightId;
    };
    return IF;

});