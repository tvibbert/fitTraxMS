package affms.api.search;

import affms.core.Person;


import java.util.List;


public class SearchService {
    private List <Person> people;
    private Person person = null;
    
    public SearchService() {
        super();
    }
    
    public Person getPerson(String ssid){
        SearchProcs search = new affms.api.search.SearchProcs();
        person = search.searchBySSID(ssid);
        return person;
        
    }

    public List <Person> getPeople(){
         
        return people; 
    }

    public List <Person> getPeople(String firstname,String lastname){
        SearchProcs search = new affms.api.search.SearchProcs();
        people = search.searchByName(firstname, lastname);
        return people;
    }

    public List<Person> getPeople(List<String> pascodes){
        SearchProcs search = new affms.api.search.SearchProcs();
        people = search.searchByPASCode(pascodes);
        return people;
    }
}
