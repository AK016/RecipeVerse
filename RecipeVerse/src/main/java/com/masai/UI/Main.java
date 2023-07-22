package com.masai.UI;

import java.util.Scanner;

import com.masai.DAO.UserDAOImpl;
import com.masai.DTO.CustomerDTO;
import com.masai.services.CustomerService;
import com.masai.services.CustomerServiceImpl;

public class Main {
	private static CustomerService customerService = new CustomerServiceImpl(new UserDAOImpl());
	private static Scanner scanner = new Scanner(System.in);

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
				scanner.nextLine(); // Consume the newline character

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
        System.out.print("Enter Email: "); // Add prompt for the email
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
			System.out.println("5. Go back to Main Menu"); 
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
				System.out.println("Going back to Main Menu...");
				return; // Return to Main Menu

			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}

	private static void customerMenu() {
		while (true) {
			System.out.println("Welcome, Customer!");
			System.out.println("1. View Recipe by ID");
			System.out.println("2. Like Recipe");
			System.out.println("3. View Liked Recipes");
			System.out.println("4. Go back to Main Menu"); // Option to go back to Main Menu
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

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
			// Return to Main Menu

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
        scanner.nextLine(); // Consume the newline character

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

	private static void addRecipe() {
		// Implement adding a recipe from DAO layer
		// ...
	}

	private static void viewRecipeById() {
		// Implement viewing a recipe by ID from DAO layer
		// ...
	}

	private static void deleteRecipeById() {
		// Implement deleting a recipe by ID from DAO layer
		// ...
	}

	private static void updateRecipeIngredients() {
		// Implement updating recipe ingredients from DAO layer
		// ...
	}

	private static void likeRecipe() {
		// Implement liking a recipe by a customer from DAO layer
		// ...
	}

	private static void viewLikedRecipes() {
		// Implement viewing liked recipes by a customer from DAO layer
		// ...
	}
}
