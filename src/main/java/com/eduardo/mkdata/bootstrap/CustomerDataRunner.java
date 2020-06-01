package com.eduardo.mkdata.bootstrap;

import com.eduardo.mkdata.enums.Person;
import com.eduardo.mkdata.model.Customer;
import com.eduardo.mkdata.model.CustomerGroup;
import com.eduardo.mkdata.repository.CustomerGroupRepository;
import com.eduardo.mkdata.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class CustomerDataRunner implements CommandLineRunner {

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  CustomerGroupRepository customerGroupRepository;

  @Override
  public void run(String... args) throws Exception {

    Customer customer1 = Customer.builder()
        .name("Eduardo Lima")
        .type(Person.FISICA)
        .cpfCnpj("45159756841")
        .rgIe("36152836150")
        .status(true)
        .registerDate("1590494190989")
        .phones(Arrays.asList("19994867732"))
        .build();

    Customer customer2 = Customer.builder()
        .name("Adalberto Afonso")
        .type(Person.FISICA)
        .cpfCnpj("54823851050")
        .rgIe("31654897236")
        .status(true)
        .registerDate("1590494190989")
        .phones(Arrays.asList("19994867755", "19954862145"))
        .build();

    Customer customer3 = Customer.builder()
        .name("Maria Franca")
        .type(Person.JURIDICA)
        .cpfCnpj("46852946732")
        .rgIe("36481259486")
        .status(true)
        .registerDate("1590494190989")
        .phones(Arrays.asList("19994867732", "199879321495"))
        .build();

    CustomerGroup vendedor = CustomerGroup.builder()
        .name("Fornecedor")
        .status(true)
        .build();

    CustomerGroup distribuidor = CustomerGroup.builder()
        .name("Distribuidor")
        .status(true)
        .build();

    CustomerGroup aluguel = CustomerGroup.builder()
        .name("Aluguel")
        .status(true)
        .build();

    vendedor.setCustomers(Arrays.asList(customer1, customer2));
    distribuidor.setCustomers(Arrays.asList(customer3));

    customerGroupRepository.saveAll(Arrays.asList(vendedor, distribuidor, aluguel));

    customer1.setCustomerGroup(vendedor);
    customer2.setCustomerGroup(vendedor);
    customer3.setCustomerGroup(distribuidor);

    customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
  }
}
