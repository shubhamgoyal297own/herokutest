package com.herokutest.testapp297.controllers;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.herokutest.testapp297.dtos.IncomeData;

@Controller
public class WelcomeController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	@ResponseBody
	public String welcomme() {
		return "";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/view")
	public String meoww(Model model) {
		model.addAttribute("hulala",
				"");
		return "welcome";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/calculate")
	@ResponseBody
	public String meoww(@RequestBody IncomeData incomeData, @RequestParam(name = "taxRegime") String taxRegime) {

		if ("new".equals(taxRegime)) {
			return calculateWithNewRegime(incomeData);
		} else if ("old".equals(taxRegime)) {
			return calculateWithOldRegime(incomeData);
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/calculateMap")
	@ResponseBody
	public Map<String, String> mapp( @RequestBody Map<String, Object> respMap)
	{
		Map<String, String> hulalaMap =  respMap.entrySet().stream()
		.collect(Collectors.toMap(Map.Entry::getKey, 
				e -> Objects.nonNull(e.getValue()) ? e.getValue().toString() : Strings.EMPTY
				));
		return hulalaMap;
	}

	private String calculateWithNewRegime(IncomeData incomeData) {
		int taxableSalary = incomeData.getAnnualIncome() - incomeData.getEightyCCDDeduction();
		int totalTax = 0;
		taxableSalary -= 250000;
		if (taxableSalary > 0) {
			int slab = Math.min(taxableSalary, 250000);
			totalTax += slab * 0.05;
			taxableSalary -= slab;
		}
		if (taxableSalary > 0) {
			int slab = Math.min(taxableSalary, 250000);
			totalTax += slab * 0.10;
			taxableSalary -= slab;
		}
		if (taxableSalary > 0) {
			int slab = Math.min(taxableSalary, 250000);
			totalTax += slab * 0.15;
			taxableSalary -= slab;
		}
		if (taxableSalary > 0) {
			int slab = Math.min(taxableSalary, 250000);
			totalTax += slab * 0.2;
			taxableSalary -= slab;
		}
		if (taxableSalary > 0) {
			int slab = Math.min(taxableSalary, 250000);
			totalTax += slab * 0.25;
			taxableSalary -= slab;
		}
		if (taxableSalary > 0) {
			totalTax += taxableSalary * 0.30;
		}
		return String.valueOf(totalTax);
	}

	private String calculateWithOldRegime(IncomeData incomeData) {
		int taxableSalary = incomeData.getAnnualIncome() - incomeData.getEightyCCDDeduction()
				- incomeData.getEightyCDeduction() - incomeData.getHraDeduction()
				- incomeData.getOtherFlexibleDeductions();
		int totalTax = 0;
		taxableSalary -= 250000;
		if (taxableSalary > 0) {
			int slab = Math.min(taxableSalary, 250000);
			totalTax += slab * 0.05;
			taxableSalary -= slab;
		}
		if (taxableSalary > 0) {
			int slab = Math.min(taxableSalary, 500000);
			totalTax += slab * 0.20;
			taxableSalary -= slab;
		}
		if (taxableSalary > 0) {
			totalTax += taxableSalary * 0.30;
		}
		return String.valueOf(totalTax);
	}
}
