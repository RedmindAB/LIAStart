var express = require('express');
var socket = require('socket.io');
var app = express();

var server = app.listen(80, function () {
  console.log('listening for requests on port 80');
});

app.use(express.static('public'));

var io = socket(server);

io.on('connection', (socket) => {

  console.log('made socket connection : ' + socket.id);

  socket.on('userData', (data) => {    
    console.log(socket.id)
    var sendingData = {
      "userInput": data.userInput,
      "userName": data.userName,
      "socketId": socket.id
  }
  
    io.emit('chat', sendingData);
  });

  socket.on('userData2', (data) => {    
    console.log(socket.id)
    var sendingData = {
        "userInput": data.userInput,
        "userName": data.userName,
        "socketId": socket.id
    }
    io.emit('chat2', sendingData);
  });

  socket.on('pm', (data) => {
    var sendingData = {
      "userInput": data.userInput,
      "userName": data.userName,
      "socketId": socket.id
  }
    socket.broadcast.to(data.socketId).emit(sendingData);
  });

});