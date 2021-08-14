package com.dio.santander.peopleapi.service;

import com.dio.santander.peopleapi.dto.request.PersonDTO;
import com.dio.santander.peopleapi.dto.response.MessageResponseDTO;
import com.dio.santander.peopleapi.entity.Person;
import com.dio.santander.peopleapi.mapper.PersonMapper;
import com.dio.santander.peopleapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO.builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

}
