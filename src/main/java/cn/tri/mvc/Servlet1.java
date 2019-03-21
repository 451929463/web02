package cn.tri.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Servlet1 {
	@RequestMapping("myjsp")
	public String myjsp(){
		return "MyJsp";
	}
	
	@RequestMapping("test0/?/mvc")//?代表任意一个字符
	public String test0(){
		return "MyJsp";
	}
	@RequestMapping("test0/mvc*")//*代表任意多个字符
	public String test1(){
		return "MyJsp";
	}
	@RequestMapping("test0/**/mvc")//**代表任意层目录
	public String test2(){
		return "MyJsp";
	}
	
	@RequestMapping(value="test3")//同（“test”）意义一样
	public String test3(){
		return "MyJsp";
	}
	@RequestMapping(value="test4",method=RequestMethod.POST)//**限定post访问
	public String test4(){
		return "MyJsp";
	}
	
	@RequestMapping(value="test5",method=RequestMethod.POST,params={"name"})//params访问必须带name
	public String test5(){
		return "MyJsp";
	}
	
	@RequestMapping(value="test6",method=RequestMethod.POST,params={"name=3","age=23"})//**限定post访问
	public String test6(){
		return "MyJsp";
	}
	
	@RequestMapping(value="test7/{name}",method=RequestMethod.POST )//mvc获取参数
	public String test7(@PathVariable("name") String name){
		System.out.println(name);
		return "MyJsp";
	}
}
