package com.usecase.virtualcardsys.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usecase.virtualcardsys.model.VirtualCard;

@Repository
public interface VirtualCardRepository extends JpaRepository<VirtualCard,String>{
	@Query("SELECT v FROM VirtualCard v WHERE v.cardNumber = :cardNumber")
	VirtualCard findByCardNumber(@Param("cardNumber") String cardNumber);
}


