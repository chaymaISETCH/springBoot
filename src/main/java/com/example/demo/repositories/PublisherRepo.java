package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Publisher;

public interface PublisherRepo extends CrudRepository<Publisher, Long>{

}
