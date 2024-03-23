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
var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function () {
  if (xhr.readyState === 4 && xhr.status === 200) {
    data = JSON.parse(xhr.responseText);
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
    }
  }
};
xhr.open("GET", "../Services/Service1.php", true);
xhr.send();
