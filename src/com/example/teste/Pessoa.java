package com.example.teste;

import java.util.ArrayList;

public class Pessoa {
	public static ArrayList<Pessoa>listaPessoa = new ArrayList<Pessoa>();
	
	private int id;
	private String nome;
	private String telefone;
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getTelefone(){
		return this.telefone;
	}
}
