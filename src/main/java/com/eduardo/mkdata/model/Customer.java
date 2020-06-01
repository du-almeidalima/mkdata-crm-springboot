package com.eduardo.mkdata.model;


import com.eduardo.mkdata.enums.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Person type;

    private String cpfCnpj;

    private String rgIe;

    private boolean status;

    private String registerDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "customer_phones", joinColumns = @JoinColumn(name = "customer_id"))
    private List<String> phones;

    @ManyToOne()
    private CustomerGroup customerGroup;
}
