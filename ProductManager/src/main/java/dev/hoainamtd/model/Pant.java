package dev.hoainamtd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pant extends Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Pant(String productName, String madeIn, String url, float price, Long id, List<PantDetail> pantDetailList) {
        super(productName, madeIn, url, price);
        this.id = id;
        this.pantDetailList = pantDetailList;
    }

    @OneToMany(mappedBy = "pant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PantDetail> pantDetailList = new ArrayList<>();
}
