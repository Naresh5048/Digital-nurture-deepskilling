package com.cts.exercise04_adapter;

interface PaymentProcessor {
    void processPayment(double amount);
}

class PaytmGateway { // PaytmGateway Adaptee Class
    public void sendPayment(double amountInINR) {
        System.out.println("Processing payment of" + amountInINR + " securely via Paytm Gateway API.");
    }
}

class StripeGateway {
    public void chargeCustomer(double amountInUSD) {
        System.out.println("Charging card for" + amountInUSD + " securely via Stripe API channels.");
    }
}

class PaytmAdapter implements PaymentProcessor { 
    private PaytmGateway paytmGateway;

    public PaytmAdapter(PaytmGateway paytmGateway) {
        this.paytmGateway = paytmGateway;
    }

    @Override
    public void processPayment(double amount) {
        paytmGateway.sendPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.chargeCustomer(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        System.out.println("Adapter Pattern Validation");

        PaymentProcessor paytmProcessor = new PaytmAdapter(new PaytmGateway());
        paytmProcessor.processPayment(1500.00);

        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(45.50);
    }
}