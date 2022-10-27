package com.br.crudspring.models;

public enum EndPoint {
	
	LISTA_USUARIO("http://localhost:8000/listaUsuarios");
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private EndPoint(String url) {
		this.url = url;
	}
	
	

}
