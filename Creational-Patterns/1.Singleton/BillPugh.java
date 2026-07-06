public class BillPugh {

    private BillPugh() {
    }

    private static class Holder {
        private static final BillPugh INSTANCE = new BillPugh();
    }

    public static BillPugh getInstance() {
        return Holder.INSTANCE;
    }
}

class Main {

    public static void main(String[] args) {

        BillPugh obj1 = BillPugh.getInstance();
        BillPugh obj2 = BillPugh.getInstance();

        System.out.println(obj1);
        System.out.println(obj2);
    }
}