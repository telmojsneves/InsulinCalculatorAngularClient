'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives', 'ngRoute']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {

    $routeProvider.when('/midp', {
        templateUrl: 'api/v1/midp/layout',
        controller: MidpController
    });

    $routeProvider.when('/bid', {
        templateUrl: 'api/v1/bid/layout',
        controller: BidController
    });


    $routeProvider.when('/mids', {
        templateUrl: 'api/v1/mids/layout',
        controller: MidsController
    });

    $routeProvider.otherwise({redirectTo: '/midp'});
}]);
