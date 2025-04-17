package com.healthcareApp.service;

import com.healthcareApp.model.Person;
import com.healthcareApp.repository.PersonRepository;
import lombok.*;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class PersonService {

    private static final Scanner scanner = new Scanner(System.in);

    private static PersonRepository personRepository = new PersonRepository();

    void printPerson(Person person){
        System.out.println(person);
    }

    public boolean createPerson(Person person){
        return false;
    }

    public List<Person> displayPerson(){
        return displayPerson();
    }

    public boolean updatePerson(int personId,String firstName){
        return false;
    }

    public boolean deletePerson(int personId){
        return false;
    }
}
