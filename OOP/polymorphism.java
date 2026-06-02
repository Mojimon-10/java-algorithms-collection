// Superclass
class Animal 
{
    public void animalSound() 
    {
        System.out.println("The animal makes a sound");
    }
}

// Subclass 1
class Pig extends Animal 
{
    @Override
    public void animalSound() 
    {
        System.out.println("The pig says: wee wee");
    }
}

// Subclass 2
class Dog extends Animal 
{
    @Override
    public void animalSound() 
    {
        System.out.println("The dog says: bow wow");
    }
}

public class polymorphism 
{
    public static void main(String[] args) 
    {
        Animal myAnimal = new Animal();  // Create a generic Animal object
        Animal myPig = new Pig();        // Create a Pig object (polymorphism)
        Animal myDog = new Dog();        // Create a Dog object (polymorphism)

        myAnimal.animalSound();
        myPig.animalSound();             // Runs the Pig's version of the method
        myDog.animalSound();             // Runs the Dog's version of the method
    }
}