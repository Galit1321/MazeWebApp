/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD
function Move(direction) {
    $.post("MoveServlet",
            {
                move: direction
            },
            function (data) {
                var cell = document.getElementById(data.Prv);
                cell.style.background = "pink";
                var cell = document.getElementById(data.location);
                cell.style.background = "blue";
                // cell.style.backgroundImage = myImg; 
                // cell.style.opacity="1";
                // cell.style.backgroundSize = "contain";
                //cell.style.borderRadius = "13px";
            });
}
function Clue() {
    $.getJSON('Hint', function (data) {
        var cell = document.getElementById(data.Hint);
        cell.style.background = "white";
    });
}
=======
 
 function Move(evt){
     $(window).keydown(function(evt) {
  if (evt.which == 38) { // up
    $.post("MoveServlet",
                   {
                     move: "up"
                     },
                function(data){
                  var cell = document.getElementById(data.location);
                  cell.style.background = "blue";
                // cell.style.backgroundImage = myImg; 
                 // cell.style.opacity="1";
                 // cell.style.backgroundSize = "contain";
                //cell.style.borderRadius = "13px";
             });
  }
}).keyup(function(evt) {
  if (evt.which == 17) { // ctrl
    ctrlPressed = false;
  }
});




 }


>>>>>>> remotes/origin/stam1

function Reset() {
    $.getJSON('Reset', function (data) {
        var cell = document.getElementById(data.Prv);
        cell.style.background = "pink";
        var start = document.getElementById(data.Start);
        start.style.background = "red";
    });
}
function generate_table(mazeString, size, startRow, startCol, endRow, endCol, icon) {
    // get the reference for the body
    var body = document.getElementsByClassName("Main")[0];
    // var body = document.getElementsByTagName("body")[0];
    // creates a <table> element and a <tbody> element
    var tbl = document.createElement("table");
<<<<<<< HEAD

=======
   
>>>>>>> remotes/origin/stam1
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
<<<<<<< HEAD
            cell.setAttribute('id', (i * parseInt(size) + j));
            row.appendChild(cell);

=======
            cell.setAttribute('id', (i*10 + j));
            row.appendChild(cell);
            
>>>>>>> remotes/origin/stam1
            if (mazeString.charAt(x) === '1') {
                cell.style.background = "purple";
            }
            if ((i === (parseInt(startRow))) && (j === (parseInt(startCol)))) {
<<<<<<< HEAD
                //cell.style.background = "yellow";
=======
               //cell.style.background = "yellow";
>>>>>>> remotes/origin/stam1
                var str = "url(" + icon + ")";
                cell.style.backgroundImage = str;
                cell.style.backgroundSize = "cover";
                //console.log("str");
<<<<<<< HEAD
            }
=======
            } 
>>>>>>> remotes/origin/stam1
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
