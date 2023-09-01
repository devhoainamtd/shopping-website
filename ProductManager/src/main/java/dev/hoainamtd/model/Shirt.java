package dev.hoainamtd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shirts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shirt extends Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Shirt(String productName, String madeIn, String url, float price, Long id, List<ShirtDetail> shirtDetailList) {
        super(productName, madeIn, url, price);
        this.id = id;
        this.shirtDetailList = shirtDetailList;
    }

    @OneToMany(mappedBy = "shirt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShirtDetail> shirtDetailList = new ArrayList<>();
}
