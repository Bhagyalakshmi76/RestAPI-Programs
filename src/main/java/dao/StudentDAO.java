package dao;

import java.util.List;

import org.springframework.stereotype.Service;

import service.Student;


@Service
public interface StudentDAO {
	
	public List<Student> getAllStudent();
	public  List<Student> getById(int id);
	public int create(Student student);
	public int update(Student student, int id);
	public int delete(int id);
	

}
