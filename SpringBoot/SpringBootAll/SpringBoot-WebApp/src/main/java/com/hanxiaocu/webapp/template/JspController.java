package com.hanxiaocu.webapp.template;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/02 2:39 PM
 */
@Controller
@RequestMapping("/jsp")
public class JspController {

	@GetMapping("/map")
	public String index(String name, ModelMap map) {
		map.addAttribute("name", name);
		map.addAttribute("from", "hanxiaocu.cn");
		//模版名称，实际的目录为：src/main/webapp/jsp/index.html
		return "index";
	}

	@GetMapping("/mv")
	public ModelAndView index(String name) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("from", "hanxiaocu.cn");
		//模版名称，实际的目录为：src/main/webapp/jsp/index.html
		mv.setViewName("index");
		return mv;
	}
}
