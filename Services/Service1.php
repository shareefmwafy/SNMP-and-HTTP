<?php
$ip = "127.0.0.1:161";
$systemGroup = snmp2_walk($ip, "public", ".1.3.6.1.2.1.1");
echo json_encode($systemGroup);
?>