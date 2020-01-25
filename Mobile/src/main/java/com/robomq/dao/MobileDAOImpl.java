package com.robomq.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.robomq.pojo.Mobile;
import com.robomq.pojo.MobileMapper;



@Component
public class MobileDAOImpl implements MobileDAO {

	JdbcTemplate jdbcTemplate;

	/*
	 * private final String SQL_FIND_PERSON = "select * from people where id = ?";
	 * private final String SQL_DELETE_PERSON = "delete from people where id = ?";
	 * private final String SQL_UPDATE_PERSON =
	 * "update people set first_name = ?, last_name = ?, age  = ? where id = ?";
	 */
	private final String SQL_GET_ALL = "select * from Mobile";
	private final String SQL_INSERT_MOBILE = "insert into Mobile(id, name, price, quantity, description) values(?,?,?,?,?)";

	@Autowired
	public MobileDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/*
	 * public Person getPersonById(Long id) { return
	 * jdbcTemplate.queryForObject(SQL_FIND_PERSON, new Object[] { id }, new
	 * PersonMapper()); }
	 */

	public List<Mobile> getAllMobiles() {
		return jdbcTemplate.query(SQL_GET_ALL, new MobileMapper());
	}

	/*
	 * public boolean deletePerson(Person person) { return
	 * jdbcTemplate.update(SQL_DELETE_PERSON, person.getId()) > 0; }
	 * 
	 * 
	 * public boolean updatePerson(Person person) { return
	 * jdbcTemplate.update(SQL_UPDATE_PERSON, person.getFirstName(),
	 * person.getLastName(), person.getAge(), person.getId()) > 0; }
	 */
	public boolean createMobile(Mobile mobile) {
		return jdbcTemplate.update(SQL_INSERT_MOBILE, mobile.getId(), mobile.getName(), mobile.getPrice(), mobile.getQuantity()
				, mobile.getDescription()) > 0;
	}
}
