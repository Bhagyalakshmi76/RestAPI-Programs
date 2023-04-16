package dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import service.Student;


@Repository
@Service
public class StudentDAOImpl implements StudentDAO {


	@Autowired
    private JdbcTemplate jdbcTemplate;  
	
	
	public List<Student> getAllStudent() {
		 
		return  jdbcTemplate.query("select*from Student",  BeanPropertyRowMapper.newInstance(Student.class));
		
	}
	
	public List<Student> getById(int id) {
		
	return  jdbcTemplate.query("select*from Student where id=?", BeanPropertyRowMapper.newInstance(Student.class),id);
		 
	}
	
	public int create(Student student) {
		String query="insert into Student values(?,?,?)"; 
		int result=jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		System.out.println("record inesrted....!!"+result);
		return result;
	}
	
	public int update(Student student, int id) {
		String query="update Student set name=?,age=?,city=? where id=?";
		int result=jdbcTemplate.update(query,student.getName(),student.getCity());
		System.out.println("record updated....!!"+result);
		return result;
	}
	
	public int delete(int id) {
		String query="delete from Student  where id=?";
		int result=jdbcTemplate.update(query,id);
		System.out.println("record deleted....!!"+result);
		return result;
	}

	
	
}
