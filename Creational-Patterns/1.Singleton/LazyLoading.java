public class LazyLoading {

    private static LazyLoading instance;

    private LazyLoading() {}

    public static LazyLoading getInstance() {
        if (instance == null) {
            instance = new LazyLoading();
        }
        return instance;
    }
}

class Main {
    public static void main(String[] args) {
        LazyLoading obj1 = LazyLoading.getInstance();
        LazyLoading obj2 = LazyLoading.getInstance();

        System.out.println(obj1);
        System.out.println(obj2);
    }
}