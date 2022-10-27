package com.br.crudspring;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.swing.text.Document;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.crudspring.controllers.CrudController;
import com.br.crudspring.models.EndPoint;
import com.br.crudspring.models.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);

		// ======================== COMO BUSCAR E TRATAR O JSON VIA API  ===============================
		
		/*
		
		String path = EndPoint.LISTA_USUARIO.getUrl();

		Unirest.setTimeouts(0, 0);
		try {

			HttpResponse<String> response = Unirest.get(path).header("X-Mashape-Authorization", "application/json").asString();

			System.out.println(response.getBody());				
			JSONArray jsonArray = new JSONArray(response.getBody());			
			System.out.println(jsonArray);	
			
			
			for (int i = 0; i < jsonArray.length(); i++) {
			    JSONObject jsonObject = jsonArray.getJSONObject(i);
			    int id = jsonObject.getInt("id");
			    int idade = jsonObject.getInt("idade");
			    String nome = jsonObject.getString("nome");
			    System.out.println(id+ " " +nome + " "+idade);
			}
			
			String nome = jsonArray.getJSONObject(0).getString("nome");
			System.out.println("NOme: "+nome);		
			

		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/

	}

}
