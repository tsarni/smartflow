
	var counter;
    var delayInSeconds = 10;


    function pollServer(msg){
    	if(msg === "START") {
    		
    	}else {
    		resetTimer();
    	}
    	
        $.ajax({
            type: "POST",
            url: msg,
            async: true, 
            cache: false,
            timeout:50000,
            success: function(data){ 
            	if(msg === "STOP") {
            		
            	} else {
            		counter = setInterval(UpdateTimer, 1000); 
            	}
            	 document.getElementById("holder").innerHTML = data;},
            error: function(XMLHttpRequest, textStatus, errorThrown){
                alert("error: " + textStatus + " (" + errorThrown + ")");
                setTimeout(
                    pollServer, /* Try again after.. */
                    15000); /* milliseconds (15seconds) */
            }
        });
    };

    $(document).ready(function(){

    	//counter=setInterval(UpdateTimer, 1000); 
    });
    
   
    function UpdateTimer() {
        var Seconds = delayInSeconds;
        
        var Minutes = Math.floor(Seconds / 60);
        Seconds -= Minutes * (60);

        var TimeStr = LeadingZero(Minutes) + ":" + LeadingZero(Seconds)

        document.getElementById("timer").innerHTML = TimeStr;
        
        if(delayInSeconds <= 0) {
        	pollServer("NEXT");
        	resetTimer();
        } else {
        	delayInSeconds -= 1;
        }
        
    }

    function LeadingZero(Time) {

        return (Time < 10) ? "0" + Time : + Time;

    }

    function resetTimer() {
    	clearInterval(counter);
    	delayInSeconds = 10;
    	document.getElementById("timer").innerHTML = "";
    }
