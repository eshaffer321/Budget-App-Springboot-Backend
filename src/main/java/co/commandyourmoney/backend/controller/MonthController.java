package co.commandyourmoney.backend.controller;

import java.time.YearMonth;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController()
@RequestMapping("v1/month")
public class MonthController {
	@GetMapping("/current")
	public String index() {
		return YearMonth.now().toString();
	}
	
}
