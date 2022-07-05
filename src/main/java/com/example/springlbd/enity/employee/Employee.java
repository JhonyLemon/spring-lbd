package com.example.springlbd.enity.employee;

public class Employee {

    Long id;
    String imię;
    String nazwisko;
    String pesel;
    String numerDowoduOsobistego;
    String telefon;

    public Employee(Long id, String imię, String nazwisko, String pesel, String numerDowoduOsobistego, String telefon) {
        this.id = id;
        this.imię = imię;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.numerDowoduOsobistego = numerDowoduOsobistego;
        this.telefon = telefon;
    }

    public Employee(String imię, String nazwisko, String pesel, String numerDowoduOsobistego, String telefon) {
        this.imię = imię;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.numerDowoduOsobistego = numerDowoduOsobistego;
        this.telefon = telefon;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImię() {
        return imię;
    }

    public void setImię(String imię) {
        this.imię = imię;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNumerDowoduOsobistego() {
        return numerDowoduOsobistego;
    }

    public void setNumerDowoduOsobistego(String numerDowoduOsobistego) {
        this.numerDowoduOsobistego = numerDowoduOsobistego;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", imię='" + imię + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                ", numerDowoduOsobistego='" + numerDowoduOsobistego + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
