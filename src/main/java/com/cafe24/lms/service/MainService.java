package com.cafe24.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.cafe24.lms.domain.Item;
import com.cafe24.lms.domain.RentAndReserve;
import com.cafe24.lms.dto.RentDTO;
import com.cafe24.lms.repository.MainRepository;
import com.cafe24.lms.repository.RentAndReserveRepository;

@Service
@Transactional
public class MainService {

	@Autowired
	private MainRepository mainRepository;

	@Autowired
	private RentAndReserveRepository rentAndReserveRepository;

	public List<Item> getList() {
		return mainRepository.findAll();

	}

	public List<RentDTO> getRent(Long no, Long userNo) {

		return rentAndReserveRepository.findByNoAndUserNo(no, userNo);
	}

	public List<Item> getList(Long page, Model model) {

		PageRequest pageRequest = new PageRequest(0, 5);
		Page<Item> result = mainRepository.findAllByPage(page, pageRequest);
		Long maxNo = mainRepository.count();

		List<Item> list = result.getContent();
		model.addAttribute("maxNo", maxNo);
		return list;

	}

	public void insert(Long itemNo, Long userNo) {
		rentAndReserveRepository.save(itemNo, userNo);

	}

	public void modify(Long itemNo) {
		mainRepository.modify(itemNo);

	}

	public boolean isChecked(Long no) {
		Item item = mainRepository.findOne(no);

		if (item.isRent()) {
			return true;
		}

		return false;
	}

	public void reserveInsert(Long itemNo, Long userNo) {

		rentAndReserveRepository.reserveSave(itemNo, userNo);
	}

	public List<RentDTO> getReserve(Long no, Long userNo) {
		
		return rentAndReserveRepository.findByNoAndUserNoForReserve(no, userNo);
	}

	public List<RentDTO> getRentList() {
		
		return rentAndReserveRepository.findAll();
	}

}
