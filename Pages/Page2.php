<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
    table {
        border-collapse: collapse;
        width: 80%;

    }
    th, td {
        border: 1px solid #dddddd;
        text-align: center;
        padding: 8px;
    }
    th {
        background-color: #f2f2f2;
        color:black;
    }
    body {
        font-family: Arial, sans-serif;
        background: url("../Images/3.jpg") center/cover no-repeat; 
        display: flex;
        justify-content: center;
        flex-direction: column;
        align-items: center;
        color:white;
}
    
</style>
</head>
<body>
<table id="table">
    <thead>
        <tr>
            <th>Connection State</th>
            <th>Local Address</th>
            <th>Local Port</th>
            <th>Remote Address</th>
            <th>Remote Port</th>
        </tr>
    </thead>
    <tbody>
    </tbody>
</table>

<script src="../JS/Data2.js"></script>

</body>
</html>