function msg(text){
    console.log(text);
}


function salvarUsuario() {
  msg("função");

  var id = $("#id").val();
  var nome = $("#nome").val();
  var idade = $("#idade").val();

  msg("nome " + nome + " idade: " + idade);
  var json;

  if (id === null) {
    json = JSON.stringify({ nome: nome, idade: idade });
  } else {
    json = JSON.stringify({ id: id, nome: nome, idade: idade });
  }

  $("#divMsgSalvar").html("");

  $.ajax({
    type: "POST",
    contentType: "application/json; charset=utf-8",
    url: "salvaUsuario",
    dataType: "json",
    data: json,
    success: function (response) {
      $("#id").val(response.id);
      $("#divMsgSalvar").html(
        '<div style="background-color: green;text-align: center;font-size: 22px;color:white;border-radius: 10px;"><p style="padding: 5px;">Mensagem Salva Com Sucesso</p></div>'
      );
    },
  }).fail(function (xrh, status, errorThrown) {
    alert("Erro ao salvar usuário " + xrh.responseText);
  });
}

function pesquisaUser(){
	
	var nomeBusca = $('#nomeBusca').val();
		
	if(nomeBusca != null && nomeBusca.trim() != '' ){		
		
		  $.ajax({
		    type: "GET",
		    contentType: "application/json; charset=utf-8",
		    url: "buscarPorNome",
		    dataType: "json",
		    data: 'nome='+nomeBusca,
		    success: function (response) {
		      msg(response);
		      
		      msg(response.length);
		      
		      $('#tabelaResultados > tbody > tr').remove();
		      
		      for(var i=0; i < response.length; i++){
				msg(response[i].id);	
					
			    var icon = '<button style="border:0px;" onclick="editarUsuario('+response[i].id+')"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">'+
                           '<path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>'+
                           '<path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>'+
                           '</svg></button>';
			    
				var linha = '<tr>'+
				            '<td>'+response[i].id+'</td>'+
				            '<td>'+response[i].nome+'</td>'+
				            '<td>'+icon+'</td>'+
				            '</tr>';
				            
		        $('#tabelaResultados > tbody').append(linha);
		      }
		      
		    },
		  }).fail(function (xrh, status, errorThrown) {
		    alert("Erro ao buscar usuário " + xrh.responseText);
		  });
		
	}else{
		alert('Informar o nome');
	}
	
	msg('pesquisar '+nomeBusca);
}


function novoUsuario(){
    msg('Novo Usuário');
    $('#id').val('');
    $('#nome').val('');
    $('#idade').val('');
}



function editarUsuario(idUsuario){
  msg('editarUsuario '+idUsuario);	

  $.ajax({
    type: "GET",
    contentType: "application/json; charset=utf-8",
    url: "buscaById",
    dataType: "json",
    data: 'id='+idUsuario,
    success: function (response) {
      msg(response);
       $("#id").val(response.id);
       $("#nome").val(response.nome);
       $("#idade").val(response.idade);
       
       $('#modalPesquisaUser').modal('hide');
       
    },
  }).fail(function (xrh, status, errorThrown) {
    alert("Erro ao salvar usuário " + xrh.responseText);
  });
}