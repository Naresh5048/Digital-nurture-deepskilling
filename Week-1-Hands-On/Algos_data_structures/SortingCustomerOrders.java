package com.cts.structures.exercise03;

class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;
    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalPrice() { return totalPrice; }
    @Override
    public String toString() {
        return "Order[" + orderId + " | " + customerName + " | ₹" + totalPrice + "]";
    }
}

class OrderSorter {

    // Bubble Sort Implementation [cite: 42]
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}

public class SortingCustomerOrders {
    public static void main(String[] args) {
        System.out.println("Sorting Systems Validation\n");
        Order[] dynamicOrdersA = {
            new Order("O301", "Naresh", 4500.00),
            new Order("O302", "Suresh", 1200.00),
            new Order("O303", "Ramesh", 9800.00)
        };
        Order[] dynamicOrdersB = dynamicOrdersA.clone();
        System.out.println("Running Bubble Sort Low to High Valuation)");
        OrderSorter.bubbleSort(dynamicOrdersA);
        for (Order o : dynamicOrdersA) System.out.println(o);

        System.out.println("\n Running Quick Sort Low to High Valuation");
        OrderSorter.quickSort(dynamicOrdersB, 0, dynamicOrdersB.length - 1);
        for (Order o : dynamicOrdersB) System.out.println(o);
    }
}