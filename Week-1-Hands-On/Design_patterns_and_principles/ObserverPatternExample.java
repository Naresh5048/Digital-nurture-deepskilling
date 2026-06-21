package com.cts.exercise07_observer;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stockName, double stockPrice);
}

// Stock Interface
interface Stock {
    void registerObserver(Observer o);
    void deregisterObserver(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> clientObservers = new ArrayList<>();
    private String tickerName;
    private double currentPrice;

    public void updateStockValue(String tickerName, double currentPrice) {
        this.tickerName = tickerName;
        this.currentPrice = currentPrice;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        clientObservers.add(o);
    }

    @Override
    public void deregisterObserver(Observer o) {
        clientObservers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : clientObservers) {
            observer.update(tickerName, currentPrice);
        }
    }
}

class MobileApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("[Mobile UI App Notification] " + stockName + " valuation shifted to: ₹" + stockPrice);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("[Web Server Dashboard Data Broadcast] " + stockName + " price locked: ₹" + stockPrice);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        System.out.println(" Observer Pattern Validation ");

        StockMarket indexTicker = new StockMarket();

        Observer personalMobileApp = new MobileApp();
        Observer commercialWebDashboard = new WebApp();

        indexTicker.registerObserver(personalMobileApp);
        indexTicker.registerObserver(commercialWebDashboard);

        System.out.println(" Market Shift Scenario 1 ");
        indexTicker.updateStockValue("INFY", 1420.50);

        System.out.println("\n Market Shift Scenario 2 ");
        indexTicker.deregisterObserver(commercialWebDashboard);
        indexTicker.updateStockValue("TCS", 3890.00);
    }
}