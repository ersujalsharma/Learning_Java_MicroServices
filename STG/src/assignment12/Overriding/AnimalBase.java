package assignment12.Overriding;

public class AnimalBase {
    public void sound() {
        System.out.println("Animal is making a sound");
    }
    public void eat() {
        System.out.println("Animal is eating");
    }
    private void sleep() {
        System.out.println("Animal is sleeping");
    }
    protected void roam() {
        System.out.println("Animal is roaming");
    }
}
