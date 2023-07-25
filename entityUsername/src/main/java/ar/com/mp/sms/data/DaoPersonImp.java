package ar.com.mp.sms.data;


import ar.com.mp.sms.domain.Person;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;



@Stateless//this class has to be an EJB so can be inyected the Entity Manager of JPA(Persistence Unit)
public class DaoPersonImp implements DaoPerson {
       @PersistenceContext(unitName="PersonPU")
        EntityManager em;

    @Override
    public List<Person> findAllPersons() {
        return em.createNamedQuery("Person.findAll").getResultList();
    }

    @Override
    public Person findPrsById(Person person) {
         return em.find(Person.class, person.getIdPerson());
    }

    @Override
    public Person findPrsByEmail(Person person) {
        Query query= em.createQuery("FROM Person p where p.email =: email"); //This query will take all the objects Person but only the ones that match with the email
        query.setParameter("email", person.getEmail());//Stablish the parameter and the value of this one
        // Parameter = email; value of the parameter = person.getEmail() 
        
        return (Person) query.getSingleResult(); // single result because I'm expecting only 1 result
        //email has to be stablis as UNIQUE value in the DB
    }

    @Override
    public void insertPers(Person person) {
        em.persist(person);
        
    }

    @Override
    public void updatePrs(Person person) {
        em.merge(person);
    }

    @Override
    public void deletePrs(Person person) {
         em.remove(em.merge(person));//first I have to merge the status of the ofcject  to sync and update with th DB
         //Later I delete it
    }
   
}
