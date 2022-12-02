package com.api.crud.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.entity.Customers;
import com.api.crud.exception.customerexception;
import com.api.crud.repository.customerrepository;

@RestController
@RequestMapping("/api/cus")
public class customercontroller {

	@Autowired
	private customerrepository cusrepo;
	
	
	//get all customer
	@GetMapping
	public List<Customers> getallcustomers(){
		
		return this.cusrepo.findAll();
		
	}
	
	//add customers
	@PostMapping
	public Customers addcustomers(@RequestBody Customers cus) {
		
		
		
		return this.cusrepo.save(cus);
		
	}
	
	//update customers
	@PutMapping("/{id}")
	public Customers updatecustomers(@RequestBody Customers cus,@PathVariable("id")long cusid) {
		
		Customers existingcus=this.cusrepo.findById(cusid).orElseThrow(()->new customerexception("ID Mismatch"));
		
		existingcus.setCustomername(cus.getCustomername());;
		existingcus.setCustomeraddress(cus.getCustomeraddress());;
		existingcus.setPhnnumber(cus.getPhnnumber());;
		
		return this.cusrepo.save(existingcus);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Customers> deletecustomers(@PathVariable("id") long cusid)
	{
		Customers existingcus=this.cusrepo.findById(cusid).orElseThrow(()->	new customerexception("ID Mismatch"));
		
		this.cusrepo.delete(existingcus);
		
		return ResponseEntity.ok().build();
				
	}
	
}
