package com.example.demo.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
	@RequestMapping("/viral")

	public String index() {
		return "viral";
	}

	@RequestMapping("/challenge")

	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}

	@RequestMapping(value = { "/challenge", "/challenge/{name}" })
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}

	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", required = false, defaultValue = "0") int a,
			@RequestParam(value = "b", required = false, defaultValue = "0") int b, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);

		if (a == 0 & b==0) {
			model.addAttribute("hm", "hm");
		}

		else {
			String tulisan = "hm";
			for (int i = 2; i <= a; i++) {
				tulisan += "m";
			}

			String tulisan2 = "";
			for (int i = 1; i <= b; i++) {
				tulisan2 += " " + tulisan;
			}
			model.addAttribute("hm", tulisan2);

			
		}
		return "generator";
	}

}
