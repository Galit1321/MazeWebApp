/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$ (function(){
   $('input[type="checkbox"]').on('change', function() {
       $('input[name="' + this.name + '"]').not(this).prop('checked', false);
      $("logo").text(this.value);    
});
$('#subscribe').on('submit', function (e) {
  if ($("input[type=checkbox]:checked").length === 0) {
      e.preventDefault();
      alert('you need to chose logo ');
      return false;
  }
});
});



