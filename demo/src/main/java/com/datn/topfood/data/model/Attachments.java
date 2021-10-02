package com.datn.topfood.data.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Attachments extends Base{

	private String fileUrl;
	
	@ManyToOne
	@JoinColumn(name = "messages_id")
	private Messages messages;
}
