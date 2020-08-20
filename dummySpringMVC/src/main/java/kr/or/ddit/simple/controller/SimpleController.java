package kr.or.ddit.simple.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.simple.service.SimpleService;
import kr.or.ddit.simple.vo.SimpleVO;

@Controller
@RequestMapping("/simple.do")
public class SimpleController {
	
	private SimpleService service;
	@Inject
	public SimpleController(SimpleService service) {
		super();
		this.service = service;
	}

//	@RequestMapping(value="/simple.do", method = RequestMethod.GET)
	@GetMapping
	public String form() {
		return "simple/simpleForm";
	}
	
//	@RequestMapping(value = "/simple.do", method = RequestMethod.POST)
	@PostMapping
//	public String plus(int leftOp, 
//				@RequestParam(required = true) int rightOp, Model model) {
	public String plus(@Valid @ModelAttribute("simple") SimpleVO simple, Errors errors ) {
		if(!errors.hasErrors()) {
			service.plus(simple);
		}
//		model.addAttribute("result", result);
		return "simple/simpleForm";
	}
}

















