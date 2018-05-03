package com.cafe24.lms.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cafe24.lms.domain.Item;

public interface MainRepository extends JpaRepository<Item, Long> {
	List<Item> findAll();
	
	Item findOne(Long id);

	@Query("select i from Item i where i.id > :page")
	Page<Item> findAllByPage(@Param("page") Long page, Pageable pageable);

	@Modifying
	@Query(value = "update Item i set i.isRent = true where i.id=:id", nativeQuery = false)
	void modify(@Param("id") Long id);

	

	
}
