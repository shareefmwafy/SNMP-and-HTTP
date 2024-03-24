// Fetch JSON data
let keywords = [
  "System Description",
  "System ObjectID",
  "System UpTime",
  "System Contact",
  "System Name",
  "System Location",
];
let table = document.getElementById("table");
let i = 0;
var data = [];

fetch("../Services/Service1.php")
  .then(response => {
    if (!response.ok) {
      throw new Error('Connection error, No response from server');
    }
    return response.json();
  })
  .then(jsonData => {
    data = jsonData;
    for (let i = 0; i < data.length - 1; i++) {
      let value = data[i].split(":")[1];
      let keyword = keywords[i];
      let row = document.createElement("tr");
      let keyData = document.createElement("td");
      let valData = document.createElement("td");
      keyData.textContent = keyword;
      valData.textContent = value;
      row.appendChild(keyData);
      row.appendChild(valData);
      table.appendChild(row);
      console.log(data);
    }
  })
  .catch(error => {
    console.error('Error fetching data:', error);
  });

  
