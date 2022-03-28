package com.example.apiREST.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apiREST.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {}


