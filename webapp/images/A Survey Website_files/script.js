$(document).ready(function () {
    // Add your jQuery here 

    $("div#googleforms, div#surveymonkey, div#typeform, div#zohosurvey").hide();
    $("li#googleforms").hide();
    $("li#surveymonkey").hide();
    $("li#typeform").hide();
    $("li#zohosurvey").hide();

    $("div#outermenu").mouseenter(function () {
        $("li#googleforms, li#surveymonkey, li#typeform, li#zohosurvey").show("slow");
    });

    $("div#outermenu").mouseleave(function () {
        $("li#googleforms, li#surveymonkey, li#typeform, li#zohosurvey").hide("slow");

    });

    $("li#googleforms").click(function () {
        $("div#googleforms").toggle();

    });

    $("li#surveymonkey").click(function () {
        $("div#surveymonkey").toggle();

    });

    $("li#typeform").click(function () {
        $("div#typeform").toggle();

    });

    $("li#zohosurvey").click(function () {
        $("div#zohosurvey").toggle();

    });
    
    $("#qType").change(function () {
        console.log("hello world");
        "hello sonny";
    })


});
