'use strict';
angular.module('myApp.view5', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view5', {
                    templateUrl: 'app/view5/view5.html'
                });
            }])
        .controller("View5Ctrl", ["$http", "$scope", function ($http, $scope) {
                var self = this;
                $scope.getAllFlightinfo = function () {
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
     }]);
//                $scope.deleteUser = function (users) {
//                    $http({
//                        method: "DELETE",
//                        url: "api/admin/user/" + users.id
//                    }).then(function succesCallback(response) {
//                        $scope.getUsers();
//
//                    });
//
//
//                };
       