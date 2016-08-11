 package com.krystalwatches;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.krystalwatches.CartModel.Cart;
import com.krystalwatches.CartModel.CartService;
import com.krystalwatches.ProductModel.Product;

import com.krystalwatches.ProductModel.ProductService;
import com.krystalwatches.UserModel.UserService;

import com.krystalwatches.UserRoleModel.UserRoleService;

@CrossOrigin(origins="http://localhost8080" , maxAge=3600)
@RestController
public class RESTHelloController 
	{
	
		@Autowired
		ProductService ps;
	
		@Autowired
		UserService as;	
	
		@Autowired
		UserRoleService	urs;
	
		@Autowired
		ServletContext context;
	
		@Autowired
		CartService cs;
	
	@CrossOrigin
    @RequestMapping(value = "/flows/deleteFromCart/", method = RequestMethod.POST)
    public ResponseEntity<String> deleteFromCart(HttpServletRequest request, HttpServletResponse response, @RequestBody String inputdata, UriComponentsBuilder ucBuilder) 
	{
        
		int cartId = Integer.parseInt(inputdata);
		
		cs.delete(cartId);
		
		List<Cart> list = cs.getAllProduct();
		
		JSONArray jarr = new JSONArray();
		
		String user = "";
		
		System.out.println("In Fetch All Items");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	if (auth != null && !auth.getName().equals("anonymousUser"))
	    	{    
	    		user = auth.getName();
	    	}
		
	    	for( Cart item:list )
	    	{
			
			if( item.getUserName().equals(user) )
				{
					JSONObject jobj = new JSONObject();
				
					jobj.put("ProductID", item.getProductID() );
					jobj.put("ProductName", item.getName() );
					jobj.put("ProductPrice", item.getPrice() );
					Product p = ps.getProduct( Integer.parseInt(item.getProductID()) );
				
					jobj.put("ProductImage", p.getProductImage());
					jobj.put("ProductQty", item.getQty());
					jobj.put("CartId", item.getID());
				 
					jarr.add(jobj);
			}
			
		 }
		 
		System.out.println(jarr);
		
        return new ResponseEntity<String>(jarr.toString(), HttpStatus.CREATED);
    }
	
	@CrossOrigin
    @RequestMapping(value = "/flows/fetchAllItems/", method = RequestMethod.POST)
    public ResponseEntity<String> fetchAllItems(HttpServletRequest request, HttpServletResponse response, UriComponentsBuilder ucBuilder) {
        
		List<Cart> list = cs.getAllProduct();
		
		JSONArray jarr = new JSONArray();
		
		String user = "";
		
		System.out.println("In Fetch All Items");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && !auth.getName().equals("anonymousUser"))
	    {    
	    	user = auth.getName();
	    }
		
		for( Cart item:list )
		{
			
			if( item.getUserName().equals(user) )
			{
				JSONObject jobj = new JSONObject();
				
				jobj.put("ProductID", item.getProductID() );
				jobj.put("ProductName", item.getName() );
				jobj.put("ProductPrice", item.getPrice() );
				
				Product p = ps.getProduct( Integer.parseInt(item.getProductID()) );
				
				jobj.put("ProductImage", p.getProductImage());
				jobj.put("ProductQty", item.getQty());
				jobj.put("CartId", item.getID());
				 
				jarr.add(jobj);
			}
			
		 }
		 
		System.out.println(jarr);
		
        return new ResponseEntity<String>(jarr.toString(), HttpStatus.CREATED);
    }

}
