let table = document.getElementById("table");
let i = 0;
var data = [];
var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function () {
  if (xhr.readyState === 4 && xhr.status === 200) {
    data = JSON.parse(xhr.responseText);
    for (let i = 0; i < data.one.length - 1; i++) {
      let connectionState = data.one[i].split(":")[1];
      let systemUpTime = data.two[i].split(":")[1];
      let localPort = data.three[i].split(":")[1];
      let remoteAddress = data.four[i].split(":")[1];
      let remotePort = data.five[i].split(":")[1];

      let row = document.createElement("tr");

      let connectionStateTd = document.createElement("td");
      let systemUpTimeTd = document.createElement("td");
      let localPortTd = document.createElement("td");
      let remoteAddressTd = document.createElement("td");
      let remotePortTd = document.createElement("td");

      connectionStateTd.textContent = connectionState;
      systemUpTimeTd.textContent = systemUpTime;
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
  }
};
xhr.open("GET", "../Services/Service2.php", true);
xhr.send();
