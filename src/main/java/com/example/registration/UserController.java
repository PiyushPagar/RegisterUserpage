package com.example.registration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;





@Controller
public class UserController {


	  @Autowired
	    private UserService service;
	  
	  @GetMapping("")
	   public String viewHomePage() {
		   
		   return "index";
	   }
	  
	  @RequestMapping("/list")
	  public String viewHomePage(Model model) {
	      List<Users> listUser = service.listAll();
	      System.out.println("In Method "+listUser);
	      
	       model.addAttribute("listUsers", listUser);
	      return "list_users";
	  }
	  
	  // for my info
	  @RequestMapping("/userrole")
	  public String viewrolepage(Model model) {
	      List<UserRole> listUserroleList = ((UserService) service).listAll1();
	      System.out.println("In Method "+listUserroleList);
	      model.addAttribute("listUserroleList" , listUserroleList);
	      return "listUserroleList";
	  }
	  //
	  
	  
	  @RequestMapping("/new")
	  public String showNewUsersPage(Model model) {
		  Users user = new Users();
	      model.addAttribute("user", user);
	      return "new_user";
	  }
	  
	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public String saveUsers(@ModelAttribute("user") Users user) {
		  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		    String encodedPassword = passwordEncoder.encode(user.getPassword());
		    user.setPassword(encodedPassword);
	      service.save(user);
	      return "redirect:/list";
	  }
	  
	  @RequestMapping("/edit/{id}")
	  public ModelAndView showEditProductPage(@PathVariable(name = "id") long id) {
	      ModelAndView mav = new ModelAndView("edit_user");
	      Users user = service.get(id);
	      mav.addObject("user", user);
	      return mav;
	  }
	  
	  @GetMapping("delete/{id}")
	    public String deleteStudent(@PathVariable("id") long id, Model model) {
		//  Product product = service.get(id);
		  service.delete(id)  ;    
		//  service.delete();
	    //    model.addAttribute("product", service.findAll());
	        return "list_users";
	    }
	
	
	
}
