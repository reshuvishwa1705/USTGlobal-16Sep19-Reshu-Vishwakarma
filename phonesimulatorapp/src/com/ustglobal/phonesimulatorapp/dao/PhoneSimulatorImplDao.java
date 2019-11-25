package com.ustglobal.phonesimulatorapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;
import com.ustglobal.phonesimulatorapp.dto.PhoneSimulatorDto;
import com.ustglobal.phonesimulatorapp.phonesimulator_db.Phone_Db;
import com.ustglobal.phonesimulatorapp.util.PhoneSimulatorManager;


public class PhoneSimulatorImplDao extends Phone_Db implements PhoneSimulatorDao {
private static final String SELECT_QUERY = "select * from contact";
private static final String SEARCH_QUERY = "select * from contact where name = ?";
private static final String ADD_QUERY = "insert into contact values(?,?,?)";
private static final String DELETE_QUERY = "delete from contact where name=?";
private static final String EDIT_QUERY = "update contact set number=?, groups=? where name = ?";
@Override
	public List<PhoneSimulatorDto> showAllContact() {
		try(Connection conn = Phone_Db.getDbConnection();PreparedStatement pstmt = conn.prepareStatement(SELECT_QUERY)) {
			List<PhoneSimulatorDto> l = new ArrayList<PhoneSimulatorDto>();
			try(ResultSet rs = pstmt.executeQuery()){
			PhoneSimulatorDto dto = new PhoneSimulatorDto();
			while(rs.next()) {
			dto.setName(rs.getString("name"));
			dto.setNumber(rs.getInt("number"));
			dto.setGroups(rs.getString("groups"));
			}
			l.add(dto);
			return  l;
			}
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
		
	}//end of shoAllContact
	@Override
	public PhoneSimulatorDto searchContact(String name) {
		try(Connection conn = Phone_Db.getDbConnection();PreparedStatement pstmt = conn.prepareStatement(SEARCH_QUERY)) {
			pstmt.setString(1, name);
			try(ResultSet rs = pstmt.executeQuery()){
				PhoneSimulatorDto dto = new PhoneSimulatorDto();
				if(rs.next()) {
					dto.setName(rs.getString("name"));
					dto.setNumber(rs.getInt("number"));
					dto.setGroups(rs.getString("groups"));
				}
				return dto;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}//end of searchContact
	@Override
	public int addContact(PhoneSimulatorDto dto) {
		try(Connection conn = Phone_Db.getDbConnection();PreparedStatement pstmt = conn.prepareStatement(ADD_QUERY)) {
			pstmt.setString(1,dto.getName());
			pstmt.setInt(2, dto.getNumber());
			pstmt.setString(3, dto.getGroups());
			int count = pstmt.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}//end of addContact
	@Override
	public int deleteContact(String name) {
		try(Connection conn = Phone_Db.getDbConnection();PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY)) {
			pstmt.setString(1, name);
			int count = pstmt.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}//end of deleteContact
	@Override
	public int editContact(PhoneSimulatorDto dto) {
		try(Connection conn = Phone_Db.getDbConnection();PreparedStatement pstmt = conn.prepareStatement(EDIT_QUERY)) {
			pstmt.setInt(1,dto.getNumber());
			pstmt.setString(2, dto.getGroups());
			pstmt.setString(3, dto.getName());
			int count = pstmt.executeUpdate();
			return count;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}//end of editContact
	

}//end of class
