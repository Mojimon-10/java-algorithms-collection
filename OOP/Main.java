// Abstract Class (The incomplete idea)
abstract class Food 
{
    protected String name;
    protected double price;

    // A constructor to set up common data
    public Food(String name, double price) 
    {
        this.name = name;
        this.price = price;
    }

    // Regular Method: Every food displays its price the exact same way
    public void displayMenuLine() 
    {
        System.out.println(name + " costs $" + price);
    }

    // Abstract Method: Every food is prepared differently! 
    // No body {} here, the child classes MUST write the specific code for this.
    public abstract void prepare();
}

// Concrete Subclass 1 (Finishes the idea)
class Burger extends Food 
{
    public Burger(double price)
    {
        super("Classic Burger", price);
    }

    // Overriding and completing the abstract method
    @Override
    public void prepare() 
    {
        System.out.println("Grilling the beef patty and toasting the buns...");
    }
}

// Concrete Subclass 2 (Finishes the idea)
class Salad extends Food 
{
    public Salad(double price) 
    {
        super("Caesar Salad", price);
    }

    // Overriding and completing the abstract method with different logic
    @Override
    public void prepare() 
    {
        System.out.println("Tossing fresh lettuce with Caesar dressing and croutons...");
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        // Line below would cause a COMPILE ERROR: "Food is abstract; cannot be instantiated"
        // Food myFood = new Food("Generic Food", 5.00); 

        // Instead, we create the concrete child objects
        Food lunch1 = new Burger(8.99);
        Food lunch2 = new Salad(6.50);

        // Call the common regular method
        lunch1.displayMenuLine();
        // Call the specific abstract method implementation
        lunch1.prepare(); 

        System.out.println("-----------------------------------");

        lunch2.displayMenuLine();
        lunch2.prepare();
    }
}