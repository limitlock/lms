package com.cafe24.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.lms.domain.RentAndReserve;
import com.cafe24.lms.security.Auth;
import com.cafe24.lms.service.AdminService;

@Auth(value = Auth.Role.ADMIN)
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping({ "", "/rent", "/main" })
	public String main(Model model, @RequestParam(value = "p", required = true, defaultValue = "1") Long page) {
		List<RentAndReserve> list = adminService.findAll(model);
		model.addAttribute("p", page);
		model.addAttribute("list", list);
		return "admin/rent";
	}

	@RequestMapping("/reserve")
	public String board(Model model, @RequestParam(value = "p", required = true, defaultValue = "1") Long page) {
		List<RentAndReserve> list = adminService.findAllReserveList(model);
		model.addAttribute("p", page);
		model.addAttribute("list", list);

		return "admin/reserve";
	}

}