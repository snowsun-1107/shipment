package com.tk.ShipmentManag01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializeData implements ApplicationRunner {
	List<Shipment> shipments = new ArrayList<Shipment>();
	List<Goods> goods = new ArrayList<Goods>();
    @Override
    public void run(ApplicationArguments args) throws Exception {
    	initializeGoods();
    	initializeShipments();
    }
    
    public List<Shipment> initializeShipments(){
    	Shipment shipment = new Shipment();
    	Shipment shipment2 = new Shipment();
    	Shipment shipment3 = new Shipment();
    	shipment.setNumber(10.00);
    	shipment.setShipmentNo("1");
    	List<Goods> goodsInShipment = new ArrayList<Goods>();
    	List<Goods> goodsInShipment02 = new ArrayList<Goods>();
    	List<Goods> goodsInShipment03 = new ArrayList<Goods>();
    	for(Goods allOfGoods :goods) {
    		if(allOfGoods.getId().equals("1")) {
    			goodsInShipment.add(allOfGoods);
    		}
    	}
    	shipment.setGoods(goodsInShipment);
    	
    	shipment2.setNumber(11.00);
    	shipment2.setShipmentNo("2");
    	
    	for(Goods allOfGoods :goods) {
    		if(allOfGoods.getId().equals("2")) {
    			goodsInShipment02.add(allOfGoods);
    		}
    	}
    	shipment2.setGoods(goodsInShipment02);
    	
    	shipment3.setNumber(12.00);
    	shipment3.setShipmentNo("3");   
    	
    	for(Goods allOfGoods :goods) {
    		if(allOfGoods.getId().equals("3")) {
    			goodsInShipment03.add(allOfGoods);
    		}
    	}
    	shipment3.setGoods(goodsInShipment03);
    	//List<Shipment> shipments = new ArrayList<Shipment>();
    	shipments.add(shipment);
    	shipments.add(shipment2);
    	shipments.add(shipment3);
    	
    	return shipments;
    }
    public List<Goods> initializeGoods(){
    	Goods goods1 = new Goods();
    	Goods goods2 = new Goods();
    	Goods goods3 = new Goods();
    	goods1.setId("1");
    	goods1.setName("");
    	goods2.setId("2");
    	goods2.setName("");
    	goods3.setId("3");
    	goods3.setName("");    	
    	goods.add(goods1);
    	goods.add(goods2);
    	goods.add(goods3);
    	return goods;
    }
	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
    
}
