package com.cts.service;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public String processDetails(String tag) {
        return externalApi.processDataByTag(tag);
    }

    public void saveSystemRecord(String id) {
        externalApi.updateRecord(id);
    }
}