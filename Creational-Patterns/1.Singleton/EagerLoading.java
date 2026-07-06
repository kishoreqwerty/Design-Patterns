class EagerLoading {

    private static final EagerLoading instance = new EagerLoading();

    private EagerLoading() {}

    public static EagerLoading getInstance() {
        return instance;
    }
}

class Main {
    public static void main(String[] args) {
        EagerLoading obj1 = EagerLoading.getInstance();
        EagerLoading obj2 = EagerLoading.getInstance();

        System.out.println(obj1);
        System.out.println(obj2);
    }
}
