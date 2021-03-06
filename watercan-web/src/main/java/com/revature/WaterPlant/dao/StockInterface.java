package com.revature.WaterPlant.dao;

import java.util.List;
import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.User;

public interface StockInterface {
	int findOne() throws DBException;
	 void updateStock(int updatecans, int newcans) throws DBException;
	 List<User> viewStock() throws DBException;
	void addStock(int newcans,int updatecans) throws DBException;
	void addStockOrder(int ordercans, int updatecans) throws DBException;
	void addStockReserve(int reservecans,int updatecans) throws DBException;
	User  getStock() throws DBException;
	void updateStockOrder(int availcans, int ordercan) throws DBException;
	void updateStockReserve(int availcans, int reservecan) throws DBException;
	void updateOrderReserve(int updatecan, int stockordercan, int stockreservecan) throws DBException;

}
