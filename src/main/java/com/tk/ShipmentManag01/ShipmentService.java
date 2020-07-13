package com.tk.ShipmentManag01;

public interface ShipmentService {
	public Shipment splitShipment(String id);
	public Shipment mergeShipment(String id);
	public Shipment changeShipment(String id);
	public Shipment trade(String id);
}
