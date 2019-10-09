package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table
public class Article implements Serializable {


	private static final long serialVersionUID = -5780629822500942335L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="article_id")
	private long articleid;
	
	@Column(name="article_sourceid")
	private String articlesourceid;
	
	@Column(name="article_title")
	private String articletitle;
	
	@Column(name="article_sysmbols")
	private String articlesymbols;
	
		
}
