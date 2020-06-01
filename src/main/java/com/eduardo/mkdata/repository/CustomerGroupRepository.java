package com.eduardo.mkdata.repository;


import com.eduardo.mkdata.model.CustomerGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "customerGroups", path = "customer-groups")
public interface CustomerGroupRepository extends JpaRepository<CustomerGroup, Integer> {

  @RestResource(path="searchByName", rel="searchByName")
  List<CustomerGroup> findCustomerGroupByName (@Param("name") String name);

  @Query(
      "FROM CustomerGroup cg WHERE" +
      "(:name IS NULL OR UPPER(cg.name) LIKE UPPER(CONCAT('%',:name,'%'))) AND " +
      "(:status IS NULL OR cg.status = :status)"
  )
  @RestResource(path="findAnyByNameAndStatus", rel="findAnyByNameAndStatus")
  List<CustomerGroup> findCustomerGroupsByNameContainsAndStatus (
      @Param("name") String name, @Param("status") Boolean status
  );
}
