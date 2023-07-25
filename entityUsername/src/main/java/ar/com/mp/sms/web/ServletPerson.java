package ar.com.mp.sms.web;

import ar.com.mp.sms.domain.Person;
import ar.com.mp.sms.service.ServicePerson;
import java.io.IOException;
import java.util.*;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/this_Persons")
public class ServletPerson extends HttpServlet {
 @Inject
 
 ServicePerson servicePerson;
 
    @Override 
 //This methoid acces to the list og persons trought the instance ejb
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException{
      List<Person> persons = servicePerson.ListOfPersons();
      //In this way I access to the ejb using the local interface
      System.out.println("persons: " + persons);// So I can see it in the console of the Glassfish server
      //I put the variable person in the scope
        request.setAttribute("persons",persons);
      //Request dispatcher to redirect to the JSP that shows this list of persons
       request.getRequestDispatcher("/listOfPersons.jsp").forward(request, response);
       //resending the objects of request and response so I can access to the ionformation in the scope of request where I put the collection of persons got it from the local ejb 
 
 
 
 
 } 
 
 
}
