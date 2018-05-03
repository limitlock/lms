package com.cafe24.lms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cafe24.lms.domain.RentAndReserve;
import com.cafe24.lms.domain.RentAndReserveId;

public interface AdminRepository extends JpaRepository<RentAndReserve, RentAndReserveId> {

	// List<RentAndReserve> findAllByUserIndexEqualsByOrderByReturnDateDesc(long l);

	@Query("select r from RentAndReserve r where r.userIndex = :userIndex order by r.returnDate desc")
	Page<RentAndReserve> findAllByUserIndexEqualsByPage(@Param("userIndex") Long userIndex, Pageable pageable);

	@Query("select r from RentAndReserve r where r.userIndex > :userIndex order by r.returnDate desc")
	Page<RentAndReserve> findAllByUserIndexGreaterthanByPage(@Param("userIndex") Long userIndex, Pageable pageable);

	@Query("select count(r) from RentAndReserve r where r.userIndex = :userIndex")
	Long rentCount(@Param("userIndex") Long userIndex);
	
	@Query("select count(r) from RentAndReserve r where r.userIndex > :userIndex")
	Long reserveCount(@Param("userIndex") Long userIndex);

}
