package com.krystalwatches;

import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.krystalwatches.ProductModel.Product;

import com.krystalwatches.ProductModel.ProductService;
import com.krystalwatches.UserModel.User;
import com.krystalwatches.UserModel.UserService;

import com.krystalwatches.UserRoleModel.UserRole;
import com.krystalwatches.UserRoleModel.UserRoleService;
@Controller
public class HelloController 
	{
	
	@Autowired
	ProductService ps;
	
	@Autowired
	UserService as;	
	
	@Autowired
	UserRoleService	urs;
	
	@Autowired
    ServletContext context;
	
	@RequestMapping("/") 
	public String main123()	
	{
		urs.generateUserRoles();
		return "index";
	}
		 
	 
	 @RequestMapping("/index") 
	 public ModelAndView index() 
	 { 
		 
		 ModelAndView mav = new ModelAndView("index");
		 
		 mav.addObject("data", "["+
								"{\"ProductID\":\"1\",\"ProductName\":\"Beans\",\"ProductPrice\":\"1000\"},"+
								"{\"ProductID\":\"2\",\"ProductName\":\"Jelly\",\"ProductPrice\":\"2000\"},"+
								"{\"ProductID\":\"3\",\"ProductName\":\"Kaddu\",\"ProductPrice\":\"3000\"},"+
								"{\"ProductID\":\"4\",\"ProductName\":\"Daddu\",\"ProductPrice\":\"4000\"}"+
								"]");
		 
		 return mav;
		 
	 }
	/*For Extraxting all the data from the Database and show on PRODUCT page*/ 
	 @RequestMapping("/product") 
	 public ModelAndView abc() 
	 { 
		 
		 ModelAndView mav = new ModelAndView("product");
		 
		 JSONArray jarr = new JSONArray();
		 
		 List<Product> list = ps.getAllProducts();
		 
		 for( Product p:list )
		 {
			 JSONObject jobj = new JSONObject();
			 
			 
			 
			 jobj.put("ProductID", p.getProductId());
			 jobj.put("ProductName", p.getProductName());
			 jobj.put("ProductPrice", p.getProductPrice());
			 jobj.put("ProductQty", p.getProductQty());
			 jobj.put("flag", p.getProductImage());
			 
			 jarr.add(jobj);
		 }
		 
		 mav.addObject("data", jarr.toJSONString());
		 
		 return mav;
		 
	 }
	 
	 
	 
	 @RequestMapping("/aboutus") 
	 public String abt()	
		{	
			return "aboutus";
		}
	
	 
	 
	 
	 @RequestMapping("/contact_us") 
	 public String cnts()	
		{	
			return "contact_us";
		}
	 
	 
	 @RequestMapping("/home") 
	 public String hme()	
		{	
			return "index";
		}
	 
	 
	 
	 
	/*ADDPRODUCT*/
	
	 @RequestMapping(value="/addproduct")  	 
	public ModelAndView addproduct()
	{
	 ModelAndView mav = new ModelAndView("addproduct");
	mav.addObject("newproduct", new Product());
	
	return mav;
	}

	 
	 
	 	 
	@RequestMapping(value="/view/{productID}")  	 
	public ModelAndView addproduct1(@PathVariable("productID") int prodid)
	{
	 ModelAndView mav = new ModelAndView("view");
	 
	 System.out.println(prodid);
	 
	 Product p = ps.getProduct(prodid);
	 
	 if( p != null )
	 {
		
		 mav.addObject("ProductName",  p.getProductName() );
		 mav.addObject("ProductDescription",p.getProductDescription() );
		 mav.addObject("ProductCategory",  p.getProductCategory() );
		 mav.addObject("ProductPrice",  p.getProductPrice() );
		 mav.addObject("ProductQty",  p.getProductQty() );
	 }
	 
	
	return mav;
	 
	}
	
	
/*DELETE*/	
	
	
	
	
	@RequestMapping(value="/delete/{productID}")  	 
	public String deleteproduct1(@PathVariable("productID") int prodid)
	{
	
	 System.out.println(prodid);
	 
	 ps.deleteProduct(prodid);
	return "redirect:http://localhost:8080/krystalwatches/product";
	}

	
	@RequestMapping(value="/insertproduct", method = RequestMethod.POST)  	 
	public String insertproduct( @ModelAttribute( "newproduct" ) Product p  )
	{
		System.out.println(p.getProductName());
		
		ps.insertProduct(p);
		
		
		return "redirect:product";
	}
	
	
	/*UPDATE*/
	
		
		
		@RequestMapping(value="/update/{productID}")  	 
		public ModelAndView update(@PathVariable("productID") int prodid)
		{
		 ModelAndView mav = new ModelAndView("update");
		 
		 System.out.println(prodid);
		 
		 Product p = ps.getProduct(prodid);
	
		 mav.addObject("newproduct2", p);
		 
		 return mav;
		 
		}
	
		@RequestMapping(value="/updateproduct", method = RequestMethod.POST)  	 
		public String updateproduct( @ModelAttribute( "newproduct2" ) Product p  )
		{
			System.out.println(p.getProductName());
			
			ps.updateProduct(p);
			
			return "redirect:product";
		}
		
		
		
		
		/*SIGNUP PAGE*/
		
		 @RequestMapping(value="/signup")  	 
			public ModelAndView sgnup()
			{
			 ModelAndView mav = new ModelAndView("signup");
			mav.addObject("newuser", new User());
			
			return mav;
			}

		 
		 
	

			/*ADD NEW USER*/
		 @RequestMapping(value="/insertuser" , method = RequestMethod.POST)
		 public ModelAndView insertUser( @Valid @ModelAttribute("newuser") User p , BindingResult bind)
		 {

				ModelAndView mav = new ModelAndView("signup");
				
				System.out.println("In User Insert");
				
				if(bind.hasErrors())
				{
					mav.addObject("newuser", p);
				}
				else
				{
					if( p.getPassword().equals(p.getCPassword()) )
					{
						List<User> list = as.getAllUsers();
						
						System.out.println(list);
						
						boolean usermatch= false;
						
						for( User u : list )
						{
							if( u.getUsername().equals(p.getUsername()) )
							{
								usermatch= true;
								break;
							}
						}
						
						if( usermatch == false )
						{
							as.insertUser(p);
							
							mav.addObject("newuser", new User());
							
							mav.addObject("success", "success");
						}	
						else
						{
							mav.addObject("newuser", p);
							
							mav.addObject("useralreadyexists", "useralreadyexists");
						}
					}
					else
					{	
						mav.addObject("newuser", p);
						
						mav.addObject("passwordmismatch", "passwordmismatch");
					}
						
				}
				
				return mav ;
			}
		
		 
		 @RequestMapping(value="/loginpage" , method = RequestMethod.GET)
			public ModelAndView login()
		 {
			 
	
				ModelAndView mav = new ModelAndView("login");
				
				return mav ;

		 
	}
		 
		 
		 @RequestMapping(value="/logout", method = RequestMethod.GET)
			public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
			    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			    if (auth != null){    
			        
			    	System.out.println("In LogOut");
			    	new SecurityContextLogoutHandler().logout(request, response, auth);
			        
			        
			    }
			    
			    return "index";
			}
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	}	 
				
	