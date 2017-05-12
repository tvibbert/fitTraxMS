package affms.api.search;

import affms.core.Person;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/search")
@Consumes("application/json")
@Produces("application/json")
public class SearchResource {
  SearchService searchService = new SearchService();

    @GET
    @Path("/{ssid}")
    public Person getPerson(@QueryParam("ssid") String ssid){
      Person person = searchService.getPerson(ssid);
      return person;
  }

    @GET
    @Path("/{firstname,lastname}")
    public List <Person> getPeopleByName(@QueryParam("firstname") String firstname,
                                        @QueryParam("lastname") String lastname){
      List <Person> people = searchService.getPeople(firstname, lastname);
      return people;
  }

    @GET
    @Path("/{pascodes}")
    public List <Person> getPeopleByPascodes(@QueryParam("pascodes") List<String> pasocodes){
        List <Person> people = searchService.getPeople(pasocodes);
        return people;
    }
  
  
}
