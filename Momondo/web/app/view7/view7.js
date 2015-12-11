'use strict';
angular.module('myApp.view7', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view7', {
                    templateUrl: 'app/view7/view7.html'
                });

            }])
        .controller("View7Ctrl", ["$scope", "dataFactory", function ($scope, dataFactory) {
                
                
                
                
        }]);