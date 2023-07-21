package com.masai.DTO;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class CustomerDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = false)
	private String email;

	@ManyToMany
	@JoinTable(name = "customer_likes", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "recipe_id"))
	private List<RecipeDTO> likedRecipes;

	// Constructors, getters, and setters
	public CustomerDTO() {
		super();
	}

	public CustomerDTO(Long id, String name, String email, List<RecipeDTO> likedRecipes) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.likedRecipes = likedRecipes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<RecipeDTO> getLikedRecipes() {
		return likedRecipes;
	}

	public void setLikedRecipes(List<RecipeDTO> likedRecipes) {
		this.likedRecipes = likedRecipes;
	}

	@Override
	public String toString() {
		return "CustomerDTO id=" + id + ", name=" + name + ", email=" + email + ", likedRecipes=" + likedRecipes + "\n";
	}

}
