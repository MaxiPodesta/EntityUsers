package ar.com.mp.sms.service;

import ar.com.mp.sms.data.DaoPerson;
import ar.com.mp.sms.domain.Person;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;



@Stateless
public class PersonServiceImp implements  ServicePerson{
    @Inject//this injection is done once the app is under EE field and the app is deploy in the server
    private DaoPerson daoPerson;//I have access to the data field
    @Override
    public List<Person> ListOfPersons() {//I do it in hard code just for the example
          return daoPerson.findAllPersons();
    }
// Ican call configure the methods like this because the one that has to relate with the DB is the Data layer 
    @Override
    public Person findOPersonByID(Person person) {
      return daoPerson.findPrsById(person);
    }

    @Override
    public Person findPersonByEmail(Person person) {
        return daoPerson.findPrsByEmail(person);
    }

    @Override
    public void addPerson(Person person) {
        daoPerson.insertPers(person);
    }

    @Override
    public void modifyPerson(Person person) {
          daoPerson.updatePrs(person);
    }

    @Override
    public void deletePerson(Person person) {
         daoPerson.updatePrs(person);
    }
    
}
