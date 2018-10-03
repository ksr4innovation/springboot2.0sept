package com.snkit.springbootdemo.custorder;

import org.springframework.stereotype.Service;

@Service(value="custOrderInterface")
public class CustOrderServiceImpl implements CustOrderService {
	
	
	CustomerRepository custRepository;
	
	
	public CustOrderServiceImpl(CustomerRepository customerRepository) {
		this.custRepository = customerRepository;
	}

	@Override
	public String saveOrder(CustomerOrderReq req) {		
		
		String response;
		CustomerEntity cust = new CustomerEntity();		
		cust.setAddhar(req.getAddhar());
		cust.setEmail(req.getEmail());
		cust.setName(req.getName());	
		
		req.getOrderList().forEach(inputOrder-> {
			OrderEntity order = new OrderEntity();
			
			order.setAmt(inputOrder.getAmt());
			order.setCustomerEntity(cust);
			order.setQuantity(inputOrder.getQuantity());
			
			cust.getOrderEntityList().add(order);
		});
	
		
		CustomerEntity returnEntity = custRepository.save(cust);
		
		if (returnEntity.getId() !=  null) {
			response= "Success";
		}else {
			response ="failure";
		}
		
		return response;
		
	}

}
