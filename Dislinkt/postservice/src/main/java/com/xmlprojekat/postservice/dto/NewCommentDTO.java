package com.xmlprojekat.postservice.dto;

import javax.persistence.Column;

public class NewCommentDTO {
	private Long id;
	private String text;
	private Long idPost;
	//ne treba id usera, zato sto ako znamo post onda znamo i usera
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getIdPost() {
		return idPost;
	}
	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}
	
	public NewCommentDTO() {}
	public NewCommentDTO(Long id, String text, Long idPost) {
		super();
		this.id = id;
		this.text = text;
		this.idPost = idPost;
	}
	
}
