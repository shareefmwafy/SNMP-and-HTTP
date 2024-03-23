<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TCP Connection Information</title>
    <style>
        .tcp-table-container {
            margin-top: 20px;
            max-width: 800px;
            margin: auto;
        }
        .tcp-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        .tcp-table th, .tcp-table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        .tcp-table th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <?php
        $ip = "127.0.0.1:161";
        $tcpConnState = snmp2_walk($ip, "public" , ".1.3.6.1.2.1.6.13.1.1");
        $tcpConnLocalAddress = snmp2_walk($ip, "public" , ".1.3.6.1.2.1.6.13.1.2");
        $tcpConnLocalPort = snmp2_walk($ip, "public" , ".1.3.6.1.2.1.6.13.1.3");
        $tcpConnRemAddress = snmp2_walk($ip, "public" , ".1.3.6.1.2.1.6.13.1.4");
        $tcpConnRemPort = snmp2_walk($ip, "public" , ".1.3.6.1.2.1.6.13.1.5");

        echo "<div class='tcp-table-container'>";
        echo "<h2>TCP Group</h2>";
        if (count($tcpConnState) === count($tcpConnLocalAddress) && 
            count($tcpConnState) === count($tcpConnLocalPort) && 
            count($tcpConnState) === count($tcpConnRemAddress) && 
            count($tcpConnState) === count($tcpConnRemPort)) {

            echo '<table class="tcp-table">';
            echo '<tr><th>TCP Connection State</th><th>Local Address</th><th>Local Port</th><th>Remote Address</th><th>Remote Port</th></tr>';

            for ($i = 0; $i < count($tcpConnState); $i++) {
                echo '<tr>';
                echo '<td>' . $tcpConnState[$i] . '</td>';
                echo '<td>' . $tcpConnLocalAddress[$i] . '</td>';
                echo '<td>' . $tcpConnLocalPort[$i] . '</td>';
                echo '<td>' . $tcpConnRemAddress[$i] . '</td>';
                echo '<td>' . $tcpConnRemPort[$i] . '</td>';
                echo '</tr>';
            }

            echo '</table>';
        } else {
            echo 'Failed to retrieve TCP connection information.';
        }
        echo "</div>";
    ?>
</body>
</html>
