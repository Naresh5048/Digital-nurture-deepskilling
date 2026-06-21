package com.cts.exercise08_strategy;

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Debited" + amount + " smoothly using Credit Card link mapping " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String identityEmail;

    public PayPalPayment(String identityEmail) {
        this.identityEmail = identityEmail;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processed checkout sum of " + amount + " through verified PayPal profile token: " + identityEmail);
    }
}

class PaymentContext {
    private PaymentStrategy methodStrategy;

    public void setPaymentMethod(PaymentStrategy methodStrategy) {
        this.methodStrategy = methodStrategy;
    }

    public void executeCheckout(double amount) {
        if (methodStrategy == null) {
            System.out.println("Checkout execution halted Missing valid routing configuration strategy pointer reference.");
            return;
        }
        methodStrategy.pay(amount);
    }
}

public class StrategyPatternExample {
    public static void main(String[] args) {
        System.out.println("Strategy Pattern Validation ");

        PaymentContext transactionSession = new PaymentContext();

        System.out.println(" Processing Phase A ");
        transactionSession.setPaymentMethod(new CreditCardPayment("4321-8890-1112-4567"));
        transactionSession.executeCheckout(12500.00);

        System.out.println("\nProcessing Phase B");
        transactionSession.setPaymentMethod(new PayPalPayment("naresh.ch@student.lbrce.in"));
        transactionSession.executeCheckout(89.99);
    }
}