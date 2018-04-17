package es.uji.ei1027.clubesportiu.dao;


import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.clubesportiu.model.Standing;


@Repository
public class StandingDao {
	 
	private JdbcTemplate jdbcTemplate;
     
	@Autowired
	public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	private static final class StandingMapper implements RowMapper<Standing> { 

	    public Standing mapRow(ResultSet rs, int rowNum) throws SQLException { 
	        Standing standing = new Standing();
	        standing.setSwimmerName(rs.getString("swimmer_name"));
	        standing.setEventName(rs.getString("event_name"));
	        standing.setPosition(rs.getInt("position"));
	        standing.setFinishTime(rs.getTime("finish_time"));
	        return standing;
	    }
	}
	

	public List<Standing> getStandings() {
		return this.jdbcTemplate.query(
		     	"select swimmer_name, event_name, position, finish_time from Standing;", new StandingMapper());
	}
	
	// ... rest of DAO
	
	public List<Standing> getStandingEvent(String eventName) {
		return this.jdbcTemplate.query(
                       "SELECT * FROM Standing WHERE event_name=?;",  
                       new Object[] {eventName}, new StandingMapper());
	}

}

