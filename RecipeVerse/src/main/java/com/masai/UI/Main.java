package com.masai.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.DAO.IngredientDAO;
import com.masai.DAO.IngredientDAOImpl;
import com.masai.DAO.UserDAOImpl;
import com.masai.DTO.CustomerDTO;
import com.masai.DTO.IngredientDTO;
import com.masai.DTO.RecipeDTO;
import com.masai.services.CustomerService;
import com.masai.services.CustomerServiceImpl;
import com.masai.services.IngredientService;
import com.masai.services.IngredientServiceImpl;
import com.masai.services.RecipeService;
import com.masai.services.RecipeServiceImpl;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static CustomerService customerService = new CustomerServiceImpl(new UserDAOImpl());
	private static RecipeService recipeService = new RecipeServiceImpl();
	// Create the IngredientDAO
	private static IngredientDAO ingredientDAO = new IngredientDAOImpl();

    // Create the IngredientService with the injected IngredientDAO
	private static IngredientService ingredientService = new IngredientServiceImpl(ingredientDAO);

	
	
	public static void main(String[] args) {
		try {
			while (true) {
				System.out.println("Welcome to Recipe Management System");
				System.out.println("1. Admin Login");
				System.out.println("2. Customer Login");
				System.out.println("3. Sign Up");
				System.out.println("4. Exit");
				System.out.print("Enter your choice: ");
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					adminLogin();
					break;

				case 2:
					customerLogin();
					break;

				case 3:
					signUpUser();
					break;

				case 4:
					System.out.println("Goodbye!");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice. Please try again.");
					break;
				}
			}
		} finally {
			// No need to handle closing EntityManager here since we moved connection parts
			// to DAOImpl layer
		}
	}

	private static void adminLogin() {
		System.out.print("Enter Admin Username: ");
		String adminUsernameInput = scanner.nextLine();
		System.out.print("Enter Admin Password: ");
		String adminPasswordInput = scanner.nextLine();

		if (customerService.login(adminUsernameInput, adminPasswordInput, "admin")) {
			adminMenu();
		} else {
			System.out.println("Invalid admin credentials.");
		}
	}

	private static void signUpUser() {
		System.out.print("Enter Username: ");
		String username = scanner.nextLine();
		System.out.print("Enter Email: ");
		String email = scanner.nextLine();
		System.out.print("Enter Password: ");
		String password = scanner.nextLine();
		System.out.print("Enter Role (admin/customer): ");
		String role = scanner.nextLine();

		// Save the new user to the database
		CustomerDTO newUser = new CustomerDTO(username, email, password, role);

		// Pass the CustomerDTO object to the signUp method
		if (customerService.signUp(newUser)) {
			System.out.println("Sign up successful. You can now log in.");
		} else {
			System.out.println("Sign up failed. Please try again.");
		}
	}

	private static void adminMenu() {
		while (true) {
			System.out.println("Welcome, Admin!");
			System.out.println("1. Add Recipe");
			System.out.println("2. View Recipe by ID");
			System.out.println("3. Delete Recipe by ID");
			System.out.println("4. Update Recipe Ingredients");
			System.out.println("5. View Recipe List");
			System.out.println("6. Go back to Main Menu");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				addRecipe();
				break;

			case 2:
				viewRecipeById();
				break;

			case 3:
				deleteRecipeById();
				break;

			case 4:
				updateRecipeIngredients();
				break;
			case 5:
				getAllRecipes();
				break;
			case 6:
				System.out.println("Going back to Main Menu...");
				return;

			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}

	private static void customerLogin() {
		System.out.println("1. Login");
		System.out.println("2. Sign Up");
		System.out.print("Enter your choice: ");
		int loginOrSignUpChoice = scanner.nextInt();
		scanner.nextLine();

		switch (loginOrSignUpChoice) {
		case 1:
			System.out.print("Enter Customer Username: ");
			String customerUsernameInput = scanner.nextLine();
			System.out.print("Enter Customer Password: ");
			String customerPasswordInput = scanner.nextLine();

			if (customerService.login(customerUsernameInput, customerPasswordInput, "customer")) {
				customerMenu();
			} else {
				System.out.println("Invalid customer credentials.");
			}
			break;

		case 2:
			signUpUser();
			break;

		default:
			System.out.println("Invalid choice. Returning to Main Menu.");
			break;
		}
	}

	private static void customerMenu() {
		while (true) {
			System.out.println("Welcome, Customer!");
			System.out.println("1. View Recipe by ID");
			System.out.println("2. Like Recipe");
			System.out.println("3. View Liked Recipes");
			System.out.println("4. Go back to Main Menu");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				viewRecipeById();
				break;

			case 2:
				likeRecipe();
				break;

			case 3:
				viewLikedRecipes();
				break;

			case 4:
				System.out.println("Going back to Main Menu...");
				return;

			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}

	private static void addRecipe() {
		System.out.print("Enter Recipe Name: ");
		String name = scanner.nextLine();

		System.out.print("Enter Recipe Price: ");
		double price = scanner.nextDouble();
		scanner.nextLine();

		System.out.print("Enter Recipe Ingredients separated by a Space: ");
		String ingredientsInput = scanner.nextLine();
		List<IngredientDTO> ingredients = new ArrayList<>();

		// Split the ingredientsInput string into individual ingredient names
		String[] ingredientNames = ingredientsInput.split(" ");

		// Create and save IngredientDTO objects for each ingredient name
		for (String ingredientName : ingredientNames) {
			IngredientDTO ingredient = new IngredientDTO();
			ingredient.setName(ingredientName);
			ingredient.setQuantity(1.0); 
			ingredientService.saveIngredient(ingredient);
			ingredients.add(ingredient);
		}

		System.out.print("Enter Time Taken to Cook this Recipe: ");
		int timeTaken = scanner.nextInt();
		scanner.nextLine();

		List<CustomerDTO> likes = new ArrayList<>();

		RecipeDTO recipe = new RecipeDTO(name, price, ingredients, timeTaken, likes);
		String s = recipeService.saveRecipe(recipe);
		System.out.println(s);
	}

	private static void viewRecipeById() {
		System.out.print("Enter Recipe ID: ");
		Long recipeId = scanner.nextLong();
		scanner.nextLine();

		// Call the service method to get the recipe by ID
		RecipeDTO recipe = recipeService.getRecipeById(recipeId);

		if (recipe != null) {
			System.out.println("Recipe Details:");
			System.out.println(recipe);
		} else {
			System.out.println("Recipe not found with the given ID.");
		}
	}

	private static void deleteRecipeById() {
		System.out.print("Enter Recipe ID to Delete: ");
		Long recipeId = scanner.nextLong();
		scanner.nextLine();

		// Call the service method to delete the recipe by ID
		recipeService.deleteRecipe(recipeId);
		System.out.println("Recipe with ID " + recipeId + " has been deleted successfully!");
	}

	private static void updateRecipeIngredients() {
		System.out.print("Enter Recipe ID to Update Ingredients: ");
		Long recipeId = scanner.nextLong();
		scanner.nextLine();

		// Call the service method to get the recipe by ID
		RecipeDTO recipe = recipeService.getRecipeById(recipeId);

		if (recipe != null) {
			// Assuming you have a method in RecipeDTO to get the list of ingredients
			List<IngredientDTO> ingredients = recipe.getIngredients();

			if (ingredients != null && !ingredients.isEmpty()) {
				for (IngredientDTO ingredient : ingredients) {
					System.out.print("Enter new quantity for " + ingredient.getName() + ": ");
					double newQuantity = scanner.nextDouble();
					scanner.nextLine();

					// Set the new quantity for the ingredient
					ingredient.setQuantity(newQuantity);
				}

				// Call the service method to update the recipe with new ingredients
				recipeService.updateRecipe(recipe);
				System.out.println("Recipe ingredients updated successfully!");
			} else {
				System.out.println("No ingredients found for the recipe.");
			}
		} else {
			System.out.println("Recipe not found with the given ID.");
		}
	}

	private static void getAllRecipes() {
		List<RecipeDTO> recipes = recipeService.getAllRecipes();
		if (recipes.isEmpty()) {
			System.out.println("No recipes found.");
		} else {
			System.out.println("All Recipes:");
			for (RecipeDTO recipe : recipes) {
				System.out.println(recipe);
			}
		}
	}

	private static void likeRecipe() {
		
	}

	private static void viewLikedRecipes() {
		
	}
}
