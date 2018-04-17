package es.uji.ei1027.clubesportiu.dao;


import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.clubesportiu.model.Swimmer;


@Repository

public class SwimmerDao {
	 
	private JdbcTemplate jdbcTemplate;
     
	@Autowired
	public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	private static final class SwimmerMapper implements RowMapper<Swimmer> { 

	    public Swimmer mapRow(ResultSet rs, int rowNum) throws SQLException { 
	        Swimmer swimmer = new Swimmer();
	        swimmer.setName(rs.getString("name"));
	        swimmer.setFedId(rs.getString("fed_id"));
	        swimmer.setCountry(rs.getString("country"));
	        swimmer.setAge(rs.getInt("age"));
	        swimmer.setSex(rs.getString("sex"));
	        return swimmer;
	    }
	}

	public List<Swimmer> getSwimmers() {
		return this.jdbcTemplate.query(
		     	"select name,fed_id,country,age,sex from swimmer;", new SwimmerMapper());
	}
		
	public Swimmer getSwimmer(String name) {
		return this.jdbcTemplate.queryForObject(
				"select name,fed_id,country,age,sex from swimmer where name=?",  
				new Object[] {name}, new SwimmerMapper());
	}
	
	public void addSwimmer(Swimmer swimmer) {
		this.jdbcTemplate.update(
				"insert into Swimmer(name,fed_id,country,age,sex) values(?, ?, ?, ?, ?)", 
				swimmer.getName(), swimmer.getFedId(), 
				swimmer.getCountry(), swimmer.getAge(), swimmer.getSex());
	}
		
	public void updateSwimmer(Swimmer swimmer) {
		this.jdbcTemplate.update(
				"update Swimmer set fed_id=?, country=?, age=?, sex=? where name = ?", 
				swimmer.getFedId(), swimmer.getCountry(), 
				swimmer.getAge(), swimmer.getSex(), swimmer.getName());
	}
		
	public void deleteSwimmer(String name) {
		this.jdbcTemplate.update(
		        "delete from swimmer where name = ?", name);
	}
}