package electro.store.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import electro.store.entity.Order;
import electro.store.entity.OrderDetail;
import electro.store.repository.OrderRepository;
import electro.store.repository.OrderDetailRepository;
import electro.store.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository dao;
	
	@Autowired
	OrderDetailRepository ddao;
	
	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		
		//convert gia tri json thanh doi tuong class
		Order order = mapper.convertValue(orderData, Order.class);
		dao.save(order);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		ddao.saveAll(details);
		
		return order;
	}
	
	@Override
	public Object findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public List<Order> findByUsername(String username) {
		return dao.findByUsername(username);
	}

}
