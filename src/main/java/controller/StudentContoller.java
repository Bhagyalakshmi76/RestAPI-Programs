package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.StudentDAO;
import service.Student;

@RestController
@RequestMapping("/api")
public class StudentContoller {
	
	
	@Autowired
	private StudentDAO sdao;
	
	public void setSdao(StudentDAO sdao) {
		this.sdao = sdao;
	}

	@GetMapping("/students")
	@ResponseBody
	public List<Student> getStudents()
	{
		
		System.out.println("getstudents called...");
		return sdao.getAllStudent();
	}
	
	@GetMapping("/student/{id}")
	public List<Student> getStudentById(@PathVariable int id)
	{
		
		return sdao.getById(id);
	}
	
	@PostMapping("/student")
	public String createStudent( Student student) 
	{
		
		return sdao.create(student)+"No. of rows saved to the database";
	}
	
	@PutMapping("/student {id}")
	public String updateStudent( Student student,@PathVariable int id) 
	{
		return sdao.update(student, id)+"No. of rows updated to the database";
	}
	
	@DeleteMapping("/student {id}")
	public String deleteById(@PathVariable int id) 
	{
		
		return sdao.delete(id)+"No. of rows deleted from the database";
		
	}
	
}


