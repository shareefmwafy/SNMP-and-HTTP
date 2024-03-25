<?php
 $T1 = $_REQUEST["T1"];
 $T2 = $_REQUEST["T2"];
 
 $sum = $T1+$T2;
 $prod = $T1*$T2;
 
 echo "Server Says: I am Here Now\n";
 echo "POST: ".json_encode($_POST) ."\n";
 echo "GET: ".json_encode($_GET) ."\n";
 echo "Date: ".date("M d, Y")."\n";
 echo "Time: ".date("h:i:s A")."\n"; 
 echo "Time Zone: " .date_default_timezone_get() ."\n";
 for($i =0; $i<1; $i++)
 {
     echo "Sum : T1+T2 = $sum \r";
     echo "Prod: T1*T2 = $prod \n";
 }
     
?>
