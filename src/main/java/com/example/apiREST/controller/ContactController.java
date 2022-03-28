package com.example.apiREST.controller;

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

import com.example.apiREST.model.Contact;
import com.example.apiREST.repository.ContactRepository;
import com.example.apiREST.service.ContactService;

@RestController
@RequestMapping({"/contacts"})
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	@GetMapping
	public List findAll(){
	   return contactService.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable long id){
		   return contactService.findById(id);
		}
	@PostMapping
	public Contact create(@RequestBody Contact contact){
		   return contactService.createContact(contact);
		}
	
	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable("id") long id,
	                                      @RequestBody Contact contact) {
	   return contactService.updateContact(id, contact);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable long id) {
	   return contactService.deleteContact(id);
	}

	
	
}
