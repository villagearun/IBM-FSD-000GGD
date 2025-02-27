package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Incredient {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private int amount;
private String description;

@ManyToOne
@JoinTable(name = "receipe_incredient", joinColumns = @JoinColumn(name = "incredient_id"),
inverseJoinColumns = @JoinColumn(name = "receipe_id"))

private Receipe receipe ;


public Incredient(int amount, String description) {
	super();
	this.amount = amount;
	this.description = description;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Receipe getReceipe() {
	return receipe;
}

public void setReceipe(Receipe receipe) {
	this.receipe = receipe;
}


}
