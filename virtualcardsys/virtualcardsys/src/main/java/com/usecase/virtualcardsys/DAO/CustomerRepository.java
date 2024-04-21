package com.usecase.virtualcardsys.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usecase.virtualcardsys.model.CustomerRegistration;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerRegistration,String>{
	@Query("SELECT c FROM CustomerRegistration c WHERE c.Username = :username AND c.Password = :password")
	CustomerRegistration findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}

	