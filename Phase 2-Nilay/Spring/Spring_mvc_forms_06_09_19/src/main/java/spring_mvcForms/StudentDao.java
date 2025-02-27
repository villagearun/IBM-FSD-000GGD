package spring_mvcForms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



@Component(value="sDao")
public class StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void createStudent(Student student)
	{
		String query="insert into student(firstName,lastName,country,favouriteLanguage,operatingSystems) values(?,?,?,?,?)";
		Object obj[]= {student.getFirstName(),student.getLastName(),student.getCountry(),student.getFavouriteLanguage(),student.getFavouriteLanguage()};
		jdbcTemplate.update(query,obj);
		System.out.println("done");
	}
	
	public List<Student> getAllstudent()
	{
		return jdbcTemplate.query("select * from student", new StudentRowMapper());
	}
	public void deletestudent(int id)
	{
		String query="delete from student where id="+id;
		jdbcTemplate.update(query);
		System.out.println("Delete is done");
	}

}
