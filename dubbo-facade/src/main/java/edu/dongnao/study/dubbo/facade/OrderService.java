package edu.dongnao.study.dubbo.facade;

import edu.dongnao.study.dubbo.model.OrderModel;

/**
 * OrderService
 * 订单服务接口
 */
public interface OrderService {
	/**
	 * 创建订单
	 * @param order
	 * @return
	 */
	public String createOrder(OrderModel order);
	
	/**
	 * 查询订单信息
	 * @param orderNo
	 * @return
	 */
	public OrderModel getOrder(String orderNo);
}

