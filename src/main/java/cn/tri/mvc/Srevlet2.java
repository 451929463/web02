package cn.tri.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tri.pojo.Student;

@Controller
public class Srevlet2 {
	@RequestMapping(value="testMethod",method=RequestMethod.GET)
	public String get(){
		System.out.println("GET");
		return "MyJsp";
	}
	@RequestMapping(value="testMethod",method=RequestMethod.POST)
	public String post(){
		System.out.println("POST");
		return "MyJsp";
	}
	@RequestMapping(value="testMethod",method=RequestMethod.PUT)
	public String put(){
		System.out.println("PUT");
		return "MyJsp";
	}
	@RequestMapping(value="testMethod",method=RequestMethod.DELETE)
	public String delete(){
		System.out.println("DELETE");
		return "MyJsp";
	}
	@RequestMapping(value="testMethod/params") //此处拿到表单请求的参数
	public String params1(@RequestParam("uname") String name){
		System.out.println(name);
		return "MyJsp";
	}
	@RequestMapping(value="testMethod/params2") //此处拿到表单请求的参数
	public String params2(@RequestParam("uname") String name,
			@RequestParam(value="uage",required=false,defaultValue="23") String age){
		/*
		 * value="uage" 和 uage 相同
		 * required=false 代表uage可有可无，默认为true,必须有
		 * defaultValue=XX 代表默认值，不传系为默认值
		 * */
		System.out.println(name);
		System.out.println(age);
		return "MyJsp";
	}
	
	@RequestMapping(value="testHeader") //此处拿到请求头的参数  @RequestHeader("请求头的KEY"),具体语法和RequestParam一样
	public String header(@RequestHeader("Accept-Language") String al){
		System.out.println(al);
		return "MyJsp";
	}
	
	@RequestMapping(value="testCookie") //此处拿到请求头的参数  @CookieValue("cookie的KEY")
	public String cookie(@CookieValue("JSESSIONID") String jSessionId){
		System.out.println(jSessionId);//E017CACD34916B5387D40D27A94C35B0
		return "MyJsp";
	}
	
	@RequestMapping(value="testObject") //mvc接收参数为对象，前段form表单需与对象属性一直
	public String testObject(Student stu){//同时，还支持级联传参，前端页面  student>>address.homeAddress;
		System.out.println(stu);
		return "MyJsp";
	}
	@RequestMapping("testHttpServletRequest")//如果spring-mvc想使用ServletAPI的方法，直接在方法传参里面加入参数 HttpServletRequest req
	public String testHttp(HttpServletRequest req){
		String name = req.getParameter("name");
		System.out.println(name);
		return "MyJsp";
	}
}
