package com.cafe24.lms.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cafe24.lms.domain.Item;
import com.cafe24.lms.domain.RentAndReserve;
import com.cafe24.lms.domain.RentAndReserveId;
import com.cafe24.lms.domain.User;
import com.cafe24.lms.dto.RentDTO;

@Repository
public class RentAndReserveRepository {
	@PersistenceContext
	private EntityManager em;

	// 대여
	public void save(Long itemNo, Long userNo) {

		Item item = em.find(Item.class, itemNo);
		User user = em.find(User.class, userNo);

		RentAndReserve rentAndReserve = new RentAndReserve();
		rentAndReserve.setItem(item);
		rentAndReserve.setUser(user);


		Date date = new Date();
		String leaseDate = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(date);

		rentAndReserve.setLeaseDate(leaseDate);

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 7);
		String returnDate = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(cal.getTime());

		rentAndReserve.setReturnDate(returnDate);
		rentAndReserve.setUserIndex(0L);
		em.persist(rentAndReserve);
	}

	public List<RentDTO> findByNoAndUserNo(Long no, Long userNo) {

		RentAndReserveId rentAndReserveId = new RentAndReserveId();
		rentAndReserveId.setItem(no);
		rentAndReserveId.setUser(userNo);

		RentAndReserve rentAndReserve = em.find(RentAndReserve.class, rentAndReserveId);

		Item item = rentAndReserve.getItem();
		User user = rentAndReserve.getUser();

		List<RentDTO> list = new ArrayList<RentDTO>();

		RentDTO rentDTO = new RentDTO();

		rentDTO.setEmail(user.getEmail());
		rentDTO.setItem(item);
		rentDTO.setLeaseDate(rentAndReserve.getLeaseDate());
		rentDTO.setReturnDate(rentAndReserve.getReturnDate());

		list.add(rentDTO);

		return list;
	}

	public void reserveSave(Long itemNo, Long userNo) {

		// 저장 테이블
		Item item = em.find(Item.class, itemNo);
		User user = em.find(User.class, userNo);

		RentAndReserve setRentAndReserve = new RentAndReserve();

		setRentAndReserve.setItem(item);
		setRentAndReserve.setUser(user);

		String jpql = "select r from RentAndReserve r where r.item = :item order by r.userIndex desc";
		TypedQuery<RentAndReserve> query = em.createQuery(jpql, RentAndReserve.class);
		query.setParameter("item", item);
		query.setMaxResults(1);
		List<RentAndReserve> list = query.getResultList();

		// 예약일 설정 -> 이미 대여된 아이템의 반납일
		System.out.println(list.get(0).getReturnDate());
		setRentAndReserve.setLeaseDate(list.get(0).getReturnDate());

		// 예약 반납일 설정
		DateFormat dmf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		Date date = null;
		try {
			date = dmf.parse(list.get(0).getReturnDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 7);
		String returnDate = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(cal.getTime());

		setRentAndReserve.setReturnDate(returnDate);

		// 예약 순번
		setRentAndReserve.setUserIndex(list.get(0).getUserIndex() + 1);

		// 저장
		em.persist(setRentAndReserve);

	}

	public List<RentDTO> findByNoAndUserNoForReserve(Long no, Long userNo) {

		RentAndReserveId rentAndReserveId = new RentAndReserveId();
		rentAndReserveId.setItem(no);
		rentAndReserveId.setUser(userNo);

		RentAndReserve rentAndReserve = em.find(RentAndReserve.class, rentAndReserveId);

		Item item = rentAndReserve.getItem();
		User user = rentAndReserve.getUser();

		List<RentDTO> list = new ArrayList<RentDTO>();

		RentDTO rentDTO = new RentDTO();

		rentDTO.setEmail(user.getEmail());
		rentDTO.setItem(item);
		rentDTO.setLeaseDate(rentAndReserve.getLeaseDate());
		rentDTO.setReturnDate(rentAndReserve.getReturnDate());
		rentDTO.setUserIndex(rentAndReserve.getUserIndex());

		list.add(rentDTO);
		return list;
	}

	public List<RentDTO> findAll() {
		String jpql = "select r.item, r.userIndex from RentAndReserve r";
		Query query = em.createQuery(jpql);
		List<Object[]> rows = query.getResultList();

		List<RentDTO> list = new ArrayList<RentDTO>();
		for (Object[] row : rows) {
			RentDTO dto = new RentDTO();
			dto.setItem((Item) row[0]);
			dto.setUserIndex((Long) row[1]);
			list.add(dto);
		}

		for (RentDTO rentDTO : list) {
			System.out.println(rentDTO);
		}

		return list;
	}
}
