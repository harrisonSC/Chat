package chat.entities;

public class Dialplan {

	//[{"language":"en","id":"1490212448.19","accountcode":"","name":"SIP/192.168.3.187-0000000c","caller":{"name":"192.168.3.187","number":"1921683187"},"connected":{"name":"","number":""},"state":"Up","dialplan":{"context":"default","exten":"*11141611404011998884534","priority":1},"creationtime":"2017-03-22T16:54:08.418-0300"}]

	private String context;
	private String exten;
	private String priority;
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getExten() {
		return exten;
	}
	public void setExten(String exten) {
		this.exten = exten;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}	
	
	
	
}
