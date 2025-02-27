package com.cdexample;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Entity
@Table(name="cd")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING,name="cd-type")
@DiscriminatorValue("CD")

public class CD {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
String title;
String author;
Date purchaseDate;
double cost;
public CD()
{
	
}
public CD(String title, String author, Date purchaseDate, double cost) {
	super();
	this.title = title;
	this.author = author;
	this.purchaseDate = purchaseDate;
	this.cost = cost;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public Date getPurchaseDate() {
	return purchaseDate;
}
public void setPurchaseDate(Date purchaseDate) {
	this.purchaseDate = purchaseDate;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}


}
