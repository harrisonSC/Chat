package chat.entities;

public class Caller {

	//[{"language":"en","id":"1490212448.19","accountcode":"","name":"SIP/192.168.3.187-0000000c","caller":{"name":"192.168.3.187","number":"1921683187"},"connected":{"name":"","number":""},"state":"Up","dialplan":{"context":"default","exten":"*11141611404011998884534","priority":1},"creationtime":"2017-03-22T16:54:08.418-0300"}]

	private String name;
	private String number;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
