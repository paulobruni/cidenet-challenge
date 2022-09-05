package co.com.cidenet.challenge.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class EmployeeResponse {
    private Integer id;
    private String firstName;
    private String firstLastName;
    private String secondLastName;
    private String otherNames;
    private String country;
    private String typeOfId;
    private String idNumber;
    private String email;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate entryDate;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate editDate;
    private String status;
    private String area;
    private String log;

    public EmployeeResponse(Integer id, String firstName, String firstLastName, String secondLastName, String otherNames, String country, String typeOfId, String idNumber, String email, LocalDate entryDate, LocalDate editDate, String status, String area, String log) {
        this.id = id;
        this.firstName = firstName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.otherNames = otherNames;
        this.country = country;
        this.typeOfId = typeOfId;
        this.idNumber = idNumber;
        this.email = email;
        this.entryDate = entryDate;
        this.editDate = editDate;
        this.status = status;
        this.area = area;
        this.log = log;
    }

    public EmployeeResponse() {
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getEditDate() {
        return editDate;
    }

    public void setEditDate(LocalDate editDate) {
        this.editDate = editDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
