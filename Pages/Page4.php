<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
    .table-container {
        display: flex;
        justify-content: space-around;
        align-items: center;
    }

    table {
        border-collapse: collapse;
        width: 40%;
    }

    th, td {
        border: 1px solid #dddddd;
        text-align: center;
        padding: 8px;
    }

    th {
        background-color: #f2f2f2;
        color: black;
    }
    .topics{
        display: flex;
        justify-content: space-around;
        align-items: space-between;
        color:white;
    

    }

    body {
        font-family: Arial, sans-serif;
        background: url("../Images/3.jpg") center repeat;
        display: flex;
        justify-content: center;
        flex-direction: column;
        align-items: space-between;
        color: white;
    }
</style>
</head>
<body>

<div class="topics">
    <h2>Using Walk Method</h2>
    <h2>Using Get Method</h2>
</div>
<div class="table-container">
    <table id="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Value</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
    <table id="table1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Value</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
<script src="../JS/Data4.js"></script>

</body>
</html>