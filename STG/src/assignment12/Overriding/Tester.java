package assignment12.Overriding;

public class Tester {
    public static void main(String[] args) {
        AnimalBase animal = new AnimalBase();
        animal.eat();
        animal.sound();
//        animal.sleep(); private method can't access
        // dynamic method dispatch tiger
        AnimalBase tiger = new Tiger();
        tiger.eat();
        tiger.sound();
        // dynamic method dispatch Sparrow
        AnimalBase sparrow = new Sparrow();
        sparrow.eat();
        sparrow.sound();
        // dynamic method dispatch Python
        AnimalBase python = new Python();
        python.eat();
        python.sound();
        // python.special();
        // it can't be accessible cause we are taking reference of AnimalBase

        Python python2 = new Python();
        python2.pythonSpecial();

    }
}
