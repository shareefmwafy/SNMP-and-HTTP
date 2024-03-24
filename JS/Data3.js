let table = document.getElementById("table");
let i = 0;
let data = [];

fetch("../Services/Service3.php")
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(jsonData => {
    data = jsonData;
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
  })
  .catch(error => {
    console.error('There was a problem with the fetch operation:', error);
  });
