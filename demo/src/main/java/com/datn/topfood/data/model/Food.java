package com.datn.topfood.data.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.ToStringExclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Food extends Base{

	private String name;
	private Double price;
	private String content;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "profile_id")
	private Profile profile;

	@EqualsAndHashCode.Exclude
	@ToStringExclude
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			  name = "food_file", 
			  joinColumns = @JoinColumn(name = "food_id"), 
			  inverseJoinColumns = @JoinColumn(name = "file_id"))
	public Set<File> files;
}
