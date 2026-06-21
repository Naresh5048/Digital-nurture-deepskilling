package com.cts.structures.exercise06;

import java.util.Arrays;

class Book implements Comparable<Book> {
    private String bookId;
    private String title;
    private String author;
    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
    public String getTitle() { return title; }
    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }
    @Override
    public String toString() {
        return "[" + bookId + " | " + title + " | " + author + "]";
    }
}

class LibrarySearch {

    // Linear Search Implementation [cite: 84]
    public static int linearSearchByTitle(Book[] library, String targetTitle) {
        for (int i = 0; i < library.length; i++) {
            if (library[i].getTitle().equalsIgnoreCase(targetTitle)) {
                return i;
            }
        }
        return -1;
    }
    public static int binarySearchByTitle(Book[] sortedLibrary, String targetTitle) {
        int low = 0;
        int high = sortedLibrary.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = sortedLibrary[mid].getTitle().compareToIgnoreCase(targetTitle);
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

public class LibraryManagementSystem {
    public static void main(String[] args) {
        System.out.println("Library Directory Search System\n");
        Book[] catalog = {
            new Book("B01", "Introduction to Algorithms", "Cormen"),
            new Book("B03", "Clean Code", "Robert Martin"),
            new Book("B02", "Design Patterns", "Gang of Four")
        };
        System.out.println("--- 1. Linear Search Test ---");
        int indexLS = LibrarySearch.linearSearchByTitle(catalog, "Clean Code");
        System.out.println("Linear Search Output Index: " + indexLS);
        System.out.println("\n 2. Binary Search Test");
        Arrays.sort(catalog); Sorting catalog alphabetically by title to meet binary search requirements [cite: 85]
        System.out.println("Sorted Catalog: " + Arrays.toString(catalog));
        int indexBS = LibrarySearch.binarySearchByTitle(catalog, "Clean Code");
        System.out.println("Binary Search Output Index: " + indexBS);
    }
}