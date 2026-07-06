interface PaymentMethod {
    void pay();
}

class CreditCardPayment implements PaymentMethod {

    @Override
    public void pay() {
        System.out.println("Processing payment using Credit Card");
    }
}

class DebitCardPayment implements PaymentMethod {

    @Override
    public void pay() {
        System.out.println("Processing payment using Debit Card");
    }
}

class UpiPayment implements PaymentMethod {

    @Override
    public void pay() {
        System.out.println("Processing payment using UPI");
    }
}

class PaymentFactory {

    public static PaymentMethod getPaymentMethod(String method) {

        if (method.equalsIgnoreCase("CreditCard")) {
            return new CreditCardPayment();
        } else if (method.equalsIgnoreCase("DebitCard")) {
            return new DebitCardPayment();
        } else if (method.equalsIgnoreCase("UPI")) {
            return new UpiPayment();
        }

        throw new IllegalArgumentException("Invalid payment method: " + method);
    }
}

class PaymentService {

    public void processPayment(String method) {

        PaymentMethod payment = PaymentFactory.getPaymentMethod(method);
        payment.pay();
    }
}

class Main {

    public static void main(String[] args) {

        PaymentService service = new PaymentService();

        service.processPayment("CreditCard");
        service.processPayment("DebitCard");
        service.processPayment("UPI");
    }
}