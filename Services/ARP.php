<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ARP Table</title>
    <style>
        .arp-table-container {
            margin-top: 20px;
            max-width: 600px;
            margin: auto;
        }

        .arp-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        .arp-table th,
        .arp-table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        .arp-table th {
            background-color: #f2f2f2;
        }

    </style>
</head>
<body>
    <?php
    $ip = "127.0.0.1:161"; 
    $arpTable = snmp2_walk($ip, "public", ".1.3.6.1.2.1.4.22.1.2"); 

    

    if (is_array($arpTable)) {
        echo '<div class="arp-table-container">';
        echo "<h2>ARP Table</h2>";
        echo '<table class="arp-table">';
        echo '<tr><th>IP Address</th><th>MAC Address</th></tr>';

        foreach ($arpTable as $ipAddress => $macAddress) {
            echo '<tr>';
            echo '<td>' . $ipAddress . '</td>';
            echo '<td>' . $macAddress . '</td>';
            echo '</tr>';
        }

        echo '</table>';
        echo '</div>';
    } else {
        echo 'Failed to retrieve ARP table information.';
    }
    ?>
</body>
</html>
