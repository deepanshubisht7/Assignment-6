package com.robomq.dao;

import java.util.List;

import com.robomq.pojo.Mobile;


public interface MobileDAO {
	/* Mobile getMobileById(Long id); */

	List<Mobile> getAllMobiles();
	/*
	 * boolean deleteMobile(Mobile mobile);
	 * 
	 * boolean updateMobile(Mobile mobile);
	 */

	boolean createMobile(Mobile mobile);

}
