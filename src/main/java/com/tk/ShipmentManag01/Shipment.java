package com.tk.ShipmentManag01;

import java.util.ArrayList;
import java.util.List;

public class Shipment {
	private String shipmentNo;
	private Double number = 0.00;
	private List<Goods> goods = new ArrayList<Goods>();
	public String getShipmentNo() {
		return shipmentNo;
	}
	public void setShipmentNo(String shipmentNo) {
		this.shipmentNo = shipmentNo;
	}
	public Double getNumber() {
		return number;
	}
	public void setNumber(Double number) {
		this.number = number;
	}
	public List<Goods> getGoods() {
		return goods;
	}
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	
}
