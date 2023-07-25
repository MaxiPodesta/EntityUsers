
package ar.com.mp.sms.data;

import ar.com.mp.sms.domain.Person;
import java.util.List;

public interface DaoPerson {
  public List<Person> findAllPersons();
  
  public Person findPrsById (Person person);
  
  public Person findPrsByEmail(Person person);
  
  public void insertPers(Person person); 
  
  public void updatePrs(Person person);
  
  public void deletePrs(Person person); 
}
