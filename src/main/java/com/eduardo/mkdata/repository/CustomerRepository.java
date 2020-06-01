package com.eduardo.mkdata.repository;


import com.eduardo.mkdata.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

  @RestResource(path="searchByCpfCnpj", rel="searchByCpfCnpj")
  List<Customer> findCustomerByCpfCnpj(@Param("cpfCnpj") String cpfCnpj);

  @Query(
      "FROM Customer c WHERE " +
      "(:name IS NULL OR UPPER(c.name) LIKE UPPER(CONCAT('%',:name,'%'))) AND " +
      "(:status IS NULL OR c.status = :status)")
  @RestResource(path="findAnyByNameAndStatus", rel="findAnyByNameAndStatus")
  List<Customer> findCustomerByNameContainsAndStatus (
      @Param("name") String name, @Param("status") Boolean status
  );
}
