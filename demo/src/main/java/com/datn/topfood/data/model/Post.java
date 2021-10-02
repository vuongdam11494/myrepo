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
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringExclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post extends Base{

	private String content;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "profile_id")
	private Profile profile;

	@EqualsAndHashCode.Exclude
	@ToStringExclude
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			  name = "post_reaction", 
			  joinColumns = @JoinColumn(name = "post_id"), 
			  inverseJoinColumns = @JoinColumn(name = "reaction_id"))
	private Set<Reaction> reactions;

	@EqualsAndHashCode.Exclude
	@ToStringExclude
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			  name = "post_file", 
			  joinColumns = @JoinColumn(name = "post_id"), 
			  inverseJoinColumns = @JoinColumn(name = "file_id"))
	private Set<File> files;

	@EqualsAndHashCode.Exclude
	@ToStringExclude
	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	private List<Intereact> intereacts;

	@EqualsAndHashCode.Exclude
	@ToStringExclude
	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	private List<CommentPost> commentPosts;

	@EqualsAndHashCode.Exclude
	@ToStringExclude
	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	private List<Approach> approachs;
}
