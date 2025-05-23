
package com.healthcareApp.controller;

import com.healthcareApp.model.Person;
import com.healthcareApp.service.PersonService;
import lombok.*;

import java.sql.SQLException;
import java.util.Scanner;



@AllArgsConstructor
@Data
public class PersonController {

    private static final Scanner scanner = new Scanner(System.in);

    private PersonService personService;

    public void run() throws SQLException {

        Person person = new Person();

        int option;

        do{
            System.out.println("---Person Information----");
            System.out.println("1.Create person");
            System.out.println("2.Retrieve Person");
            System.out.println("3.Update Person");
            System.out.println("4.Delete Person");
            System.out.println("0.Returning to Main Menu");

            System.out.println("select the option below:");
            option=Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    personService.createPerson();
                    break;

                case 2:
                    personService.displayPerson();
                    break;

                case 3:
                    personService.updatePerson(person.getPersonId(), person.getFirstName());
                    break;

                case 4:
                    personService.deletePerson(person.getPersonId());
                    break;

                case 0:
                    System.out.println("Returning to Main menu.");
                    break;

                default:
                    System.out.println("invalid input !!!");
            }

        }while(option!=0);{
            System.out.println("Thank You!!!");
        }
    }
}
