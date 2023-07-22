package com.masai.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_likes")
public class CustomerLikesDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private CustomerDTO customer;

    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private RecipeDTO recipe;

    // Constructors, getters, and setters
	public CustomerLikesDTO() {
		super();
	}

	public CustomerLikesDTO(Long id, CustomerDTO customer, RecipeDTO recipe) {
		super();
		this.id = id;
		this.customer = customer;
		this.recipe = recipe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public RecipeDTO getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeDTO recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "CustomerLikesDTO [id=" + id + ", customer=" + customer + ", recipe=" + recipe + "]";
	}

	

	
}
