/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var iconUrl;

function Move(direction) {
    $.post("MoveServlet",
            {
                move: direction
            },
            function (data) {
                var cell = document.getElementById(data.Prv);
                cell.style.background = "pink";
                var cell = document.getElementById(data.location);
                cell.style.backgroundImage = iconUrl;
                cell.style.backgroundSize = "cover";
            });
}
function Clue() {
    $.getJSON('Hint', function (data) {
        var cell = document.getElementById(data.Hint);
        cell.style.background = "white";
    });
}

function Reset() {
    $.getJSON('Reset', function (data) {
        var cell = document.getElementById(data.Prv);
        cell.style.background = "pink";
        var start = document.getElementById(data.Start);
        start.style.backgroundImage = iconUrl;
        start.style.backgroundSize = "cover";
       // document.setUserData()
    });
}
function generate_table(mazeString, size, startRow, startCol, endRow, endCol, icon) {
    // get the reference for the body
    var body = document.getElementsByClassName("Main")[0];
    // var body = document.getElementsByTagName("body")[0];
    // creates a <table> element and a <tbody> element
    var tbl = document.createElement("table");

    var tblBody = document.createElement("tbody");
    var x = 0;
    // creating all cells
    for (var i = 0; i < parseInt(size); i++) {
        // creates a table row
        var row = document.createElement("tr");
        for (var j = 0; j < parseInt(size); j++) {
            // Create a <td> element and a text node, make the text
            // node the contents of the <td>, and put the <td> at
            // the end of the table row
            var cell = document.createElement("td");
            cell.setAttribute('id', (i * parseInt(size) + j));
            row.appendChild(cell);

            if (mazeString.charAt(x) === '1') {
                cell.style.background = "purple";
            }
            if ((i === (parseInt(startRow))) && (j === (parseInt(startCol)))) {
                //cell.style.background = "yellow";
                var str = "url(" + icon + ")";
                iconUrl = str;
                cell.style.backgroundImage = str;
                cell.style.backgroundSize = "cover";
                //console.log("str");
            }
            if ((i === (parseInt(endRow))) && (j === (parseInt(endCol)))) {
                //cell.style.background = "blue";

                cell.style.backgroundImage = "url('/../pic/flower2.jpg')";
                cell.style.backgroundSize = "cover";
                //console.log(cell.prototype.background);
            }
            x++;
        }

        // add the row to the end of the table body
        tblBody.appendChild(row);
    }

    // put the <tbody> in the <table>
    tbl.appendChild(tblBody);
    tbl.style.background = "pink";
    tbl.style.borderSpacing = "0px";
    tbl.style.width = "500px";
    tbl.style.height = "500px";
    tbl.style.borderSpacing = "0px";
    // appends <table> into <body>
    body.appendChild(tbl);
    // sets the border attribute of tbl to 2;
    //tbl.setAttribute("border", "2");
}