package com.xmlprojekat.postservice.dto;

import java.util.List;

import javax.persistence.Column;

public class PostDTO {
	private Long id;
	private String text;
	private String imageLink;
	private int numOfLikes;
	private int numOfDislikes;
	private List<String> links;
}
