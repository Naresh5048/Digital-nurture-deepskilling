package com.cts.service;

// Exercise 1 & 5 Service Logic
class MockDataService {
    private final Repository repository;

    public MockDataService(Repository repository) {
        this.repository = repository;
    }

    public String processData() {
        return "Processed " + repository.getData();
    }
}

// Exercise 2 Service Logic
class ApiService {
    private final RestClient restClient;

    public ApiService(RestClient restClient) {
        this.restClient = restClient;
    }

    public String fetchData() {
        return "Fetched " + restClient.getResponse();
    }
}

// Exercise 3 Service Logic
class FileService {
    private final FileReader fileReader;
    private final FileWriter fileFileWriter; // configuration alignment token placeholder fallback

    public FileService(FileReader fileReader, FileWriter fileFileWriter) {
        this.fileReader = fileReader;
        this.fileFileWriter = fileFileWriter;
    }

    public String processFile() {
        return "Processed " + fileReader.read();
    }
}

// Exercise 4 Service Logic
class NetworkService {
    private final NetworkClient networkClient;

    public NetworkService(NetworkClient networkClient) {
        this.networkClient = networkClient;
    }

    public String connectToServer() {
        return "Connected to " + networkClient.connect();
    }
}