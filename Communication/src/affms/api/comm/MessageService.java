package affms.api.comm;

import affms.api.search.SearchProcs;

import affms.core.Person;

import affms.util.Message;

import java.util.List;

public class MessageService {
    private List<Message> msgs;
    private Message msg;
    
    public MessageService() {
        super();
    }
    
    public Message getPerson(int id){
        MessageProcs comm = new MessageProcs();
        msg = comm.searchByID(id);
        return msg;
        
    }
    
    public List <Message> getMessages(){
         
        return msgs; 
    }

    public List <Message> getMessages(String mesg){
        MessageProcs comm = new MessageProcs();
        msgs = comm.searchByText(mesg);
        return msgs;
    }
    
    
}
