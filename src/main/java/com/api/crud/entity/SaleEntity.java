package com.api.crud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sale")
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sale;
    private String date;
    private double total;

    public Long getId_sale() {
        return id_sale;
    }

    public void setId_sale(Long id_sale) {
        this.id_sale = id_sale;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
