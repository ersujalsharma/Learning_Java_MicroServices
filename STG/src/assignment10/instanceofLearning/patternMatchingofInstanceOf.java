package assignment10.instanceofLearning;

public class patternMatchingofInstanceOf {
    public static void main(String[] args) {
        Object obj = "Hello";
        if (obj instanceof String str) {
            System.out.println(str);
        }
    }
}
class Traditional_instanceof {
    public static void main(String[] args) {
        Object obj = "Hello";
        // this will increase the chances of errors.
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println(str);
        }
    }
}