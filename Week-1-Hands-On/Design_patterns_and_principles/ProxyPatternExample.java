package com.cts.exercise06_proxy;

interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Establishing socket connection... Downloading " + filename + " from storage remote node server.");
    }

    @Override
    public void display() {
        System.out.println("Rendering and displaying content of target file: " + filename);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }
    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        } else {
            System.out.println("[Cache Hit] Retrieving metadata and image pixel references locally.");
        }
        realImage.display();
    }
}

public class ProxyImagePatternExample {
    public static void main(String[] args) {
        System.out.println("Proxy Pattern Validation");

        Image profileImage = new ProxyImage("user_profile_hq.png");

        System.out.println("\n Action A: Requesting Image First Time (Triggers Lazy Load) ");
        profileImage.display();

        System.out.println("\n Action B: Requesting Image Second Time (Triggers Cache Access) ---");
        profileImage.display();
    }
}