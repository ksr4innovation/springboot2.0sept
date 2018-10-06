package com.snkit.springbootdemo.custorder;

import java.util.List;

import org.springframework.stereotype.Service;

import com.snkit.springbootdemo.OrderVO;

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

	private CustomerOrderResp parseCustEntity(List<CustomerEntity> custEntityList) {
		CustomerOrderResp resp = new CustomerOrderResp();
		
		
		
		System.out.println(" Customer list size  "+custEntityList.size());
		
		custEntityList.forEach(cust -> {
			resp.setAddhar(cust.getAddhar());
			resp.setEmail(cust.getEmail());
			resp.setName(cust.getName());
			resp.setCustId(cust.getId());	
					
			cust.getOrderEntityList().forEach(orderEntity -> {
				OrderVO order = new OrderVO();
				
				order.setAmt(orderEntity.getAmt());				
				order.setQuantity(orderEntity.getQuantity());
				order.setOrderId(orderEntity.getId());				
				resp.getOrderList().add(order);
			});	
		
		});
		
		return resp;
	}
	
	@Override
	public CustomerOrderResp getCustToAvoidNPlus1(CustomerOrderReq req) {
		
		System.out.println("    getCustToAvoidNPlus1   ============================ ");
		
		List<CustomerEntity> custEntityList = custRepository.getCustEmpDetailswithOutJoin(req.getName());
		return parseCustEntity(custEntityList);
	}
	
	@Override
	public CustomerOrderResp findCustInfoByName(CustomerOrderReq req) {
		List<CustomerEntity> custEntityList = custRepository.findByName(req.getName());
		return parseCustEntity(custEntityList);
	}

	@Override
	public CustomerOrderResp findCustInfoNameAndEmail(CustomerOrderReq req) {
		String[] input = {req.getName(),req.getEmail()};
		List<CustomerEntity> custEntityList = custRepository.findByNameAndEmail(req.getName(),req.getEmail());
		return parseCustEntity(custEntityList);
	}

	@Override
	public CustomerOrderResp findCustInfoNameAndEmailAndAddhar(CustomerOrderReq req) {
		String[] input = {req.getName(),req.getEmail(),req.getAddhar()};
		List<CustomerEntity> custEntityList = custRepository.findByNameAndEmailAndAddhar(req.getName(),req.getEmail(),req.getAddhar());
		return parseCustEntity(custEntityList);
	}

	

}
