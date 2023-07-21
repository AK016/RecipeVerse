package com.masai.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredients")
public class IngredientDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", nullable = false)
    private RecipeDTO recipe;


    // Constructors, getters, and setters
    public IngredientDTO() {
    	super();
    }
    
	public IngredientDTO(Long id, String name, RecipeDTO recipe) {
		super();
		this.id = id;
		this.name = name;
		this.recipe = recipe;
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

	public RecipeDTO getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeDTO recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "IngredientDTO id=" + id + ", name=" + name + ", recipe=" + recipe + "\n";
	}

    
    
}

