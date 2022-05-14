package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="designation_table")
public class Designation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String designationName;
	String designationDescription;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDesignationName() {
		return designationName;
	}
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	public String getDesignationDescription() {
		return designationDescription;
	}
	public void setDesignationDescription(String designationDescription) {
		this.designationDescription = designationDescription;
	}
	@Override
	public String toString() {
		return "Designation [id=" + id + ", designationName=" + designationName + ", designationDescription="
				+ designationDescription + "]";
	}	
	
}
