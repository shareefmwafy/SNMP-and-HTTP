// Fetch JSON data
let keywords = [
  "In Packets",
  "Out Packets",
  "Bad Versions",
  "Bad Community Name",
  "Bad Community Uses",
  "Parsing Errors",
  "Too Big",
  "No Names",
  "Bad Values",
  "Read Only",
  "General Errors",
  "Total Valid Request",
  "Total Valid Set-Request",
  "Total Get Request",
  "Total Get-Next",
  "Total Set-Request",
  "Total Get Response",
  "In Traps",
  "Out To Big",
  "Out No Names",
  "Out Bad Values",
  "Out Generate Errors",
  "Out Get-Request",
  "Out Get-Next",
  "Out Set-Request",
  "Out Get-Response",
  "Out Traps",
  "Enable Auto Traps",
];
let table = document.getElementById("table");
let table2 = document.getElementById("table1");
let i = 0;
var data = [];

fetch("../Services/Service4.php")
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(jsonData => {
    console.log(jsonData);
    console.log(jsonData[1][i].split(":")[0]);
    for (let i = 0; i < jsonData[0].length; i++) {
      //! Table Using Walk
      let value_walk = jsonData[0][i].split(":")[1];

      let row_walk = document.createElement("tr");
      let idTr = document.createElement("td");
      let nameTr = document.createElement("td");
      let valueTr_walk = document.createElement("td");

      idTr.textContent = i;
      nameTr.textContent = keywords[i];
      valueTr_walk.textContent = value_walk;
      row_walk.appendChild(idTr);
      row_walk.appendChild(nameTr);
      row_walk.appendChild(valueTr_walk);
      table.appendChild(row_walk);
      //! Table Using Get
      let id_get = jsonData[1][i].split(":")[0];
      let value_get = jsonData[1][i].split(":")[2];
      let row_get = document.createElement("tr");
      let idTr_get = document.createElement("td");
      let nameTr_get = document.createElement("td");
      let valueTr_get = document.createElement("td");

      idTr_get.textContent = id_get;
      nameTr_get.textContent = keywords[i];
      valueTr_get.textContent = value_get;

      row_get.appendChild(idTr_get);
      row_get.appendChild(nameTr_get);
      row_get.appendChild(valueTr_get);

      table2.appendChild(row_get);
    }
  })
  .catch(error => {
    console.error('There was a problem with the fetch operation:', error);
  });
