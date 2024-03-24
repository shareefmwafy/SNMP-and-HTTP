<?php
$ip = "127.0.0.1:161";
$snmp_walk = snmp2_walk($ip, "public" , ".1.3.6.1.2.1.11");
$snmp_get = snmp2_get ($ip, "public" , ".1.3.6.1.2.1.11.3.0");
// echo json_encode ($snmp_walk);
$my_array  = array();
for ($i = 1 ; $i<=30;$i++) {
    if ($i == 7 || $i == 23) // ignore 7 and 23
    continue;
else {
    array_push($my_array ,$i. ":".snmp2_get ($ip, "public" , ".1.3.6.1.2.1.11.".$i.".0")); // get all elements
}
}

$final_array = array($snmp_walk , $my_array);
echo json_encode ($final_array);
?>