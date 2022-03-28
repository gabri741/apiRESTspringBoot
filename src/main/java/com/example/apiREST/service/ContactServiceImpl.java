package com.example.apiREST.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.apiREST.model.Contact;
import com.example.apiREST.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	private ContactRepository repository;
	
	ContactServiceImpl(ContactRepository contactRepository){
		this.repository = contactRepository;
		
	}
	
	@Override
	public List findAll() {
		return repository.findAll();
	}
	
	@Override
	public ResponseEntity findById(long id) {
		 return repository.findById(id)
				 .map(record->ResponseEntity.ok().body(record))
				 .orElse(ResponseEntity.notFound().build());
	}
	
	@Override
	public Contact createContact( Contact contact){
		   return repository.save(contact);
		}

	@Override
	public ResponseEntity updateContact(long id, Contact contact) {
		return repository.findById(id)
		           .map(record -> {
		               record.setName(contact.getName());
		               record.setEmail(contact.getEmail());
		               record.setPhone(contact.getPhone());
		               Contact updated = repository.save(record);
		               return ResponseEntity.ok().body(updated);
		           }).orElse(ResponseEntity.notFound().build());
		
	}

	@Override
	public ResponseEntity deleteContact(long id) {
		return repository.findById(id)
		           .map(record -> {
		               repository.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
		
	}
	
	
	
}
