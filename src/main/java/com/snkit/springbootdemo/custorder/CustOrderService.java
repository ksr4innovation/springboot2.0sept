package com.snkit.springbootdemo.custorder;

import java.util.List;

public interface CustOrderService {
	
	
	String saveOrder(CustomerOrderReq req);
	
	CustomerOrderResp  findCustInfoByName(CustomerOrderReq req);
	
	CustomerOrderResp  findCustInfoNameAndEmail(CustomerOrderReq req);
	
	CustomerOrderResp  findCustInfoNameAndEmailAndAddhar(CustomerOrderReq req);
	
	CustomerOrderResp  getCustToAvoidNPlus1(CustomerOrderReq req);
	
	List<CustomerNativeVO> getCustNaviteQuery(CustomerOrderReq req);
}
