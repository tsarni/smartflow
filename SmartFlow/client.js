// function addmsg(type, msg){
//        /* Simple helper to add a div.
//        type is the name of a CSS class (old/new/error).
//        msg is the contents of the div */
//        $("#messages").append(
//            "<div class='msg "+ type +"'>"+ msg +"</div>"
//        );
//    }

    function waitForMsg(msg){
        /* This requests the url "msgsrv.php"
        When it complete (or errors)*/
    	
        $.ajax({
            type: "POST",
            url: msg,

            async: true, /* If set to non-async, browser shows page as "Loading.."*/
            cache: false,
            timeout:50000, /* Timeout in ms */

            success: function(data){ 
                
                //setTimeout(UpdateTimer(),1000s);
            	
            	//alert("got some stuff back:" + data);
            	counter=setInterval(UpdateTimer, 1000); 
            	document.getElementById("holder").innerHTML = data;
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                addmsg("error", textStatus + " (" + errorThrown + ")");
                setTimeout(
                    waitForMsg, /* Try again after.. */
                    15000); /* milliseconds (15seconds) */
            }
        });
    };

    $(document).ready(function(){
        //waitForMsg(); /* Start the inital request */
    	//window.setTimeOut(UpdateTimer(),1000);
    	counter=setInterval(UpdateTimer, 1000); 
    });
    var counter;
    var TotalSeconds = 10;
    
    function UpdateTimer() {
        var Seconds = TotalSeconds;
        

        var Minutes = Math.floor(Seconds / 60);
        Seconds -= Minutes * (60);


        var TimeStr = LeadingZero(Minutes) + ":" + LeadingZero(Seconds)


        document.getElementById("timer").innerHTML = TimeStr;
        
        if(TotalSeconds <= 0) {
        	waitForMsg("NEXT");
        	clearInterval(counter);
        	TotalSeconds = 10;
        } else {
        	TotalSeconds -= 1;
        }

        
    }

    function LeadingZero(Time) {

        return (Time < 10) ? "0" + Time : + Time;

    }
    
    function callNext () {
    	clearInterval(counter);
    	TotalSeconds = 10;
    	waitForMsg("NEXT");
    }
    
    function callPrevious () {
    	clearInterval(counter);
    	TotalSeconds = 10;
    	waitForMsg("PREVIOUS");
    }




