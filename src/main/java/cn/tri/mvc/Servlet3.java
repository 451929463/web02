package cn.tri.mvc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import cn.tri.pojo.Student;

@Controller
//@SessionAttributes(value="stu")//将数据存入session域中，可以多写（value={"stu1,stu2,stu3"}）
@SessionAttributes(types=Student.class) //某一对象类型(types={Student.class,Address.class})
public class Servlet3 {                 //有SessionAttribute注解时存入Request域中同时也就存入了session域中
	@RequestMapping("testModelAndView")
	public ModelAndView testModelAndView(){  //利用modelAndView  传参和跳转页面
		System.out.println("-------------test--------------");
		ModelAndView mv = new ModelAndView("MyJsp");//myjsp 指需要跳转的页面
		Student stu = new Student();
		stu.setId(3);
		stu.setName("lisi");
		mv.addObject("stu", stu);//等同于 req.setAttrivute("key,value");
		return mv;
	}
	@RequestMapping("testModel")
	public String testModel(Model model){  //利用model 传参和跳转页面
		Student stu = new Student();
		stu.setId(3);
		stu.setName("lisi");
		model.addAttribute("stu", stu);//等同于 req.setAttrivute("key,value");
		return "MyJsp";
	}
	@RequestMapping("testMap")
	public String testMap(Map<String,Student> map){  //利用map  传参和跳转页面
		Student stu = new Student();
		stu.setId(3);
		stu.setName("lisi");
		map.put("stu", stu);//等同于 req.setAttrivute("key,value");
		return "MyJsp";
	}
	//-------@ModelAttribute 适用于修改数据，访问同类下的controller都会优先调用@ModelAttribute
	//因为修改不可能传递所有的信息，所以只需拿到关键ID去数据库查询相关信息，后再传给相关Controller
	@ModelAttribute
	public void rm(Map<String, Student> map){
		//模拟查询到数据库的需要修改数据
		Student stu = new Student();
		stu.setId(1);
		stu.setName("zs");
		map.put("Student", stu);//此处将查询到的数据传递给触发的Controller
	}
	@RequestMapping("testModelAttribute")//若map.put("stu",stu),则此处应该为update(@ModelAttribute("stu")Student xxx)
	public String update(@ModelAttribute("Student")Student stu){
		System.out.println(stu);
		stu.setName(stu.getName());
		System.out.println(stu);
		return "MyJsp";
	}
	
	@RequestMapping("defaults")	
	public String defaults(){
		return "MyJsp";//默认转发
	}
	@RequestMapping("forwards")	
	public String forwards(){
		return "forward:MyJsp.jsp";//转发
	}
	@RequestMapping("redirects")	
	public String redirects(){
		return "redirect:MyJsp.jsp";//重定向
	}
}
