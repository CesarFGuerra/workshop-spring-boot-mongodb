package com.cesarfranca.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesarfranca.workshopmongo.domain.Post;
import com.cesarfranca.workshopmongo.repository.PostRepository;
import com.cesarfranca.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;


	public Post findById(String id) {
		Optional<Post> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullsearch(String text, Date minDate, Date maxDate){
		//formula feita para acrescentar um dia a data inserida
		maxDate = new Date(maxDate.getTime() + 8460*1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
