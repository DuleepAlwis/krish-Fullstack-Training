var net = require('net');

var port = 42181;
var host = '127.0.0.1';

// var client = new net.Socket();

// client.connect(port,host,()=>{
//     console.log(`Connected to server : ${host} on ${port}`);
// }); 



var server = net.createServer((socket)=>{
    socket.on('end',()=>{
        console.log('Server: Client Disconnected');
    });
});

server.on('connection',(socket)=>{
    console.log(`connected from: ${socket.remoteAddress}:${socket.remotePort}`);
    socket.write('hello client');
    socket.end();
});

server.on('error',(err)=>{
    throw err;
});

server.listen(port,host);

