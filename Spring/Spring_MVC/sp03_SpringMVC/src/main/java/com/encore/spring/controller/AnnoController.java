package com.encore.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//<bean name="anno.do" class="com.encore.spring.controller.AnnoController"/> 가 없어진다는 뜻 @Controller
@Controller
public class AnnoController{
	// 마음대로 메소드를 지정하면된다. 제약조건이 없어진셈이다..리턴타입만 ModelAndView로 맞춰준다
	@RequestMapping("anno.do")
	public ModelAndView anno() {
		return new ModelAndView("WEB-INF/views/anno_result.jsp", "info", "Annotation Success!");
	}
}
