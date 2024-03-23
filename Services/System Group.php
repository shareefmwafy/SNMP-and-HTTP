<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SNMP Statistics</title>
    <link rel="stylesheet" href="styles.css"> 
    <style>
        
        .snmp-output {
            background-color: #f5f5f5;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-top: 20px;
            max-width: 600px;
            margin: auto;
        }

        .snmp-output h2 {
            margin-top: 0;
            color: blue;
        }

        .snmp-output p {
            margin: 0;
            padding: 5px 0;
            font-size: 16px;
        }

        .snmp-output p strong {
            color: blue;
        }

        .TcpTable {
            margin-top: 20px;
            max-width: 600px;
            margin: auto;
        }

        .arpTable {
            margin-top: 20px;
            max-width: 600px;
            margin: auto;
        }

        .TcpTable,
        .arpTable {
            width: 100%;
            border-collapse: collapse;
        }

        .TcpTable th,
        .arpTable th,
        .TcpTable td,
        .arpTable td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        .TcpTable th,
        .arpTable th {
            background-color: #f2f2f2;
        }

    </style>
</head>
<body>
    <?php
    $ip = "127.0.0.1:161";
    $oid = ".1.3.6.1.2.1.1";
    $systemGroup = snmp2_walk($ip, "public", $oid);

    echo '<div class="snmp-output">';
    echo "<h2>System Group</h2>";
    if (is_array($systemGroup) || is_object($systemGroup)) {
        foreach ($systemGroup as $key => $value) {
            echo "<p><strong>$key:</strong> $value</p>";
        }
    } else {
        echo "<p>Failed to retrieve System group information.</p>";
    }
    echo '</div>';
    ?>
</body>
</html>
