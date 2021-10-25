package com.sleepcoders.valhalla.models.dataStorage;


import javax.persistence.*;

@Entity
public class DataStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long Id;

    private int countOfUsers;
    private double totalOfSales;


    public DataStorage() {
    }

    public DataStorage(int countOfUsers, double totalOfSales) {
        this.countOfUsers = countOfUsers;
        this.totalOfSales = totalOfSales;

    }

    public Long getId() {
        return Id;
    }

    public int getCountOfUsers() {
        return countOfUsers;
    }

    public double getTotalOfSales() {
        return totalOfSales;
    }

    public void setCountOfUsers(int num) {
        this.countOfUsers +=num;
    }
    public void setCountOfUsersDec(int num) {
        this.countOfUsers -=num;
    }
    public void setTotalOfSales(double totalOfSales) {
        this.totalOfSales += totalOfSales;
    }

}
