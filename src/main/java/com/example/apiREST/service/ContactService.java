package com.example.apiREST.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.apiREST.model.Contact;

public interface ContactService {
	public abstract List<Contact> findAll();
	public abstract ResponseEntity findById( long id);
	public abstract Contact createContact(Contact contact);
	public abstract ResponseEntity updateContact(long id, Contact contact);
	public abstract ResponseEntity deleteContact(long id);
	

}
