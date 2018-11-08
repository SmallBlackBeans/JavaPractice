package com.hanxiaocu.webapp.template;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/02 2:09 PM
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

	@GetMapping("/map")
	public String index(String name, ModelMap map) {
		map.addAttribute("name",name);
		map.addAttribute("from","hanxiaocu.cn");
		//模版名称，实际的目录为：src/main/resources/templates/freemarker.html
		return "freemarker";
	}


	@GetMapping("/mv")
	public ModelAndView index(String name) {
		ModelAndView mv =  new ModelAndView();
		mv.addObject("name",name);
		mv.addObject("from","hanxiaocu.cn");
		mv.setViewName("freemarker");
		return mv;
	}


}
