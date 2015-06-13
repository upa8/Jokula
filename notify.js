var gcm = require('node-gcm');

var message = new gcm.Message();


var sender = new gcm.Sender('AIzaSyADxc-C8pOner1TPfo4WVGy37n5WpwvxgY');

var regIds = [];
// this is message that we are trying to send to user 
message.addData('message', 'meet me now at office everyone');
//THIS IS FOR TITLE OF MESSAGE 
message.addData('title', 'Urgently');
// This for vibration time 
message.addData('msgcnt', '3');
// this is for notification sound (sound clip )
message.addData('soundname', 'beep.wav');
// notification should last on notification bar for this much time 
message.timeToLive=3;
//This is user id 
// 
regIds.push('APA91bEH64tSuxMbqFXy9yX442VJwKBPwcps9WCL9nG0zIqCsPzo-5ufy_JdvTt3tI8XBBCIN_EU4JEcxPWxn_IP8sieuh3FjSeGI1-E6t-84Z1b_8rZ3XAFYr4SnueF_qR5mheUqkTg0T31q0bfa29h3sCvkwz9KA');


// for other user 
//regIds.push('APA91bFnjQ2rhaghBbs_flrkSkpuMGQlMvHNOp2B4lbVYwolQH0vWr8jsDKpEIu_JjN-oajhrIQZfPnTFT9YDyDNxLHiyNce7ip60TiNK3xB9WbDxdwBEDBqN7BYs0uq8Vcj-nb-XiH5tcu2YXYTt9O-M7HcC1IpYA');


sender.send(message,regIds,4,function result(){


	console.log(result);
});




sender.send(message, regIds, function (err, result) {
    if(err) console.error(err);
    else    console.log(result);
});
