package com.leebx.mapper;

import com.leebx.pojo.Order;
import com.leebx.pojo.OrderDetail;
import com.leebx.pojo.OrderStatus;
import com.leebx.pojo.Sku;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("INSERT INTO tb_order(order_id,total_pay,payment_type,create_time,user_id) VALUES(#{orderId},#{totalPay},#{paymentType},now(),#{userId})")
    public void addOrder(Order order);
    @Insert("INSERT INTO tb_order_detail VALUES(0,#{orderId},#{skuId},#{num},#{title},#{ownSpec},#{price},#{image})")
    public void addOrderDetail(OrderDetail orderDetail);
    @Insert("INSERT INTO tb_order_status(order_id,status,create_time) VALUES(#{orderId},#{status},now())")
    public void addOrderStatus(OrderStatus orderStatus);
}
