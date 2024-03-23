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
        <div class="table-by-walk">
            <h2>Statistics by Walk</h2>
            <table>
                <tr>
                    <th>OID</th>
                    <th>Value</th>
                </tr>
                <?php
                $ip = "127.0.0.1:161";
                $snmp_walk = snmp2_walk($ip, "public" , ".1.3.6.1.2.1.11");
                foreach ($snmp_walk as $oid => $value) {
                    echo "<tr><td>$oid</td><td>$value</td></tr>";
                }
                ?>
            </table>
        </div>
        <div class="table-by-get">
            <h2>Statistics by Get</h2>
            <table>
                <tr>
                    <th>OID</th>
                    <th>Value</th>
                </tr>
                <?php
                $snmp_get = snmp2_get ($ip, "public" , ".1.3.6.1.2.1.11.1.0");
                // echo "<tr><td>.1.3.6.1.2.1.11.1.0</td><td>$snmp_get</td></tr>";
                $my_array  = array();
                for ($i = 1; $i <= 30; $i++) {
                    if ($i == 7 || $i == 23) 
                        continue;
                    else {
                        $value = snmp2_get($ip, "public", ".1.3.6.1.2.1.11." . $i . ".0");
                        echo "<tr><td>.1.3.6.1.2.1.11.$i.0</td><td>$value</td></tr>";
                    }
                }
                ?>
            </table>
        </div>
    </div>
</body>
</html>
