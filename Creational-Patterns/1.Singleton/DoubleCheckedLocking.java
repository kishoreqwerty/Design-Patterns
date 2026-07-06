public class DoubleCheckedLocking {

    private static volatile DoubleCheckedLocking instance;

    private DoubleCheckedLocking() {
    }

    public static DoubleCheckedLocking getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLocking();
                }
            }
        }
        return instance;
    }
}

class Main {

    public static void main(String[] args) {

        DoubleCheckedLocking obj1 = DoubleCheckedLocking.getInstance();
        DoubleCheckedLocking obj2 = DoubleCheckedLocking.getInstance();

        System.out.println(obj1);
        System.out.println(obj2);
    }
}