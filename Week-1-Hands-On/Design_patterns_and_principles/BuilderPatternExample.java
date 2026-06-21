package com.cts.exercise03_builder;

class Computer {
    private String CPU;
    private String RAM;
    private String Storage;
    private boolean isGraphicsCardEnabled;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
    }
    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return Storage; }
    public boolean isGraphicsCardEnabled() { return isGraphicsCardEnabled; }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + Storage + ", GraphicsCard=" + isGraphicsCardEnabled + "]";
    }
        static class Builder {
        private String CPU;
        private String RAM;
        private String Storage;
        private boolean isGraphicsCardEnabled;
        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }
        public Builder setRAM(String RAM) {
            this.RAM = builder.RAM;
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String Storage) {
            this.Storage = Storage;
            return this;
        }
        public Builder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {
        System.out.println("Builder Pattern Validation");

        Computer basicComputer = new Computer.Builder()
                .setCPU("Intel i3")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .build();
        Computer gamingComputer = new Computer.Builder()
                .setCPU("AMD Ryzen 7")
                .setRAM("32GB")
                .setStorage("1TB NVMe SSD")
                .setGraphicsCardEnabled(true)
                .build();
        System.out.println("Basic Config: " + basicComputer);
        System.out.println("Gaming Config: " + gamingComputer);
    }
}