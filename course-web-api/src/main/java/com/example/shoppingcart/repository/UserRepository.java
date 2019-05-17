package com.example.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.shoppingcart.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	List<User> findById(int id);
	
	List<User> findByIndex(String index);
	
	@Transactional
    @Modifying
    @Query(value = "UPDATE `user` SET `NAME` = :name, `PHONENUMBER` = :phoneNumber , `PASSWORD` = :password, `INDEX` = :index WHERE (`ID` = :id)", nativeQuery = true)
	void updateUser(
			@Param("id") int id,
			@Param("name") String name,
			@Param("phoneNumber") String phoneNumber,
			@Param("password") String password,
			@Param("index") String index );
	
	
	
	@Transactional
    @Modifying
    @Query(value = "INSERT INTO `learn-web-db`.`user` ( `NAME`, `PHONENUMBER`, `PASSWORD`, `INDEX`) VALUES (:name, :phoneNumber, :password, :index)", nativeQuery = true)
	void createUser(
			@Param("name") String name,
			@Param("phoneNumber") String phoneNumber,
			@Param("password") String password,
			@Param("index") String index );
}
