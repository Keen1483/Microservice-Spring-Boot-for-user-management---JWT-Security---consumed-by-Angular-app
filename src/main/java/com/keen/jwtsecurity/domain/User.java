package com.keen.jwtsecurity.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

// @JsonIgnoreProperties(value = {"id"})
@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class User {
	@Id @GeneratedValue(strategy=AUTO)
	private Long id;
	
	private String name;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@ManyToMany(fetch = EAGER)
	private Collection<Role> roles = new ArrayList<>();
}
