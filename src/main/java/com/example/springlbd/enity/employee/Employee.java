package com.example.springlbd.enity.employee;

import com.example.springlbd.enity.contract.Contract;
import com.example.springlbd.enity.office.Office;

import javax.persistence.*;


@Entity
public class Employee {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String personalIdentityNumber;
    private String identityCardNumber;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name="contract_id", nullable=false,foreignKey =@ForeignKey(name = "foreignKeyContract"))
    private Contract contract;

    @ManyToOne
    @JoinColumn(name="office_id", nullable=false,foreignKey =@ForeignKey(name = "foreignKeyOffice"))
    private Office office;

    public Employee(Long id, String firstName, String lastName, String personalIdentityNumber, String identityCardNumber, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalIdentityNumber = personalIdentityNumber;
        this.identityCardNumber = identityCardNumber;
        this.phoneNumber = phoneNumber;
    }

    public Employee(String firstName, String lastName, String personalIdentityNumber, String identityCardNumber, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalIdentityNumber = personalIdentityNumber;
        this.identityCardNumber = identityCardNumber;
        this.phoneNumber = phoneNumber;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalIdentityNumber() {
        return personalIdentityNumber;
    }

    public void setPersonalIdentityNumber(String personalIdentityNumber) {
        this.personalIdentityNumber = personalIdentityNumber;
    }

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
