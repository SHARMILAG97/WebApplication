package com.revature.WaterPlant.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.User;
import com.revature.WaterPlant.util.ConnectionUtil;

public class StockDao implements StockInterface {

	public int findOne() throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from Stock_Details";
		PreparedStatement pst;
		int Availcans = 0;
		ResultSet rs;
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Availcans = rs.getInt("Available_cans");
			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to find", e);
		}
		return Availcans;
	}

	public User getStock() throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from Stock_Details ";
		PreparedStatement pst;
		User stock = new User();
		try {
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				stock.setAddcan(rs.getInt("Updated_cans"));
				stock.setOrdercan(rs.getInt("Ordered_cans"));
				stock.setReservecan(rs.getInt("Reserved_cans"));
				Date date = rs.getDate("Date_time");
				stock.setDate(date.toLocalDate());

			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Error", e);
		}
		return stock;

	}

	public void updateStock(int updatecans, int newcans) throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "update Stock_Details set Available_cans=?,Updated_cans=?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, updatecans);
			pst.setInt(2, newcans);
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Update", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

	}

	public List<User> viewStock() throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from Stock_Details";
		PreparedStatement pst;
		ResultSet rs;
		List<User> list = new ArrayList<User>();
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setCans(rs.getInt("Available_cans"));
				user.setAddcan(rs.getInt("Updated_cans"));
				user.setOrdercan(rs.getInt("Ordered_cans"));
				user.setReservecan(rs.getInt("Reserved_cans"));
				Date date = rs.getDate("Date_time");
				user.setDate(date.toLocalDate());
				list.add(user);
			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to find", e);
		}

		return list;
	}

	public void addStock(int newcans, int updatecans) throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into Stock_Details (Updated_cans,Available_cans) values (?,?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, newcans);
			pst.setInt(2, updatecans);
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Update", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

	}

	public void addStockOrder(int ordercans, int updatecans) throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into Stock_Details (Ordered_cans,Available_cans) values (?,?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, ordercans);
			pst.setInt(2, updatecans);
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Update", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

	}

	public void addStockReserve(int reservecans, int updatecans) throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into Stock_Details (Reserved_cans,Available_cans) values (?,?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, reservecans);
			pst.setInt(2, updatecans);
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Update", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

	}

	public void updateStockOrder(int availcans, int ordercan) throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "update Stock_Details set Available_cans=?,Ordered_cans=?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, availcans);
			pst.setInt(2, ordercan);
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Update", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

	}

	public void updateStockReserve(int availcans, int reservecan) throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "update Stock_Details set Available_cans=?,Reserved_cans=?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, availcans);
			pst.setInt(2, reservecan);
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Update", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

	}

	public void updateOrderReserve(int updatecan, int stockordercan, int stockreservecan) throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "update Stock_Details set Available_cans=?,Ordered_cans=?,Reserved_cans=?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, updatecan);
			pst.setInt(2, stockordercan);
			pst.setInt(3, stockreservecan);
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Update", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

		
	}

}
