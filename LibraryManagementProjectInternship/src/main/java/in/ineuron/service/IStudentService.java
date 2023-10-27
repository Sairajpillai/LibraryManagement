package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService {

	public String saveStudent(Student student);

	public Student getStudent(int id);

	public String updateStudent(Student student);

	public String deleteStudent(int id);
	
	public String verifyStudent(int id,String password);

}
