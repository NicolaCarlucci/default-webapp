var macchinaSelezionata = "";
var operatoreSelezionato ="";
$(document).ready(function() {
});


//bottone che seleziona la macchina da collegare
$(".selectionMachine").click(function() {
	macchinaSelezionata = $(this)[0].innerHTML;
	$("#idmacchinaseleziantaCollegata").val(macchinaSelezionata);
	$("#closeModal1").click();
	$("#collegaMacchinaForm").submit();
});

//chisura della modale 
$("#closeModal1").click(function(){
	$("#portfolioModal1").modal('hide');
});

//chisura della modale 
$("#closeModal2").click(function(){
	$("#portfolioModal2").modal('hide');
});


// scollega la macchina
$("#buttonScollegaMacchina").click(function() {
	var macchinaCollegata = $("#idMacchinaCollegata").text();
	$("#idmacchinaseleziantaScollegata").val(macchinaCollegata);
	$("#closeModal1").click();
	$("#scollegaMacchinaForm").submit();
});

//bottone che seleziona l'operatore da collegare
$(".selectionOperatore").click(function() {
	operatoreSelezionato = $(this)[0].innerHTML;
	$("#idoperatoreseleziantaCollegata").val(operatoreSelezionato);
	$("#closeModal2").click();
	$("#collegaOperatoreForm").submit();
});

//scollega l'operatore
$("#buttonScollegaOperatore").click(function() {
	var operatoreCollegato = $("#idOperatoreCollegato").text();
	$("#idoperatoreseleziantaScollegato").val(operatoreCollegato);
	$("#closeModal2").click();
	$("#scollegaOperatoreForm").submit();
});