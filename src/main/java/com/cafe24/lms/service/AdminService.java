package com.cafe24.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.cafe24.lms.domain.RentAndReserve;
import com.cafe24.lms.repository.AdminRepository;

@Service
@Transactional
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;

	public List<RentAndReserve> findAll(Model model) {
		PageRequest pageRequest = new PageRequest(0, 5);
		Long maxNo = adminRepository.rentCount(0L);
		Page<RentAndReserve> result = adminRepository.findAllByUserIndexEqualsByPage(0L, pageRequest);

		List<RentAndReserve> list = result.getContent();
		System.out.println(list);

		int totalPage = result.getTotalPages();
		boolean prevPage = result.hasPrevious();
		boolean nextPage = result.hasNext();
		int curPage = result.getNumber();

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("prevPage", prevPage);
		model.addAttribute("nextPage", nextPage);
		model.addAttribute("curPage", curPage);
		model.addAttribute("maxNo", maxNo);
		return list;

	}

	public List<RentAndReserve> findAllReserveList(Model model) {

		PageRequest pageRequest = new PageRequest(0, 5);
		Long maxNo = adminRepository.reserveCount(0L);
		Page<RentAndReserve> result = adminRepository.findAllByUserIndexGreaterthanByPage(0L, pageRequest);

		List<RentAndReserve> list = result.getContent();
		System.out.println(list);

		int totalPage = result.getTotalPages();
		boolean prevPage = result.hasPrevious();
		boolean nextPage = result.hasNext();
		int curPage = result.getNumber();

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("prevPage", prevPage);
		model.addAttribute("nextPage", nextPage);
		model.addAttribute("curPage", curPage);
		model.addAttribute("maxNo", maxNo);
		return list;

	}

}
