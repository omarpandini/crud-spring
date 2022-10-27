package com.br.crudspring.models;

public class Mensagem {
	
	private String status;
	private String descricao;
	
	public String getCodigo() {
		return status;
	}
	public void setCodigo(String status) {
		this.status = status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Mensagem(String status, String descricao) {
		super();
		this.status = status;
		this.descricao = descricao;
	}
	
	

}
