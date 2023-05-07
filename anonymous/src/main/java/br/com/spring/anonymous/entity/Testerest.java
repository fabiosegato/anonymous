package br.com.spring.anonymous.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TESTE_REST")
public class Testerest {
	

	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	public void setId(String name) {
		this.name = name;
	}

}
