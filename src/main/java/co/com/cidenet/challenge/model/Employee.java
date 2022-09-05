package co.com.cidenet.challenge.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="firstname")
    @NotNull(message = "First name is required")
    @Length(max = 20, message = "The field First Name allows only up to 20 characters")
    @Pattern(regexp = ("^[A-Z ]*$"), message = "Only capital letters allowed")
    private String firstName;

    @Column(name="firstlastname")
    @NotNull(message = "First last name is required")
    @Length(max = 20, message = "The field First Last Name allows only up to 20 characters")
    @Pattern(regexp = ("^[A-Z ]*$"), message = "Only capital letters allowed")
    private String firstLastName;

    @Column(name="secondlastname")
    @NotNull(message = "Second last name is required")
    @Length(max = 20, message = "The field Second Last Name allows only up to 20 characters")
    @Pattern(regexp = ("^[A-Z ]*$"), message = "Only capital letters allowed")
    private String secondLastName;

    @Column(name="othernames")
    @Length(max = 50, message = "This field Other Names allows only up to 50 characters")
    @Pattern(regexp = ("^[A-Z]*$"), message = "Only capital letters allowed")
    private String otherNames;

    @Column(name="country")
    @Pattern(regexp = ("^(?i)\\bCOLOMBIA$|^(?i)UNITED STATES$\\b"), message = "Country must be COLOMBIA or UNITED STATES")
    //Validate to accept only Colombia or United States
    private String country;

    @Column(name="typeofid")
    @Pattern(regexp = ("^(?i)\\bCITIZENSHIP CARD$|" +
                       "^(?i)ALIEN REGISTRATION CARD$|" +
                       "^(?i)PASSPORT$|" +
                       "^(?i)SPECIAL PERMIT$\\b"),
                       message = "Type of ID must be CITIZENSHIP CARD or ALIEN REGISTRATION CARD or PASSPORT or SPECIAL PERMIT")
    private String typeOfId;

    @Column(name="idnumber")
    @Length(max = 20, message = "The field ID Number allows only up to 20 characters")
    @Pattern(regexp = ("^[a-zA-Z\\d\\-]{1,20}$"), message = "The field ID Number accpets only " +
            "alphanumeric characters and -")
    private String idNumber;

    @Column(name="email")
    private String email;

    @Column(name="entrydate")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate entryDate;

    @Column(name="editdate")
    private LocalDate editDate;

    @Column(name="area")
    @Pattern(regexp = ("^(?i)\\bADMINISTRATION$|" +
                       "^(?i)FINANCIAL$|" +
                       "^(?i)PURCHASING$|" +
                       "^(?i)INFRASTRUCTURE$|" +
                       "^(?i)OPERATIONS$|" +
                       "^(?i)HUMAN RESOURCES$|" +
                       "^(?i)MISCELLANEOUS SERVICES$\\b"),
                         message = "Area must be ADMINISTRATION or FINANCIAL or PURCHASING or INFRASTRUCTURE or " +
                                 "OPERATIONS or HUMAN RESOURCES or MISCELLANEOUS SERVICES")
    private String area;

    @Column(name="status")
    private String status = "ACTIVE";

    @Column(name="log")
    private String log = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
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

}
