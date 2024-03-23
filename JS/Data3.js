let table = document.getElementById("table");
let i = 0;
var data = [];
var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function () {
  if (xhr.readyState === 4 && xhr.status === 200) {
    data = JSON.parse(xhr.responseText);
    for (let i = 0; i < data.one.length - 1; i++) {
      let interface = data.one[i].split(":")[1];
      let physicalAddress = data.two[i].split(":")[1];
      let ipAddress = data.three[i].split(":")[1];
      let mappingType = data.four[i].split(":")[1];

      let row = document.createElement("tr");

      let interfaceTd = document.createElement("td");
      let physicalAddressTd = document.createElement("td");
      let ipAddressTd = document.createElement("td");
      let mappingTypeTd = document.createElement("td");

      interfaceTd.textContent = interface;
      physicalAddressTd.textContent = physicalAddress;
      ipAddressTd.textContent = ipAddress;
      mappingTypeTd.textContent = mappingType;

      row.appendChild(interfaceTd);
      row.appendChild(physicalAddressTd);
      row.appendChild(ipAddressTd);
      row.appendChild(mappingTypeTd);

      table.appendChild(row);
    }
  }
};
xhr.open("GET", "../Services/Service3.php", true);
xhr.send();
