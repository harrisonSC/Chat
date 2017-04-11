package chat.entities;

import java.util.Calendar;

public class Channel {

	//[{"language":"en","id":"1490212448.19","accountcode":"","name":"SIP/192.168.3.187-0000000c","caller":{"name":"192.168.3.187","number":"1921683187"},"connected":{"name":"","number":""},"state":"Up","dialplan":{"context":"default","exten":"*11141611404011998884534","priority":1},"creationtime":"2017-03-22T16:54:08.418-0300"}]

	private String language;
	private Long id;
	private String accountcode;
	private String name;
	private Caller caller;
	private Connected connected;
	private String state;
	private Dialplan dialplan;
	private Calendar creationtime;
	
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountcode() {
		return accountcode;
	}
	public void setAccountcode(String accountcode) {
		this.accountcode = accountcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Caller getCaller() {
		return caller;
	}
	public void setCaller(Caller caller) {
		this.caller = caller;
	}
	public Connected getConnected() {
		return connected;
	}
	public void setConnected(Connected connected) {
		this.connected = connected;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Dialplan getDialplan() {
		return dialplan;
	}
	public void setDialplan(Dialplan dialplan) {
		this.dialplan = dialplan;
	}
	public Calendar getCreationtime() {
		return creationtime;
	}
	public void setCreationtime(Calendar creationtime) {
		this.creationtime = creationtime;
	}
	
	
}
