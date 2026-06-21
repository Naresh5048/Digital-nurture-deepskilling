package com.cts.exercise02_factory;

interface Document {
    void open();
    void close();
}

class WordDocument implements Document {
    @Override
    public void open() { 
        System.out.println("Opening MS Word Document (.docx) Processing margins and structural metadata."); 
    }
    @Override
    public void close() { 
        System.out.println("Saving and closing MS Word Document."); 
    }
}

class PdfDocument implements Document {
    @Override
    public void open() { 
        System.out.println("Opening PDF Document Rendering vector formatting layout."); 
    }
    @Override
    public void close() { 
        System.out.println("Closing PDF Document stream safely."); 
    }
}

class ExcelDocument implements Document {
    @Override
    public void open() { 
        System.out.println("Opening Excel Spreadsheet. Loading data cells and grids."); 
    }
    @Override
    public void close() { 
        System.out.println("Recalculating fields and closing Excel spreadsheet."); 
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();

    public void processDocument() {
        Document doc = createDocument();
        doc.open();
        doc.close();
    }
}

class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() { 
        return new WordDocument(); 
    }
}

class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() { 
        return new PdfDocument(); 
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() { 
        return new ExcelDocument(); 
    }
}

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        System.out.println("Running Factory Method Pattern Validation\n");
        DocumentFactory factory;
        System.out.println("Scenario A: Requesting PDF Document");
        factory = new PdfDocumentFactory();
        factory.processDocument();

        System.out.println("\n Scenario B: Requesting Word Document");
        factory = new WordDocumentFactory();
        factory.processDocument();

        System.out.println("\n Scenario C: Requesting Excel Document");
        factory = new ExcelDocumentFactory();
        factory.processDocument();
    }
}