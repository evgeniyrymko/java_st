'use strict';

var stompClient = null;
var idRoom = $('#idRoom');
var topic = null;
var currentSubscription;

function connect(event) {
    var socket = new SockJS('/sock');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, onConnected);
    event.preventDefault();
}

function onConnected() {
    enterRoom(idRoom.value);
}

function enterRoom(idRoom) {
    var roomId = idRoom;
    topic = '/chat-app/chat/${idRoom}';
    currentSubscription = stompClient.subscribe('/chat-room/{roomId}', onMessageReceived);
}

// function onMessageReceived(payload) {
//
// }

function sendMessage(event) {
    var id = $("#idRoom").val().trim();
    var name = $("#name").val().trim();
    var countryName = $("#countryName").val().trim();
    var bulbTurnedOn = $("#bulbTurnedOn").val().trim();
    topic = `/chat-app/chat/${idRoom}`;
    if (stompClient) {
        var roomDto = {id: id, name: name, countryName: countryName, bulbTurnedOn: bulbTurnedOn};
        stompClient.send(`${topic}/sendMessage`, {}, JSON.stringify(roomDto));
    }
    event.preventDefault();
}

function onMessageReceived(payload){
    var roomDto = JSON.parse(payload.body);
    var output = document.getElementById("bulbState");
    var newP = document.createElement('p');
    newP.appendChild(document.createTextNode(roomDto.bulbTurnedOn));
    output.appendChild(newP);
}

$(document).ready(function() {
    switchDiv.addEventListener('submit', connect, true);
    switchDiv.addEventListener('submit', sendMessage, true);
});