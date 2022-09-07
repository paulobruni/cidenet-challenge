package co.com.cidenet.challenge.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class EmployeeRequest {

    private String firstName;
    private String firstLastName;
    private String secondLastName;
    private String otherNames;
    private String country;
    private String typeOfId;
    private String idNumber;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate entryDate;
    private String area;

    public EmployeeRequest() {
    }

    public EmployeeRequest(String firstName, String firstLastName, String secondLastName, String otherNames, String country, String typeOfId, String idNumber, LocalDate entryDate, String area) {
        this.firstName = firstName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.otherNames = otherNames;
        this.country = country;
        this.typeOfId = typeOfId;
        this.idNumber = idNumber;
        this.entryDate = entryDate;
        this.area = area;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTypeOfId() {
        return typeOfId;
    }

    public void setTypeOfId(String typeOfId) {
        this.typeOfId = typeOfId;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "EmployeeRequest{" +
                "firstName='" + firstName + '\'' +
                ", firstLastName='" + firstLastName + '\'' +
                ", secondLastName='" + secondLastName + '\'' +
                ", otherNames='" + otherNames + '\'' +
                ", country='" + country + '\'' +
                ", typeOfId='" + typeOfId + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", entryDate=" + entryDate +
                ", area='" + area + '\'' +
                '}';
    }
}
