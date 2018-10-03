package com.snkit.springbootdemo.custorder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	CustOrderService inputService;
	
	public CustomerController(CustOrderService custOrderInterface) {
		this.inputService = custOrderInterface;
	}
	
	@PostMapping(value="saveOrder",consumes="application/json")
	public String saveOrder(@RequestBody CustomerOrderReq req) {		
		return inputService.saveOrder(req);
	}
}
