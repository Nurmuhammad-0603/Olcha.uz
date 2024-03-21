package model;

import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
@ToString
public class Product {
    private String name;
    private LocalDate date;
    private double prise;
    private boolean isChegirma;
    private double chegira_prise;

    public Product(String name, LocalDate date, double prise, boolean isChegirma, double chegira_prise) {
        this.name = name;
        this.date = date;
        this.prise = prise;
        this.isChegirma = isChegirma;
        this.chegira_prise = chegira_prise;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    public boolean isChegirma() {
        return isChegirma;
    }

    public void setChegirma(boolean chegirma) {
        isChegirma = chegirma;
    }

    public double getChegira_prise() {
        return chegira_prise;
    }

    public void setChegira_prise(double chegira_prise) {
        this.chegira_prise = chegira_prise;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
