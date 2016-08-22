package com.krystalwatches;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.krystalwatches.CartModel.Cart;
import com.krystalwatches.CartModel.CartService;
import com.krystalwatches.ProductModel.Product;

import com.krystalwatches.ProductModel.ProductService;
import com.krystalwatches.UserModel.User;
import com.krystalwatches.UserModel.UserService;

import com.krystalwatches.UserRoleModel.UserRole;
import com.krystalwatches.UserRoleModel.UserRoleService;

@Controller
public class HelloController {

	@Autowired
	ProductService ps;

	@Autowired
	UserService as;

	@Autowired
	UserRoleService urs;

	@Autowired
	ServletContext context;

	@Autowired
	CartService cs;
	
	@Autowired
	JavaMailSender mail;

	@RequestMapping("/")
	public String main123() {
		urs.generateUserRoles();
		return "index";
	}
	
	@RequestMapping(value="/emailconfrm" , method = RequestMethod.POST)
	public String emailconfirm( HttpServletRequest req , HttpServletResponse resp ) {

		String uemail = req.getParameter("email");
		String subject = req.getParameter("subject");
		String msg = req.getParameter("message");
		
		System.out.println( uemail );
		System.out.println( subject );
		System.out.println( msg );

		SimpleMailMessage email = new SimpleMailMessage();
		
		email.setTo("krystalwatches@gmail.com");
		email.setSubject(uemail+":"+subject);
		email.setText(msg);

		try
		{
			mail.send(email);
			
			System.out.println("Mail 1 Sent");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

		String uemail1 = req.getParameter("email");


		System.out.println( uemail1 );
		
		
		email.setTo(uemail1);
		email.setSubject("Welcome to Krystal Watches");
		email.setText(" Thanks for Contacting Us \n We will get back to you soon \n\n Regards, \n The Krystal Watches Team");
		
		
		try
		{
			mail.send(email);
			
			System.out.println("Mail 2 Sent");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return "emailconfrm";
	}
	

	@RequestMapping("/index")
	public ModelAndView index() {

		ModelAndView mav = new ModelAndView("index");

		mav.addObject("data",
				"[" + "{\"ProductID\":\"1\",\"ProductName\":\"Beans\",\"ProductPrice\":\"1000\"},"
						+ "{\"ProductID\":\"2\",\"ProductName\":\"Jelly\",\"ProductPrice\":\"2000\"},"
						+ "{\"ProductID\":\"3\",\"ProductName\":\"Kaddu\",\"ProductPrice\":\"3000\"},"
						+ "{\"ProductID\":\"4\",\"ProductName\":\"Daddu\",\"ProductPrice\":\"4000\"}" + "]");

		return mav;

	}

	/* For Extracting all the data from the Database and show on PRODUCT page */
	@RequestMapping("/product")
	public ModelAndView abc() {

		ModelAndView mav = new ModelAndView("product");

		JSONArray jarr = new JSONArray();

		List<Product> list = ps.getAllProducts();

		for (Product p : list) {
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
	public String abt() {
		return "aboutus";
	}

	@RequestMapping("/contact_us")
	public String cnts() {
		return "contact_us";
	}

	@RequestMapping("/home")
	public String hme() {
		return "index";
	}

	/* PAGE ADDPRODUCT */

	@RequestMapping(value = "/addproduct")
	public ModelAndView addproduct() {
		ModelAndView mav = new ModelAndView("addproduct");
		mav.addObject("newproduct", new Product());

		return mav;
	}

	@RequestMapping(value = "/view/{productID}")
	public ModelAndView addproduct1(@PathVariable("productID") int prodid) {
		ModelAndView mav = new ModelAndView("view");

		System.out.println(prodid);

		Product p = ps.getProduct(prodid);

		if (p != null) {

			mav.addObject("ProductName", p.getProductName());
			mav.addObject("ProductDescription", p.getProductDescription());
			mav.addObject("ProductCategory", p.getProductCategory());
			mav.addObject("ProductPrice", p.getProductPrice());
			mav.addObject("ProductQty", p.getProductQty());
			mav.addObject("ProductImg", p.getProductImage());
			mav.addObject("ProductId", p.getProductId());
		}

		return mav;

	}

	/* DELETE */

	@RequestMapping(value = "/delete/{productID}")
	public String deleteproduct1(@PathVariable("productID") int prodid) {

		System.out.println(prodid);

		ps.deleteProduct(prodid);
		return "redirect:http://localhost:8080/krystalwatches/product";
	}

	/* INSERT PRODUCT */

	@RequestMapping(value = "/insertproduct", method = RequestMethod.POST)
	public String insertproduct(@ModelAttribute("newproduct") Product p) {
		System.out.println(p.getProductName());

		ps.insertProduct(p);

		Product i1 = ps.getProductWithMaxId();

		System.out.println(i1.getProductId());

		try {
			String path = context.getRealPath("/");

			System.out.println(path);

			File directory = null;

			// System.out.println(ps.getProductWithMaxId());

			if (p.getProductFile().getContentType().contains("image")) {
				directory = new File(path + "\\resources\\images");

				System.out.println(directory);

				byte[] bytes = null;
				File file = null;
				bytes = p.getProductFile().getBytes();

				if (!directory.exists())
					directory.mkdirs();

				file = new File(directory.getAbsolutePath() + System.getProperty("file.separator") + "image_"
						+ i1.getProductId() + ".jpg");

				System.out.println(file.getAbsolutePath());

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
				stream.write(bytes);
				stream.close();

			}

			i1.setProductImage("resources/images/image_" + i1.getProductId() + ".jpg");

			ps.updateProduct(i1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:product";
	}

	/* UPDATE */

	@RequestMapping(value = "/update/{productID}")
	public ModelAndView update(@PathVariable("productID") int prodid) {
		ModelAndView mav = new ModelAndView("update");

		System.out.println(prodid);

		Product p = ps.getProduct(prodid);

		mav.addObject("newproduct2", p);

		return mav;

	}

	@RequestMapping(value = "/updateproduct", method = RequestMethod.POST)
	public String insertproduct1(@ModelAttribute("newproduct2") Product p) {

		try {
			String path = context.getRealPath("/");

			System.out.println(path);

			File directory = null;

			// System.out.println(ps.getProductWithMaxId());

			if (p.getProductFile().getContentType().contains("image")) {
				directory = new File(path + "\\resources\\images");

				System.out.println(directory);

				byte[] bytes = null;
				File file = null;
				bytes = p.getProductFile().getBytes();

				if (!directory.exists())
					directory.mkdirs();

				file = new File(directory.getAbsolutePath() + System.getProperty("file.separator") + "image_"
						+ p.getProductId() + ".jpg");

				System.out.println(file.getAbsolutePath());

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
				stream.write(bytes);
				stream.close();

			}

			p.setProductImage("resources/images/image_" + p.getProductId() + ".jpg");

			ps.updateProduct(p);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:product";
	}

	/* SIGNUP PAGE */

	@RequestMapping(value = "/signup")
	public ModelAndView sgnup() {
		ModelAndView mav = new ModelAndView("signup");
		mav.addObject("newuser", new User());

		return mav;
	}

	/* ADD NEW USER */

	@RequestMapping(value = "/insertuser", method = RequestMethod.POST)
	public ModelAndView insertUser(@Valid @ModelAttribute("newuser") User p, BindingResult bind) {

		ModelAndView mav = new ModelAndView("signup");

		System.out.println("In User Insert");

		if (bind.hasErrors()) {
			mav.addObject("newuser", p);
		} else {
			if (p.getPassword().equals(p.getCPassword())) {
				List<User> list = as.getAllUsers();

				System.out.println(list);

				boolean usermatch = false;

				for (User u : list) {
					if (u.getUsername().equals(p.getUsername())) {
						usermatch = true;
						break;
					}
				}

				if (usermatch == false) {
					as.insertUser(p);

					mav.addObject("newuser", new User());

					mav.addObject("success", "success");
				} else {
					mav.addObject("newuser", p);

					mav.addObject("useralreadyexists", "useralreadyexists");
				}
			} else {
				mav.addObject("newuser", p);

				mav.addObject("passwordmismatch", "passwordmismatch");
			}

		}

		return mav;
	}

	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public ModelAndView login() {

		ModelAndView mav = new ModelAndView("login");

		return mav;

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {

			System.out.println("In LogOut");
			new SecurityContextLogoutHandler().logout(request, response, auth);

		}

		return "index";
	}

	/* FLOWS */

	@RequestMapping("page1")
	public ModelAndView page1() {
		ModelAndView mav = new ModelAndView("flows/page1");

		List<Cart> list = cs.getAllProduct();

		JSONArray jarr = new JSONArray();

		String user = "";

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && !auth.getName().equals("anonymousUser")) {
			user = auth.getName();
		}

		for (Cart item : list) {

			if (item.getUserName().equals(user)) {
				JSONObject jobj = new JSONObject();

				jobj.put("ProductID", item.getProductID());
				jobj.put("ProductName", item.getName());
				jobj.put("ProductPrice", item.getPrice());

				Product p = ps.getProduct(Integer.parseInt(item.getProductID()));

				jobj.put("ProductImage", p.getProductImage());
				jobj.put("ProductQty", item.getQty());

				jarr.add(jobj);
			}

		}

		System.out.println(jarr);

		mav.addObject("data", jarr.toJSONString());

		return mav;

	}

	@RequestMapping(value = "/addToCart")
	public String addToCart(HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && !auth.getName().equals("anonymousUser")) {
			System.out.println(request.getParameter("pid"));
			System.out.println(request.getParameter("pqty"));

			int qty = 1;

			try {
				qty = Integer.parseInt(request.getParameter("pqty"));

				if (!(qty >= 1 && qty <= 10))
					throw new Exception();
			} catch (Exception e) {
				System.out.println("Invalid Qty");
			}

			Cart c = new Cart();

			c.setProductID(request.getParameter("pid"));
			c.setQty("" + qty);

			Product p = ps.getProduct(Integer.parseInt(request.getParameter("pid")));

			c.setName(p.getProductName());
			c.setPrice(p.getProductPrice());

			c.setUserName(auth.getName());

			cs.add(c);

		}

		return "redirect:initiateFlow";

	}

	@RequestMapping("page2")
	public String flow1() {
		return "flows/page2";
	}

	@RequestMapping("page3")
	public String flow3() {
		return "flows/page3";
	}

	@RequestMapping("page4")
	public String flow4() {
		return "flows/page4";
	}

	@RequestMapping("head-meta")
	public String head_meta() {
		return "head-meta";
	}

	@RequestMapping("head")
	public String head() {
		return "head";
	}
	/////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/initiateFlow", method = RequestMethod.GET)
	public String redirect(HttpServletRequest request) {

		String retval = "";

		if (request.getUserPrincipal() == null)
			retval = "redirect:/cart?user=none";
		else
			retval = "redirect:/cart?user=" + request.getUserPrincipal().getName();

		return retval;
	}

	public String test() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && !auth.getName().equals("anonymousUser")) {
			System.out.println(auth.getName());
			// System.out.println("User present");
			return "false";
		} else {
			System.out.println("User not present");
			return "true";
		}

	}

	
	
	
	
	
	
	
	
	/*For admin to see the user base*/
	
	@RequestMapping("/userbase")
	public ModelAndView abc1() {

		ModelAndView mav = new ModelAndView("userbase");

		JSONArray jarr = new JSONArray();

		List<User> list = as.getAllUsers();

		for (User u : list) {
			JSONObject jobj1 = new JSONObject();

			jobj1.put("Email",u.getEmail() );
			jobj1.put("Username", u.getUsername());
			jobj1.put("Phone", u.getPhone());
			jobj1.put("Password", u.getPassword());
			jobj1.put("Role", u.getRole());
			
			
			jarr.add(jobj1);
		}

		mav.addObject("data1", jarr.toJSONString());

		return mav;

	}

	/* UPDATE User role*/
/*	@RequestMapping(value = "/update/{Username}")
	public ModelAndView update(@PathVariable("Username") int prod) {
		ModelAndView mav = new ModelAndView("update");

		System.out.println("prod");

		Product p = as.getUser(prodid);

		mav.addObject("newproduct2", p);

		return mav;

	}

	
	
	
	@RequestMapping("userbase")
	public ModelAndView userbase() {
		ModelAndView mav = new ModelAndView("userbase");

		List<User> list = as.getAllUsers();

		JSONArray jarr = new JSONArray();

		String user = "";

		for (User u : list) {

			if (u.getUsername().equals(user)) {
				JSONObject jobj = new JSONObject();


				jobj.put("Email",u.getEmail() );
				jobj.put("Username", u.getUsername());
				jobj.put("Phone", u.getPhone());
				jobj.put("Password", u.getPassword());
				
			
User p = as.getUser(u.getUsername());
				
				jobj.put("Role", p.getRole());

				jarr.add(jobj);
			}

		}

		System.out.println(jarr);

		mav.addObject("data", jarr.toJSONString());

		return mav;

	}

*/
}