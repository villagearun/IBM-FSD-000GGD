package spring_mvcForms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ConfigurableWebApplicationContext;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentDao sDao;
	@GetMapping("/showForm")
	public String main_method(Model themodel)
	{
		Student s=new Student();
		themodel.addAttribute("student",s);
		return "student-form";
	}
	@PostMapping("/processForm")
	public String student_form(@ModelAttribute("student")Student thestudent, Model themodel)
	{   
	    
		themodel.addAttribute("stu",thestudent);
		sDao.createStudent(thestudent);
		return "student-display";
	}
}
