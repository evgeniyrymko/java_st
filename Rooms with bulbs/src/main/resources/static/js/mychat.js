'use strict';

var stompClient = null;
var idRoom = $('#idRoom').html();
var topic = null;
var currentSubscription;

window.onload = init;

function connect() {
    var socket = new SockJS('/sock');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, onConnected);
    // event.preventDefault();
}

function onConnected() {
    enterRoom();
}

function enterRoom() {
    var id = $("#idRoom").html();
    topic = '/chat-app/chat/' + id;
    currentSubscription = stompClient.subscribe('/chat-room/' + id, onMessageReceived);
}

// function onMessageReceived(payload) {
//
// }

function sendMessage(event) {
    var id = $("#idRoom").html();
    var name = $("#name").html();
    var countryName = $("#countryName").html();
    var bulbTurnedOn = $("#bulbTurnedOn").html();
    topic = `/chat-app/chat/${id}`;
    if (stompClient) {
        var roomDto = {id: id, name: name, countryName: countryName, bulbTurnedOn: bulbTurnedOn};
        stompClient.send(`${topic}/sendMessage`, {}, JSON.stringify(roomDto));
    }
    event.preventDefault();
}

function onMessageReceived(payload) {
    var roomDto = JSON.parse(payload.body);
    var output = document.getElementById("bulbTurnedOn");
    output.innerHTML = roomDto.bulbTurnedOn.toString();
    // var newP = document.createElement('p');
    // newP.appendChild(document.createTextNode(roomDto.bulbTurnedOn));
    // output.appendChild(newP);
}

function init() {
    connect();
}

$(document).ready(function () {
    // messagebox.addEventListener('submit', connect, true);
    messagebox.addEventListener('submit', sendMessage, true);
});