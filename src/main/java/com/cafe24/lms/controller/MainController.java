package com.cafe24.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.lms.domain.Item;
import com.cafe24.lms.dto.RentDTO;
import com.cafe24.lms.security.Auth;
import com.cafe24.lms.service.MainService;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;

	@RequestMapping("/main")
	public String index(Model model, @RequestParam(value = "p", required = true, defaultValue = "1") Long page) {

		Long startNo = (Long) ((page - 1) * 5);
		List<Item> list = mainService.getList(startNo, model);
		model.addAttribute("list", list);
		model.addAttribute("p",page);

		List<RentDTO> rentList = mainService.getRentList();
		model.addAttribute("rentIdList", rentList);
		return "main/index";
	}

	// 대여
	@Auth
	@RequestMapping(value = "/rent", method = RequestMethod.GET)
	public String rent(@RequestParam("no") Long no, @RequestParam("userNo") Long userNo, Model model) {

		if (!mainService.isChecked(no)) { // 대여된 아이템에 대여 버튼을 눌렀을 경우, 자동적으로 예약한다.
			mainService.insert(no, userNo);
			mainService.modify(no);

			List<RentDTO> list = mainService.getRent(no, userNo);
			model.addAttribute("list", list);

		} else {
			return "redirect:reserve?no=" + no + "&userNo=" + userNo;
		}

		return "main/rent";
	}

	@Auth
	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public String reserve(@RequestParam("no") Long no, @RequestParam("userNo") Long userNo, Model model) {

		mainService.reserveInsert(no, userNo);
		List<RentDTO> list = mainService.getReserve(no, userNo);
		model.addAttribute("list", list);

		return "main/reserve";
	}

}
