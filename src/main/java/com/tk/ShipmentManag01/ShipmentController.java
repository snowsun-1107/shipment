package com.tk.ShipmentManag01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentController {
	@Autowired
	private ShipmentService shipmentService;
	@Autowired
	private InitializeData initializeData;
	
    @RequestMapping(value = "/split/{shipmentNo}/{number}",method = RequestMethod.GET)
    public Shipment split(@PathVariable(name = "shipmentNo") String shipmentNo,@PathVariable(name = "number") String number){
    	List<Shipment> shipments = new ArrayList<Shipment>();
    	shipments =initializeData.getShipments();    	
    	Shipment shipment = new Shipment();
    	shipment =shipments.get(Integer.parseInt(shipmentNo)-1);
    	Double numberOfshipment = shipment.getNumber();
    	Double numberOfSplit = Double.parseDouble(number); 
    	Double numberAfterSplit =Utils.sub(numberOfshipment, numberOfSplit);
    	shipment.setNumber(numberAfterSplit);
        return shipment;
    }
    @RequestMapping(value = "/merge",method = RequestMethod.GET)
    public Shipment merge(@RequestParam("shipmentNo") String shipmentNo,@RequestParam("shipmentNos") List<String> shipmentNos){
    	List<Shipment> shipments = new ArrayList<Shipment>();
    	shipments =initializeData.getShipments();    	
    	
    	Shipment shipment = new Shipment();
    	shipment =shipments.get(Integer.parseInt(shipmentNo)-1);
    	List<Goods> neededGoods = new ArrayList<Goods>();
    	for(String neededShipmentNo:shipmentNos) {
    		Shipment neededShipment = new Shipment(); 
    		neededShipment =shipments.get(Integer.parseInt(neededShipmentNo)-1);
    		List<Goods> goods =neededShipment.getGoods();
    		neededGoods.addAll(goods);
    	}
    	List<Goods> toBeNeededGoods = new ArrayList<Goods>();
    	toBeNeededGoods = shipment.getGoods();
    	toBeNeededGoods.addAll(neededGoods);
    	shipment.setGoods(toBeNeededGoods);

        return shipment;
    }

    @RequestMapping(value = "/change",method = RequestMethod.GET)
    public List<Shipment> change(@RequestParam("shipmentNo01") String shipmentNo01,@RequestParam("shipmentNo02") String shipmentNo02,@RequestParam("goods") List<String> goods){
    	List<Shipment> shipments = new ArrayList<Shipment>();
    	shipments =initializeData.getShipments();    
    	List<Goods> allOfGoods = new ArrayList<Goods>();
    	allOfGoods =initializeData.getGoods();   
    	
    	List<Goods> goodsNeededToBeChange =  new ArrayList<Goods>();
    	for(Goods oneOfgoods :allOfGoods) {
    		for(String id :goods) {
	    		if(id.equals(oneOfgoods.getId())) {
	    			goodsNeededToBeChange.add(oneOfgoods);
	    		}
    		}
    	}
    	List<Shipment> shipmentsForShow = new ArrayList<Shipment>();
    	Shipment shipmentNeedToChange01 = new Shipment(); 
    	Shipment shipmentNeedToChange02 = new Shipment(); 
    	shipmentNeedToChange01 = shipments.get(Integer.parseInt(shipmentNo01)-1);
    	shipmentNeedToChange02 = shipments.get(Integer.parseInt(shipmentNo02)-1);

    	
    	List<Goods> goodsNeedToChange01s = shipmentNeedToChange01.getGoods();
    	List<Goods> goodsNeedToChange02s = shipmentNeedToChange02.getGoods();
    	
    	goodsNeedToChange01s.removeAll(goodsNeededToBeChange);
    	goodsNeedToChange02s.addAll(goodsNeededToBeChange);
    	shipmentNeedToChange01.setGoods(goodsNeedToChange01s);
    	shipmentNeedToChange02.setGoods(goodsNeedToChange02s);
    	shipmentsForShow.clear();
    	shipmentsForShow.add(shipmentNeedToChange01);
    	shipmentsForShow.add(shipmentNeedToChange02);
        return shipmentsForShow;
    }     
    
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public List<Shipment> showShipments(){
    	List<Shipment> shipments = new ArrayList<Shipment>();
    	shipments =initializeData.getShipments();
        return shipments;
    }  

    @RequestMapping(value = "/trade/{number}",method = RequestMethod.GET)
    public Shipment trade(@PathVariable(name = "number") String number){
    	Shipment shipment =  new Shipment();
    	shipment.setNumber(Double.valueOf(number));
    	String shipmentNo;
    	List<Shipment> shipments = new ArrayList<Shipment>();
    	shipments =initializeData.getShipments();  
    	String shipmentNoOfshipments =shipments.get(shipments.size()-1).getShipmentNo();
    	Integer lastShipmentNo =Integer.valueOf(shipmentNoOfshipments)+1;
    	shipment.setShipmentNo(String.valueOf(lastShipmentNo));
    	
    	List<Goods> allOfGoods = initializeData.getGoods();
    	List<Goods> tradeGoods = new ArrayList<Goods>();
    	Goods tradegoods = allOfGoods.get(1);
    	tradeGoods.add(tradegoods);
    	shipment.setGoods(tradeGoods);
        return shipment;
    }        
}
