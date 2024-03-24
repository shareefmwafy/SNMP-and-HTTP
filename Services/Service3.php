<?php
$ip = "127.0.0.1:161";
$ipNetToMediaIfIndex = snmp2_walk($ip, "public" , ".1.3.6.1.2.1.4.22.1.1");
$ipNetToMediaPhysAddress = snmp2_walk($ip, "public" , ".1.3.6.1.2.1.4.22.1.2");
$ipNetToMediaNetAddress = snmp2_walk($ip, "public" , ".1.3.6.1.2.1.4.22.1.3");
$ipNetToMediaType = snmp2_walk($ip, "public" , ".1.3.6.1.2.1.4.22.1.4");


$data = array(
    'one' => $ipNetToMediaIfIndex,
    'two' => $ipNetToMediaPhysAddress,
    'three' => $ipNetToMediaNetAddress,
    'four' => $ipNetToMediaType
);
$json_data = json_encode($data);
echo $json_data
?>