/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$ (function(){
   $('input[type="radio"]').click( function() {
      $("logo").text(this.value);    
});
$('#subscribe').on('submit', function (e) {
  if ($("input[type=radio]:checked").length === 0) {
      e.preventDefault();
      alert('you need to chose logo ');
      return false;
  }
});
});



