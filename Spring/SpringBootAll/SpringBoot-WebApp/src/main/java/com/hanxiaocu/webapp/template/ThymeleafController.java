package com.hanxiaocu.webapp.template;

import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @desc: Thymeleaf 示例
 * @author: hanchenghai
 * @date: 2018/11/02 2:39 PM
 */
@Configuration
@RequestMapping("/thymeleaf")
public class ThymeleafController {
	@GetMapping("/map")
	public String index(String name, ModelMap map) {
		map.addAttribute("name",name);
		map.addAttribute("from","hanxiaocu.cn");
		//模版名称，实际的目录为：src/main/resources/templates/freemarker.html
		return "thymeleaf";
	}


	@GetMapping("/mv")
	public ModelAndView index(String name) {
		ModelAndView mv =  new ModelAndView();
		mv.addObject("name",name);
		mv.addObject("from","hanxiaocu.cn");
		mv.setViewName("thymeleaf");
		return mv;
	}

}
