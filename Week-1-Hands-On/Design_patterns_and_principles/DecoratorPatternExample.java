package com.cts.exercise05_decorator;

interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier { 
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator { 
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlackMessage(message);
    }

    private void sendSlackMessage(String message) {
        System.out.println("Sending Slack Message: " + message);
    }
}

public class DecoratorPatternExample { 
    public static void main(String[] args) {
        System.out.println("=== Decorator Pattern Validation ===");

        System.out.println("--- Core System Channel Only ---");
        Notifier coreChannel = new EmailNotifier();
        coreChannel.send("Server Deployment Initiated.");

        System.out.println("\n Hybrid Multi-Channel Stack (Email + SMS) ");
        Notifier criticalChannel = new SMSNotifierDecorator(new EmailNotifier());
        criticalChannel.send("Database Overheated Immediate intervention required.");

        System.out.println("\n Omnichannel Stack (Email + SMS + Slack) ");
        Notifier enterpriseChannel = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        enterpriseChannel.send("Monthly revenue metrics calculated successfully.");
    }
}