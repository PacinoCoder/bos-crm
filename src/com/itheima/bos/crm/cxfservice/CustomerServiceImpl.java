package com.itheima.bos.crm.cxfservice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.crm.domain.Customer;

@Transactional
public class CustomerServiceImpl implements ICustomerService {
	//注入jdbc模板对象
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
//===================================方法区============================>>>>>>>>>>>>>>>>>>>
	public List<Customer> findAll() {
		String sql = "select * from t_customer";
		List<Customer> list = this.jdbcTemplate.query(sql , new RowMapper<Customer>(){

			@Override
			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");
				return new Customer(id, name, station, telephone, address, decidedzone_id);
			}
			
		});
		return list;
	}



	

}
