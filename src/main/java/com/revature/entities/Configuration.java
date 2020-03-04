package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "configuration")
public class Configuration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "configuration_id")
	@Schema ( example = "1")
	private int configuration_id;
	
	@Column(name = "label")
	@Schema (example = "API_KEY")
	private String label;
	
	@Column(name = "value")
	@Schema (example = "TOTALLYANAPIKEY")
	private String value;

	public Configuration() {
		super();
	}

	public Configuration(int configuration_id, String label, String value) {
		super();
		this.configuration_id = configuration_id;
		this.label = label;
		this.value = value;
	}

	public int getConfiguration_id() {
		return configuration_id;
	}

	public void setConfiguration_id(int configuration_id) {
		this.configuration_id = configuration_id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Configuration [configuration_id=" + configuration_id + ", label=" + label + ", value=" + value + "]";
	}
	
	
	
}
