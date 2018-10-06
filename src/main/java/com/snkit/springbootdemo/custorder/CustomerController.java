package com.snkit.springbootdemo.custorder;

import java.util.List;

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
	
	
	@PostMapping(value="getCustInfoByName",consumes="application/json")
	public CustomerOrderResp getCustInfoByName(@RequestBody CustomerOrderReq req) {		
		return inputService.findCustInfoByName(req);
	}
	
	@PostMapping(value="getCustInfoByNameAndEmail",consumes="application/json")
	public CustomerOrderResp getCustInfoByNameAndEmail(@RequestBody CustomerOrderReq req) {		
		return inputService.findCustInfoNameAndEmail(req);
	}
	
	@PostMapping(value="getCustInfoByCustInfo",consumes="application/json")
	public CustomerOrderResp getCustInfoByCustInfo(@RequestBody CustomerOrderReq req) {		
		return inputService.findCustInfoNameAndEmailAndAddhar(req);
	}
	
	
	@PostMapping(value="getCustToAvoidNPlus1",consumes="application/json")
	public CustomerOrderResp getCustToAvoidNPlus1(@RequestBody CustomerOrderReq req) {		
		return inputService.getCustToAvoidNPlus1(req);
	}
	
	@PostMapping(value="getCustNaviteQuery",consumes="application/json")
	public List<CustomerNativeVO> getCustNaviteQuery(@RequestBody CustomerOrderReq req) {		
		return inputService.getCustNaviteQuery(req);
	}
}
