package ar.com.mp.sms.service;

import ar.com.mp.sms.domain.Person;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ServicePerson {
        public List<Person> ListOfPersons();
    
    public Person findOPersonByID(Person person);
    
    public Person findPersonByEmail(Person person);
    
    public void addPerson(Person person);
    
    public void modifyPerson(Person person);
    
    public void deletePerson(Person person);
}
