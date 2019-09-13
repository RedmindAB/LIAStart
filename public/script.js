//var socket = io.connect('http://localhost')
//var secondChat = io.connect('http://localhost/')

var senderList = [];

var socket = io('/')


socket.on('chat2', function (data) {
    console.log("TEST")
    E('chatArea2').innerHTML += data.userName + " : " + data.userInput + "\n";
})

socket.on('chat', function (data) {
    console.log(data.socketId);
    E('chatArea').innerHTML += data.userName + " : " + data.userInput + "\n";
})

socket.on('pm', function (data) {
    // console.log(data.userName + " : " + data.userInput + " .SocketID: " + data.socketId)
    recieveMsg(data)
})

function sendMsg(input) {
    var userInput = E('userInput' + input).value;
    var userName = E('userName' + input).value;

    var data = {
        "userName": userName,
        "userInput": userInput
    }
    if (input === "") {
        socket.emit('userData', data)
    } else {
        socket.emit('userData2', data)
    }
}

function recieveMsg(data) {
    if (senderList.includes(data.socketId)) {
        writeToPrivateChat(data);
    } else {
        senderList.push(data.socketId);
        createNewPrivateChat(data);
    }
}

function writeToPrivateChat(data) {
    E(data.socketId).innerHTML += data.userName + " : " + data.userInput + "\n";
}

function createNewPrivateChat(data) {
    createChatForm(data)
    writeToPrivateChat(data)
}

function createChatForm(data) {

    var privateChatForm =
        `<form style="display: inline-block" onsubmit="return false";>
                    <h1>${data.userName}</h1>
                    <textarea id="${data.socketId}" name="chatArea" style="width: 550px; height: 400px; background-color: orange;"
                        disabled></textarea>
                    <br>
                    <input type="text" id="userName" name="userName" style="width: 100px;" placeholder="Your name">
                    <input type="text" id="userInput" name="userInput" style="width: 400px;">
                    <button>Send</button>
                </form>`

    document.getElementById("privateChat").innerHTML += privateChatForm;
}

function E(id) {
    return document.getElementById(id);
}

E('chatForm').onsubmit = () => {
    sendMsg("");
    E('userInput').value = "";
    return false;
};
E('chatForm2').onsubmit = () => {
    sendMsg(2);
    E('userInput2').value = "";
    return false;
};