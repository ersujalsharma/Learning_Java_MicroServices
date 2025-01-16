package assignment6.staticKeywords;

class StaticClass{
    static int a;
    public StaticClass(){
        a++;
        System.out.println("Constructor a = "+a);
    }
    public void display(){
        System.out.println("Non Static  Method a = "+a);
    }
    public static void display2(){
        System.out.println("Static Method a = "+a);
    }
    static{
        a = (int)Math.pow(2,6);
        System.out.println("Static Block a = "+a);
    }
}

public class Practice {
    // class level method.
    public static void sujal(){
        System.out.println("Sujal");
    }
    public static void main(String[] args) {
        FordWithoutStatic ford1 = new FordWithoutStatic(101,102);
        ford1.display();
        FordWithoutStatic ford2 = new FordWithoutStatic(103,104);
        ford2.display();
        // it stores individually, we need to find sum all of them
        System.out.println("TotalNumber "+(ford1.number+ford2.number));
        // we need a sharable memory where all objects can share the same value.
        // we will use static keyword to share the memory
        Ford ford = new Ford(101,1);
        Ford ford3 = new Ford(102,2);
        ford.display();
        ford3.display();
        System.out.println(Ford.number);
        Practice.sujal();
        Ford valFord = Ford.orderCar(104,5);
        System.out.println(Ford.number);
        valFord.display();
        //
          // static block
//        StaticClass.display2();
        System.out.println( " ---------------CREATED NEW OBJECT---------- ");
        StaticClass staticClass = new StaticClass();
        StaticClass.display2();
        staticClass.display();
        System.out.println( " ---------------CREATED NEW OBJECT 2222---------- ");
        StaticClass staticClass2 = new StaticClass();
        StaticClass.display2();
        staticClass2.display();
        int val = StaticClass.a;
        System.out.println(val);
    }
}
class Ford {
    int modelNo;
    int color;
    public static int number;

    public Ford(int modelNo, int color) {
        this.modelNo = modelNo;
        this.color = color;
        number++;
    }
    // static method.
    public static Ford orderCar(int modelNo, int color) {
        return new Ford(modelNo, color);
    }

    public void display() {
        System.out.println("Model No: " + modelNo + " Color: " + color + " Number: " + number);
    }
}
class FordWithoutStatic{
    int modelNo;
    int color;
    public int number;

    public static FordWithoutStatic orderCar(int modelNo, int color) {
        return new FordWithoutStatic(modelNo, color);
    }

    public FordWithoutStatic(int modelNo, int color) {
        this.modelNo = modelNo;
        this.color = color;
        number++;
    }

    public void display(){
        System.out.println("Model No: "+modelNo+" Color: "+color+" Number: "+number);
    }
}
