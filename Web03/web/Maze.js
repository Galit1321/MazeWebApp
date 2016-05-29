/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function generate_table(mazeString, size, startRow, startCol, endRow, endCol, icon) {
    // get the reference for the body
    var body=document.getElementsByClassName("Main")[0];
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
            //var cellText = document.createTextNode("cell in row "+i+", column "+j);
            //cell.appendChild(cellText);
            //cell.style.width = "10px";
            //cell.style.height = "10px";
            // cell.style.border="0px";
            //cell.style.borderSpacing = "0px";
            row.appendChild(cell);
            if (mazeString.charAt(x) === '1') {
                cell.style.background = "purple";
            }
            if ((i === (parseInt(startRow) *2) && j === (parseInt(startCol) * 2))) {
               // var u = session.getAttribute("Curr");
            //   cell.style.background = "yellow";
               var str = "url(" + icon + ")";
               cell.style.backgroundImage = str;
                cell.style.backgroundSize = "cover";
            } 
            if (i === (parseInt(endRow) * 2) && j === (parseInt(endCol) * 2)) {
                cell.style.backgroundImage = "url('/../pic/yellowflower.jpg')";
                cell.style.backgroundSize = "cover";
            }
            x++;
        }

        // add the row to the end of the table body
        tblBody.appendChild(row);
    }

    // put the <tbody> in the <table>
    tbl.appendChild(tblBody);
    tbl.style.background="pink";
    tbl.style.borderSpacing="0px";
    tbl.style.width = "500px";
    tbl.style.height = "500px";
    tbl.style.borderSpacing="0px";
    // appends <table> into <body>
    body.appendChild(tbl);
    // sets the border attribute of tbl to 2;
    //tbl.setAttribute("border", "2");
}


