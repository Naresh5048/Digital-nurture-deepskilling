package com.cts.service;

public interface ExternalApi {
    String getData();
    String processDataByTag(String tag);
    void updateRecord(String recordId);
}