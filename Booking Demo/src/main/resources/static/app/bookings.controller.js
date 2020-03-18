/**
 * Created by dan.geabunea on 3/29/2016.
 */
(function () {
    'use strict';

    angular
        .module('app')
        .controller('BookingsController', BookingsController);

    BookingsController.$inject = ['$http'];

    function BookingsController($http) {
        var vm = this;

        vm.bookings = [];
        vm.getAll = getAll;
        vm.getAffordable100 = getAffordable100;
        vm.getAffordable150 = getAffordable150;
        vm.getAffordable200 = getAffordable200;
        vm.deleteBooking = deleteBooking;

        init();

        function init() {
            getAll();
        }

        function getAll() {
            var url = "/bookings/all";
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function (response) {
                vm.bookings = response.data;
            });
        }

        function getAffordable100() {
            var url = "/bookings/affordable/100";
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function (response) {
                vm.bookings = response.data;
            });
        }

        function getAffordable150() {
            var url = "bookings/affordable/150";
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function (response) {
                vm.bookings = response.data;
            });
        }

        function getAffordable200() {
            var url = "bookings/affordable/200";
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function (response) {
                vm.bookings = response.data;
            });

        }

        function deleteBooking(id) {
            var url = "/bookings/delete/" + id;
            $http.post(url).then(function (response) {
                vm.bookings = response.data;
            });
        }
    }
})();
