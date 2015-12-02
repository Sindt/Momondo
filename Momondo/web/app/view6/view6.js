'use strict';

angular.module('myApp.view6', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view6', {
                    templateUrl: 'app/view6/view6.html'
                });

            }])
        .controller("View6Controller", ['$scope', '$http', function ($scope, $http) {

                $scope.addRegistrationAsJSON = function () {
                  
                    var res = $http.post('api/flightreservation', $scope.registration);
                    res.success(function (data, status, headers, config) {
                        $scope.message = data;
                        alert("Flight registered. Have a nice trip.");
                        
                        
                        
                        
//                        $scope..username = '';
//                        $scope.newuser.password = '';
                    });
                    res.error(function (data, status, headers, config) {
                        alert("failure message: " + JSON.stringify({data: data}));
                    });
                };
            }]);
