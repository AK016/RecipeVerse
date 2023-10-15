-- Create tables
CREATE TABLE Recipe (
  id INTEGER PRIMARY KEY,
  recipe_name VARCHAR(255),
  price DOUBLE,
  time_taken INT
);

CREATE TABLE Ingredient (
  id INTEGER PRIMARY KEY,
  name VARCHAR(255),
  quantity DOUBLE,
  recipe_id INTEGER,
  FOREIGN KEY (recipe_id) REFERENCES Recipe(id)
);

CREATE TABLE Customer (
  id INTEGER PRIMARY KEY,
  name VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(255),
  role VARCHAR(255)
);

-- Insert sample data

-- Recipes
INSERT INTO Recipe (recipe_name, price, time_taken)
VALUES ('Paneer Masala', 250.00, 60);

-- Ingredients
INSERT INTO Ingredient (name, quantity, recipe_id)
VALUES ('Paneer', 200.0, 1);

-- Customers
INSERT INTO Customer (name, email, password, role)
VALUES ('John Doe', 'john@example.com', 'password123', 'customer');

-- CRUD operations

-- Read (Retrieve) Operation
-- Retrieve all recipes
SELECT * FROM Recipe;

-- Retrieve all ingredients for a specific recipe (e.g., Recipe ID 1)
SELECT * FROM Ingredient WHERE recipe_id = 1;

-- Retrieve a specific customer by their ID (e.g., Customer ID 1)
SELECT * FROM Customer WHERE id = 1;

-- Update Operation
-- Update the price of a recipe (e.g., Recipe ID 1)
UPDATE Recipe
SET price = 260.00
WHERE id = 1;

-- Update the quantity of an ingredient (e.g., Ingredient ID 1)
UPDATE Ingredient
SET quantity = 250.0
WHERE id = 1;

-- Delete Operation
-- Delete a recipe and its associated ingredients (e.g., Recipe ID 1)
DELETE FROM Ingredient WHERE recipe_id = 1;
DELETE FROM Recipe WHERE id = 1;

-- Delete a customer by their ID (e.g., Customer ID 1)
DELETE FROM Customer WHERE id = 1;
