
	var counter;
    var delayInSeconds;
    var isStopped = false;
    var TimeStr = "";
   
    
    

    function pollServer(msg){
    	if(msg === "START") {
    		if (isStopped == false) {
    			readVariable();
    		} 
    		
    	}else {
    		if (msg == "STOP") {
    			
    		}else {
    			resetTimer();
    		}
    		
    	}
    	
        $.ajax({
            type: "POST",
            url: msg,
            async: true, 
            cache: false,
            timeout:50000,
            success: function(data){ 
            	if(msg === "STOP") {
            		isStopped = true;
            		clearInterval(counter);
            	} else {
            		
            		counter = setInterval(UpdateTimer, 1000); 
            		isStopped == false;       		
            	}
            	 document.getElementById("holder").innerHTML = data;
            	 document.getElementById("timer").innerHTML = TimeStr;},
            error: function(XMLHttpRequest, textStatus, errorThrown){
                alert("error: " + textStatus + " (" + errorThrown + ")");
                setTimeout(
                    pollServer, /* Try again after.. */
                    30000); /* milliseconds (30seconds) */
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

        TimeStr = LeadingZero(Minutes) + ":" + LeadingZero(Seconds)

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
    	TimeStr = "";
    	readVariable();
    	document.getElementById("timer").innerHTML = "";
    }
    
	function readVariable() {

		var txtFile = new XMLHttpRequest();
		txtFile.open("GET", "durationValue.txt", true);
		
		txtFile.onreadystatechange = function() {
			if (txtFile.readyState === 4) {  // Makes sure the document is ready to parse.
				if (txtFile.status === 200) {  // Makes sure it's found the file.
					value = txtFile.responseText; 
					//lines = txtFile.responseText.split("\n"); // Will separate each line into an array
					delayInSeconds = value;
				}
			}
		}
		
		txtFile.send(null);
	}


    