package com.br.crudspring.models;

public enum MensagensSistema {
	
	ERRO_CAMPO_VAZIO("Erro","Erro, campo é obrigatório."),
	ERRO_VALOR_NUMERICO("Erro","Erro, campo deve ser numérico."),
	INFORMACAO_INSERIDA("Sucesso","Informações salvas com sucesso."),
	DELETE_OK("Sucesso","Registro excluído com sucesso.")
	;

	private String status;

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private MensagensSistema(String status, String descricao) {
		this.status = status;
		this.descricao = descricao;
	}
	
	
	public Mensagem retornaMensagem() {
		return new Mensagem(this.getStatus(), this.getDescricao());		
	}
	

}
