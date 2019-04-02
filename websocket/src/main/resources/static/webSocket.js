
var stompClient = null;
//加载完浏览器后  调用connect（），打开双通道
$(function(){
    //打开双通道
   // connect()
})
//强制关闭浏览器  调用websocket.close（）,进行正常关闭
window.onunload = function() {
    disconnect()
}
//广播
function connect1(){
    var socket = new SockJS('http://127.0.0.1:8080/nmpSocketWeb'); //连接SockJS的endpoint名称为"endpointOyzc"
    stompClient = Stomp.over(socket);//使用STMOP子协议的WebSocket客户端
    stompClient.connect({},function(frame){//连接WebSocket服务端
        console.log('Connected:' + frame);
        //通过stompClient.subscribe订阅/topic/getResponse 目标(destination)发送的消息
        stompClient.subscribe('/topic/getResponse',function(response){
            showResponse(JSON.parse(response.body));
        });
    });
}
//点对点
function connect(){
    var userId="1000002";
    var socket = new SockJS('http://127.0.0.1:8080/nmpSocketWeb'); //连接SockJS的endpoint名称为"endpointOyzc"
    stompClient = Stomp.over(socket);//使用STMOP子协议的WebSocket客户端
    stompClient.connect({"oauth":userId},function(frame){//连接WebSocket服务端
        //console.log('Connected:' + frame);
        //通过stompClient.subscribe订阅/topic/getResponse 目标(destination)发送的消息
        stompClient.subscribe('/user/' + userId + '/user/getResponse',function(response){
            var code=JSON.parse(response.body);
            showResponse(code)
        });
    });
}

function connectionAuto() {
    if(stompClient != null) {
        //stompClient.disconnect();
        console.log("已有链接，断开后重连");
        //$("#response").html('')
    }
    var userId = $("#userId").val();
    var socket = new SockJS('http://127.0.0.1:8080/nmpSocketWeb'); //连接SockJS的endpoint名称为"endpointOyzc"
    stompClient = Stomp.over(socket);//使用STMOP子协议的WebSocket客户端
    stompClient.connect({"oauth":userId},function(frame){//连接WebSocket服务端
        console.log("fram "+frame)
        //console.log('Connected:' + frame);
        //通过stompClient.subscribe订阅/topic/getResponse 目标(destination)发送的消息
        stompClient.subscribe('/user/' + userId + '/qqqq/dd/ddd',function(response){
            var code=JSON.parse(response.body);
            console.log(response.headers)
            showResponse(code)
        });
    });
}

function sendMessage() {
    var send_message = $("#send_message").val();
    var userId = $("#userId").val();
    /*$.post("http://127.0.0.1:8080/socket/meaage",{"id":userId,"message":send_message},function (data) {
        alert(data)
    })*/
    var headers = {
        login: 'mylogin',
        passcode: 'mypasscode',
        // additional header
        'client-id': userId
    };
    stompClient.send("/user/"+ userId+"/test",headers,JSON.stringify({"id":userId,"message":send_message}));
}

//关闭双通道
function disconnect(){
    if(stompClient != null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}
function showResponse(message) {
    var response = $("#response");
    response.append("<p>" + message.message + "</p>");
}