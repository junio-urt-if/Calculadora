package br.com.ifurt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifurt.exception.ResourceNotFoundException;
import br.com.ifurt.model.Person;
import br.com.ifurt.repository.PersonRepository;

@Service
public class PersonServices {
	

	@Autowired
	PersonRepository repository;
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public List<Person> findAll() {
		return repository.findAll();
	}
	
	public Person findById(Long id) {
		// vamos gerar a exceção e enviar direto ao usário sem muita informação
		//return repository.findById(id).orElseThrow();
		// vamos gerar a exceção específica -> fazer o callback
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}
	

	public Person update(Person person) {
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}	
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		repository.delete(entity);
	}

}

