<?php
$ip = "127.0.0.1:161";
$tcpConnState = snmp2_walk($ip, "public" , ".1.3.6.1.2.1.6.13.1.1");
$tcpConnLocalAddress = snmp2_walk($ip, "public" , ".1.3.6.1.2.1.6.13.1.2");
$tcpConnLocalPort = snmp2_walk($ip, "public" , ".1.3.6.1.2.1.6.13.1.3");
$tcpConnRemAddress = snmp2_walk($ip, "public" , ".1.3.6.1.2.1.6.13.1.4");
$tcpConnRemPort = snmp2_walk($ip, "public" , ".1.3.6.1.2.1.6.13.1.5");

$data = array(
    'one' => $tcpConnState,
    'two' => $tcpConnLocalAddress,
    'three' => $tcpConnLocalPort,
    'four' => $tcpConnRemAddress,
    'five' => $tcpConnRemPort
);
$json_data = json_encode($data);
echo $json_data


?>