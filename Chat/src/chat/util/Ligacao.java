package chat.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;



public class Ligacao {
	
    private  final String server = "192.168.3.108";
    private  final String user = "manager";
    private  final String password = "senha";
    private  final int port = 5060;
    private  Socket socket;
    private  DataOutputStream wr;
 
    private  DataInputStream read;
    

    
    public  void chamar(String telefone,String la,String server,int port,String user, String password,List<String> variables) throws IOException {
    	
    	try{
        login( server, port, user,  password);
        dial( telefone,la, variables);
            
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    }
    
    
    private  void login(String server,int port,String user, String password) throws IOException {
	     

    	
        connect(server, port);
        send("Action: Login\r\n");
        send("username: " + user + "\r\n");
        send("secret: " + password + "\r\n");
        send("ActionID: 1\r\n");
        send("\r\n");
    }
    private  void dial(String extension, String number, List<String> variables)
            throws IOException {
    	String _variables="";
    	_variables = "Variable: CALLERID(DNID)="+ number + "\r\n"; 
    			    //+"Variable: conferencia=entrar\r\n";
    	for(String variable : variables){
    		_variables = _variables +  "Variable: " +variable + "\r\n";
    	}
    	
 
    	String _send =
    	"Action: Originate\r\n";
    	if (extension.contains("192.")){
    		_send = _send +	"Channel: SIP/" + extension +"\r\n";
    	}else{
    		_send = _send + "Channel: SIP/0" + extension +"@supportcomm\r\n";
    	}
    	_send = _send + "Exten: " + number + "\r\n"+
        "Context: default\r\n"+
        "Priority: 1\r\n"+
        _variables +
       
       // "Variable: CALLERID(DNID)="+ number + " \r\n"+
        
        
        
        
        
        "GET VARIABLE DIALSTATUS \r\n"+
        "Async: no\r\n\r\n";
     
    	  DataOutputStream retorno = send(_send);		
    	 System.out.println( retorno.toString());
    	
        
    }
    private   DataOutputStream send(String request) 
                     throws IOException {
 
        this.wr.writeBytes(request);
        
        return this.wr;
        
        
    }
 
    private  void connect(String server, int port) 
                     throws IOException {
 
        InetAddress addr = InetAddress.getByName(server);
        SocketAddress sockaddr = new InetSocketAddress(addr, port);
        socket = new Socket();
        socket.connect(sockaddr);
        wr = new DataOutputStream(socket.getOutputStream());
        read = new DataInputStream( socket.getInputStream());
    }

}
