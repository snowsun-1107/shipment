package com.tk.ShipmentManag01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ShipmentService")
public class ShipmentServiceImpl implements ShipmentService{
	@Autowired
	private InitializeData initializeShipments;
    @Override
    public Shipment splitShipment(String id) {
    	Shipment shipment = new Shipment();
    	List<Shipment> shipments = new ArrayList<Shipment>();
        return null;
    }
    @Override
    public Shipment mergeShipment(String id) {
    	Shipment shipment = new Shipment();
    	List<Shipment> shipments = new ArrayList<Shipment>();
        return null;
    }
    @Override
    public Shipment changeShipment(String id) {
    	Shipment shipment = new Shipment();
    	List<Shipment> shipments = new ArrayList<Shipment>();
        return null;
    }  
//    @Override
  
    public Shipment trade(String id) {
    	Shipment shipment = new Shipment();
    	Double quantity=0.0;
    	//List<Shipment> shipments = initializeShipments.getShipments();
    	List<Goods> goods = initializeShipments.getGoods();
    	return null;
    }    
}
