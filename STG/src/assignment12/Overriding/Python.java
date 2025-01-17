package assignment12.Overriding;

public class Python extends AnimalBase{
    @Override
    public void sound() {
        System.out.println("Python hisses");
    }
    @Override
    public void eat(){
        System.out.println("Python eats rats by swallowing them whole");
    }
    public void pythonSpecial(){
        System.out.println("Python has a special way of eating");
    }
//    @Override
//    protected void roam() {
//        System.out.println("Animal is roaming");
//    }
//    @Override
//    public void roam() {
//        System.out.println("Animal is roaming");
//    }
    // Can't make weaker access privileges
//    @Override
//    void roam() {
//        System.out.println("Animal is roaming");
//    }
//    @Override
//    private void roam() {
//        System.out.println("Animal is roaming");
//    }
}
