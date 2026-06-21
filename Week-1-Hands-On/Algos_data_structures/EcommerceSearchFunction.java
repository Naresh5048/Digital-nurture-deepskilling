package com.cts.structures.exercise02;

import java.util.Arrays;
import java.util.Comparator;

class Product implements Comparable<Product> {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    @Override
    public int compareTo(Product other) {
        return this.productName.compareTo(other.productName);
    }
    @Override
    public String toString() {
        return "[" + productId + " | " + productName + " | " + category + "]";
    }
}

class SearchEngine {
    public static int linearSearch(Product[] list, String targetName) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].getProductName().equalsIgnoreCase(targetName)) {
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(Product[] sortedList, String targetName) {
        int low = 0;
        int high = sortedList.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = sortedList[mid].getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

public class EcommerceSearchFunction {
    public static void main(String[] args) {
        System.out.println("=== Search Function Performance Test ===\n");

        Product[] items = {
            new Product("E10", "Wireless Mouse", "Electronics"),
            new Product("E40", "Mechanical Keyboard", "Electronics"),
            new Product("E20", "Gaming Monitor", "Electronics"),
            new Product("E30", "Bluetooth Speaker", "Audio")
        };
        System.out.println(" 1. Linear Search Execution");
        int indexLS = SearchEngine.linearSearch(items, "Gaming Monitor");
        System.out.println("Linear Search Result: " + (indexLS != -1 ? "Found item at index " + indexLS : "Not Found"));

        System.out.println("\n 2. Binary Search Execution (Sorting Catalog First) ---");
        Arrays.sort(items); Binary search requires data sorted by key [cite: 28]
        System.out.println("Sorted Catalog: " + Arrays.toString(items));
        
        int indexBS = SearchEngine.binarySearch(items, "Gaming Monitor");
        System.out.println("Binary Search Result: " + (indexBS != -1 ? "Found item at index " + indexBS : "Not Found"));
    }
}