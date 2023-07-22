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

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "role", nullable = false)
	private String role;

	@ManyToMany
	@JoinTable(name = "customer_likes", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "recipe_id"))
	private List<RecipeDTO> likedRecipes;

	// Constructors, getters, and setters
	public CustomerDTO() {
		super();
	}

	public CustomerDTO(String name, String email, String password, String role) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public CustomerDTO(Long id, String name, String email, String password, String role, List<RecipeDTO> likedRecipes) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<RecipeDTO> getLikedRecipes() {
		return likedRecipes;
	}

	public void setLikedRecipes(List<RecipeDTO> likedRecipes) {
		this.likedRecipes = likedRecipes;
	}

	@Override
	public String toString() {
		return "CustomerDTO id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + ", likedRecipes=" + likedRecipes + "\n";
	}
}
