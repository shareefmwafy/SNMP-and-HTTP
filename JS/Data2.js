let table = document.getElementById("table");
let i = 0;
let data = [];

fetch("../Services/Service2.php")
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(jsonData => {
    data = jsonData;
    
    console.log(jsonData); 

    for (let i = 0; i < data.one.length - 1; i++) {
      let connectionState = data.one[i].split(":")[1];
      let systemUpTime = data.two[i].split(":")[1];
      let localPort = data.three[i].split(":")[1];
      let remoteAddress = data.four[i].split(":")[1];
      let remotePort = data.five[i].split(":")[1];

      let row = document.createElement("tr");

      let connectionStateTd = document.createElement("td");
      let LocalAddressTd = document.createElement("td");
      let localPortTd = document.createElement("td");
      let remoteAddressTd = document.createElement("td");
      let remotePortTd = document.createElement("td");

      connectionStateTd.textContent = connectionState;
      LocalAddressTd.textContent = systemUpTime;
      localPortTd.textContent = localPort;
      remoteAddressTd.textContent = remoteAddress;
      remotePortTd.textContent = remotePort;

      row.appendChild(connectionStateTd);
      row.appendChild(systemUpTimeTd);
      row.appendChild(localPortTd);
      row.appendChild(remoteAddressTd);
      row.appendChild(remotePortTd);

      table.appendChild(row);
    }
  })
  .catch(error => {
    console.error('There was a problem with the fetch operation:', error);
  });
