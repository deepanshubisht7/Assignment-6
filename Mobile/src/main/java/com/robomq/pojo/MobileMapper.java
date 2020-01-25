package com.robomq.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MobileMapper implements RowMapper<Mobile> {

	public Mobile mapRow(ResultSet resultSet, int i) throws SQLException {

		Mobile mobile = new Mobile();
		mobile.setId(resultSet.getInt("id"));
		mobile.setName(resultSet.getString("name"));
		mobile.setPrice(resultSet.getInt("price"));
		mobile.setQuantity(resultSet.getInt("quantity"));
		mobile.setDescription(resultSet.getString("description"));
		return mobile;
	}
}
