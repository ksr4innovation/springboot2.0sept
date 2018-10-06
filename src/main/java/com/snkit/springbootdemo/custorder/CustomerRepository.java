package com.snkit.springbootdemo.custorder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

	
	List<CustomerEntity> findByName(String name);
	
	List<CustomerEntity> findByNameAndEmail(String ne,String em);	
	
	List<CustomerEntity> findByNameAndEmailAndAddhar(String ne,String em,String adha );
	
	@Query("select cust  from CustomerEntity cust join fetch  cust.orderEntityList olist  "
			+ "    where cust.name =  :inputName  ")
	List<CustomerEntity> getCustEmpDetails(@Param("inputName") String name);
	
	@Query("select cust  from CustomerEntity cust inner join  cust.orderEntityList olist  "
			+ "    where cust.name =  :inputName  ")
	List<CustomerEntity> getCustEmpDetailswithOutJoin(@Param("inputName") String name);
	
}
