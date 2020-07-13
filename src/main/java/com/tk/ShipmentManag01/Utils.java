package com.tk.ShipmentManag01;

import java.math.BigDecimal;

public class Utils {
	public static Double sub(Double v1, Double v2) {  
		   BigDecimal b1 = new BigDecimal(v1.toString());  
		   BigDecimal b2 = new BigDecimal(v2.toString());  
		   return new Double(b1.subtract(b2).doubleValue());  
		} 
	public static Double add(Double v1, Double v2) {  
		   BigDecimal b1 = new BigDecimal(v1.toString());  
		   BigDecimal b2 = new BigDecimal(v2.toString());  
		   return new Double(b1.add(b2).doubleValue());  
		}  	
}
