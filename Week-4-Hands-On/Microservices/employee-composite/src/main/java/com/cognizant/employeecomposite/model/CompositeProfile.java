package com.cognizant.employeecomposite.model;

public class CompositeProfile {
    private String employeeName;
    private String matchedCountryCode;
    private String countryNameName;
    private int sourceExchangePort;

    public CompositeProfile(String employeeName, String matchedCountryCode, String countryNameName, int sourceExchangePort) {
        this.employeeName = employeeName;
        this.matchedCountryCode = matchedCountryCode;
        this.countryNameName = countryNameName;
        this.sourceExchangePort = sourceExchangePort;
    }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
    public String getMatchedCountryCode() { return matchedCountryCode; }
    public void setMatchedCountryCode(String matchedCountryCode) { this.matchedCountryCode = matchedCountryCode; }
    public String getCountryNameName() { return countryNameName; }
    public void setCountryNameName(String countryNameName) { this.countryNameName = countryNameName; }
    public int getSourceExchangePort() { return sourceExchangePort; }
    public void setSourceExchangePort(int sourceExchangePort) { this.sourceExchangePort = sourceExchangePort; }
}