package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Receipe {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String cookTime;
private String description;
private String difficulty;
private String prepTime;
private String servings;
private String source;
private String url;

@ManyToOne
@JoinTable(name = "receipe_notes", joinColumns = @JoinColumn(name = "receipe_id"),
inverseJoinColumns = @JoinColumn(name = "notes_id"))
private Notes notes;
@OneToMany(mappedBy="receipe",cascade = CascadeType.ALL)
private Set<Incredient> ing=new HashSet<Incredient>();



public Set<Incredient> getIng() {
	return ing;
}

public void setIng(Set<Incredient> ing) {
	this.ing = ing;
}

public Receipe() {
	super();
	// TODO Auto-generated constructor stub
}

public Receipe(String cookTime, String description, String difficulty, String prepTime, String servings, String source,
		String url) {
	super();
	this.cookTime = cookTime;
	this.description = description;
	this.difficulty = difficulty;
	this.prepTime = prepTime;
	this.servings = servings;
	this.source = source;
	this.url = url;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getCookTime() {
	return cookTime;
}

public void setCookTime(String cookTime) {
	this.cookTime = cookTime;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getDifficulty() {
	return difficulty;
}

public void setDifficulty(String difficulty) {
	this.difficulty = difficulty;
}

public String getPrepTime() {
	return prepTime;
}

public void setPrepTime(String prepTime) {
	this.prepTime = prepTime;
}

public String getServings() {
	return servings;
}

public void setServings(String servings) {
	this.servings = servings;
}

public String getSource() {
	return source;
}

public void setSource(String source) {
	this.source = source;
}

public String getUrl() {
	return url;
}

public void setUrl(String url) {
	this.url = url;
}

public Notes getNotes() {
	return notes;
}

public void setNotes(Notes notes) {
	this.notes = notes;
}




}
