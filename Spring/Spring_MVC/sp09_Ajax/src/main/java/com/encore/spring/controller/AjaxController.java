package com.encore.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encore.spring.domain.Person;

@Controller
public class AjaxController {
	
	@RequestMapping("/") //contextPath로 요청을 한다면...http://127.0.0.1:8888/spring
	public String index() {
		System.out.println("/...calling...");
		return "redirect:index.jsp";
	}
	
	@RequestMapping("synchro")
	public String synchro(Model model) {
		model.addAttribute("info", "와~~~동기통신!!!");
		System.out.println("동기통신...synchro() calling..");
		
		return "synchro_result";
	}
	
	@RequestMapping("asynch")
	public String asynch(Model model) {
		
		System.out.println("비동기통신...asynch() calling..");
		//비지니스 로직 수행된 결과로...Service 호출결과...person객체가 리턴되었다고 가정하자.
		model.addAttribute("person", new Person("아이유","서초동"));
		return "JsonView";
	}
}
