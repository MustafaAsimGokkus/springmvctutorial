package com.techproed.springmvctutorial;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {
	// 1. way

	/*
	 * @RequestMapping ("add")//the parameter should be the same as the action in
	 * the form public String addNums1(HttpServletRequest req) {
	 * 
	 * int a = Integer.parseInt(req.getParameter("n1")); int b =
	 * Integer.parseInt(req.getParameter("n2")); int sum = a+b; int product = a*b;
	 * 
	 * HttpSession session = req.getSession();
	 * session.setAttribute("sumOfTwoIntegers", sum);
	 * session.setAttribute("productOfTwoIntegers", product); return "result"; }
	 * 
	 * //2nd way
	 * 
	 * @RequestMapping("add") public String addNums2(@RequestParam("n1") int
	 * a,@RequestParam("n2") int b, HttpSession session) { int sum = a+b; int
	 * product = a*b; session.setAttribute("sumOfTwoIntegers", sum);
	 * session.setAttribute("productOfTwoIntegers", product); return "result"; }
	 * 
	 * //3rd way
	 * 
	 * @RequestMapping("add") public ModelAndView addNums2(@RequestParam("n1") int
	 * a,@RequestParam("n2") int b) {
	 * 
	 * ModelAndView mv = new ModelAndView(); mv.setViewName("result"); int sum =
	 * a+b; int product = a*b; mv.addObject("sumOfTwoIntegers", sum);
	 * mv.addObject("productOfTwoIntegers", product); return mv; }
	 * 
	 * //4th way ==> Recommended
	 * 
	 * @RequestMapping("add") public ModelAndView addNums4(@RequestParam("n1") int
	 * a,@RequestParam("n2") int b) {
	 * 
	 * ModelAndView mv = new ModelAndView("result"); int sum = a+b; int product
	 * = a*b; mv.addObject("sumOfTwoIntegers", sum);
	 * mv.addObject("productOfTwoIntegers", product); return mv; }
	 * 
	 * //5.way
	 * 
	 * @RequestMapping("add") public String addNums5(@RequestParam("n1") int
	 * a,@RequestParam("n2") int b, Model m) {
	 * 
	 * int sum = a+b; int product = a*b; //1st usage //
	 * m.addAttribute("sumOfTwoIntegers", sum); //
	 * m.addAttribute("productOfTwoIntegers", product);
	 * 
	 * //2nd usage
	 * 
	 * m.addAttribute("sumOfTwoIntegers", sum).addAttribute("productOfTwoIntegers",
	 * product); return "result"; }
	 * 
	 * @RequestMapping("add") public String addNums6(@RequestParam("n1") int
	 * a,@RequestParam("n2") int b, ModelMap mm) {
	 * 
	 * int sum = a+b; int product = a*b; //1st usage
	 * mm.addAttribute("sumOfTwoIntegers", sum);
	 * mm.addAttribute("productOfTwoIntegers", product);
	 * 
	 * //2nd usage //mm.addAttribute("sumOfTwoIntegers",
	 * sum).addAttribute("productOfTwoIntegers", product); return "result"; }
	 */

	// *******************************************************************************************************

	// Student method:
	// 1st way

	// Student Method:

	// 1.Way:

//    @RequestMapping("addStudent")
//    public String addStudent1(@RequestParam("id") int id, @RequestParam("name") String name, Model m)
//    {
	// First Object Creation Way:
	// Student student = new Student();
	// student.setId(id);
	// student.setName(name);

	// this was using constructor without parameters.

	// 2. Object Creation Way:
//        Student student = new Student(id,name); //making the params dynamic bcz the user will enter the id and the name
//        
//        m.addAttribute("studentObject" , student);
//        
//        return "result";
//    }
//    
	
//	@RequestMapping("addStudent")
//	public String addStudent2 (@ModelAttribute Student student, Model m) { 
//		m.addAttribute("studentObject", student);
//		return "result";
//	}
	//3.way  
	@RequestMapping("addStudent")
	public String addStudent3 (@ModelAttribute ("studentObject") Student student) { 
		return "result";
	}
	
	//How to get a specific field from an object:you need to use ModelAttribute
	
	
//	@ModelAttribute
//	public void greetStudent(Model m, Student student) {
//		m.addAttribute("greetStudent",student.getName());
//	}
	
	/*How to use POST method:
	1. way
	to use POST method:
	 
	 1) inside the method paranthesis type method=RequestMethod.POST
	 2)then go to index.jsp file and add method="post" inside the form tag
	 */
	
//	@RequestMapping(value = "addStudent" , method= RequestMethod.POST)
//	public String addStudent4 (@ModelAttribute("studentObject") Student student )
//	{
//		
//		return "result";
//	}
//	
//	//How to get a specific field from the object, you need to use ModelAttribute
//	@ModelAttribute
//	public void greetStudent (Model m , Student student) {
//		
//		m.addAttribute ("greetStudent" , student.getName());
//	}
	
	
	
	
	//2.way
	/*
	 * to use post method
	 1)use @PostMapping("addStudent") with action name from the form tag
	 2)then go inside.jsp and add method ="post" inside the form tag
	  
	*/
//	@PostMapping("addStudent")
//	public String addStudent4 (@ModelAttribute("studentObject") Student student )
//	{
//		
//		return "result";
//	}
//	
//	
//	@ModelAttribute
//	public void greetStudent (Model m , Student student) {
//		
//		m.addAttribute ("greetStudent" , student.getName());
//	}
//	
	//How to use get method
	
	//1.way
	/*
	 * 1)inside the method paranthesis type "method = RequestMethod.GET"
	 
	   2) go to index jsp and add method="get" insode the form tag
	   3)go to  result.jsp file and type ${studentList}
	 */
	
//	@RequestMapping (value = "getStudent" , method=RequestMethod.GET)
//	public String getStudent (Model m) {
//		
//		List<Student> students = new ArrayList<>();
//		students.add(new Student(101 , "Ali Can"));
//		students.add(new Student(102 , "Veli Can"));
//		students.add(new Student(103 , "Mary Star"));
//		students.add(new Student(104 , "Tom Hanks"));
//		students.add(new Student(105 , "Angie Ocean"));
//		
//		m.addAttribute("studentList" , students);
//		
//		return "result";
//	}
	
	@GetMapping ("getStudentWithId")
  public String getStudent1 (@RequestParam("id") int id, Model m) {
		
		List<Student> students = new ArrayList<>();
		students.add(new Student(101 , "Ali Can"));
		students.add(new Student(102 , "Veli Can"));
		students.add(new Student(103 , "Mary Star"));
		students.add(new Student(104 , "Tom Hanks"));
		students.add(new Student(105 , "Angie Ocean"));
		
		
		int idx= -1; //index value can't be negative but if we put 0 it is the first idx, -1 is afalde idx
		for(Student w:students) {
			if(idx ==w.getId()) {
				idx = students.indexOf(w);
			}
		}
		
		if(idx== -1) {//means there is no such id
			m.addAttribute("specificStudent" , "There is no such ID");
		}else {
			m.addAttribute("specificStudent" ,  students.get(idx));
		}
		
				
		return "result";
	}
}
