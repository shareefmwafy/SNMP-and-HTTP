<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SNMP Statistics</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            margin-top: 20px;
        }

        .table-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            margin-top: 20px;
            max-width: 1000px;
            margin: auto;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        
    </style>
</head>
<body>
    <h1>SNMP Statistics</h1>
    <div class="table-container">


    <div class="table-by-get">
            <h2>Statistics by Get</h2>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Value</th>
                </tr>
                <?php
                $oid_labels = array(
                    "0" => "Unknown", // Placeholder for index 0
                    "1" => "snmpInPkts",
                    "2" => "snmpOutPkts",
                    "3" => "snmpInBadVersions",
                    "4" => "snmpInBadCommunityName",
                    "5" => "snmpInBadCommunityUses",
                    "6" => "snmpInASNParseErrs",
                    "7" => "snmpOutASNParseErrs", // Added
                    "8" => "snmpInTooBigs",
                    "9" => "snmpInNoSuchNames",
                    "10" => "snmpInBadValues",
                    "11" => "snmpInReadOnlys",
                    "12" => "snmpInGenErrs",
                    "13" => "snmpInTotalRegVars",
                    "14" => "snmpInTotalSetVars",
                    "15" => "snmpInGetRequests",
                    "16" => "snmpInGetNexts",
                    "17" => "snmpInSetRequests",
                    "18" => "snmpInGetResponses",
                    "19" => "snmpInTraps",
                    "20" => "snmpQutTooBigs",
                    "21" => "snmpOutNoSuchNames",
                    "22" => "snmpOutBadValues",
                    "23" => "snmpOutBadValues", // Changed from 24 to 23
                    "24" => "snmpOutGenErrs",
                    "25" => "snmpOutGetRequests",
                    "26" => "snmpOutGetNexts",
                    "27" => "snmpOutSetRequests",
                    "28" => "snmpOutGetResponses",
                    "29" => "snmpOutTraps",
                    "30" => "snmpEnableAuthenTraps"
                );
                
                
                $ip = "127.0.0.1:161";
                $community = "public";
                $group_oid = ".1.3.6.1.2.1.11";
                $snmp_get = snmp2_get ($ip, $community , ".1.3.6.1.2.1.11.1.0");
                // echo "<tr><td>.1.3.6.1.2.1.11.$i.0</td><td>{$oid_labels[$i]}</td><td>$value</td></tr>";
                $my_array  = array();
                

                for ($i = 1; $i <= 30; $i++) {
                    if ($i == 7 || $i == 23) 
                        continue;
                    else {
                        $value = snmp2_get($ip, $community, ".1.3.6.1.2.1.11." . $i . ".0");
                        echo "<tr><td>.1.3.6.1.2.1.11.$i.0</td><td>{$oid_labels[$i]}</td><td>$value</td></tr>";
            }
                }
                ?>
            </table>
        </div>

        <div class="table-by-walk">
            <h2>Statistics by Walk</h2>
            <table>
                <tr>
                    <th>OID</th>
                    <th>Name</th>
                    <th>Value</th>
                </tr>
                <?php
                 $oid_labels = array(
                    // "0" => "Unknown", // Placeholder for index 0
                    "0" => "snmpInPkts",
                    "1" => "snmpOutPkts",
                    "2" => "snmpInBadVersions",
                    "3" => "snmpInBadCommunityName",
                    "4" => "snmpInBadCommunityUses",
                    "5" => "snmpInASNParseErrs",
                    // "6" => "snmpOutASNParseErrs", // Added
                    "6" => "snmpInTooBigs",
                    "7" => "snmpInNoSuchNames",
                    "8" => "snmpInBadValues",
                    "9" => "snmpInReadOnlys",
                    "10" => "snmpInGenErrs",
                    "11" => "snmpInTotalRegVars",
                    "12" => "snmpInTotalSetVars",
                    "13" => "snmpInGetRequests",
                    "14" => "snmpInGetNexts",
                    "15" => "snmpInSetRequests",
                    "16" => "snmpInGetResponses",
                    "17" => "snmpInTraps",
                    "18" => "snmpQutTooBigs",
                    "19" => "snmpOutNoSuchNames",
                    "20" => "snmpOutBadValues",
                    "21" => "snmpOutGenErrs",
                    "22" => "snmpOutGetRequests",
                    "23" => "snmpOutGetNexts",
                    "24" => "snmpOutSetRequests",
                    "25" => "snmpOutGetResponses",
                    "26" => "snmpOutTraps",
                    "27" => "snmpEnableAuthenTraps"
                );

                $group_oid = ".1.3.6.1.2.1.11";
                $snmp_walk = snmp2_walk($ip, $community , $group_oid );
               
                foreach ($snmp_walk as $oid => $value) {
                    echo "<tr><td>$oid</td><td> $oid_labels[$oid]</td><td>$value</td></tr>";
                }
                ?>
            </table>
        </div>
        
    </div>
</body>
</html>
