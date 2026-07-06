public class SynchronizedMethod {

    private static SynchronizedMethod instance;

    private SynchronizedMethod() {
    }

    public static synchronized SynchronizedMethod getInstance() {
        if (instance == null) {
            instance = new SynchronizedMethod();
        }
        return instance;
    }
}

class Main {

    public static void main(String[] args) {

        SynchronizedMethod obj1 = SynchronizedMethod.getInstance();
        SynchronizedMethod obj2 = SynchronizedMethod.getInstance();

        System.out.println(obj1);
        System.out.println(obj2);
    }
}