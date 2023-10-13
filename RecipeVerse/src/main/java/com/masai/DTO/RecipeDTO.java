package com.masai.DTO;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipes")
public class RecipeDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recipe_name", nullable = false)
    private String recipeName;

    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<IngredientDTO> ingredients;

    @Column(name = "time_taken")
    private int timeTaken;

    @ManyToMany(mappedBy = "likedRecipes", fetch = FetchType.EAGER)
    private List<CustomerDTO> likedByCustomers;


	// Constructors, getters, and setters
	public RecipeDTO() {
		super();
	}

	public RecipeDTO(String recipeName, double price, List<IngredientDTO> ingredients, int timeTaken,
			List<CustomerDTO> likedByCustomers) {
		super();
		this.recipeName = recipeName;
		this.price = price;
		this.ingredients = ingredients;
		this.timeTaken = timeTaken;
		this.likedByCustomers = likedByCustomers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<IngredientDTO> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientDTO> ingredients) {
		this.ingredients = ingredients;
	}

	public int getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}

	public List<CustomerDTO> getLikedByCustomers() {
		return likedByCustomers;
	}

	public void setLikedByCustomers(List<CustomerDTO> likedByCustomers) {
		this.likedByCustomers = likedByCustomers;
	}

	@Override
	public String toString() {
		return "RecipeDTO id=" + id + ", recipeName=" + recipeName + ", price=" + price + ", ingredients=" + ingredients
				+ ", timeTaken=" + timeTaken + ", likedByCustomers=" + likedByCustomers + "\n";
	}

}
