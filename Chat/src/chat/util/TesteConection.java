package chat.util;
import java.net.URISyntaxException;
import java.util.List;

import ch.loway.oss.ari4java.ARI;
import ch.loway.oss.ari4java.AriVersion;
import ch.loway.oss.ari4java.generated.Channel;
import ch.loway.oss.ari4java.tools.ARIException;

public class TesteConection {
	static	AriFactory ari = new AriFactory();
	static List current_channels = null;
	public static void main(String[] args) throws ARIException, URISyntaxException {
		AriVersion ariVersion = null;
		//ActionChannels_impl_ari_1_9_0 chanel = null;
		//chanel = new ActionChannels_impl_ari_1_9_0();
		ARI ariaux = ari.nettyHttp("http://192.168.3.108:8088", "asterisk", "asterisk", ariVersion.ARI_1_9_0);
		 current_channels = ariaux.channels().list();
		if(current_channels.isEmpty()){
			System.out.println("Nenhum channel Corrente");
		}
		else {
			System.out.println("channels Corrente:");
			List<Channel> _list = ariaux.channels().list();
			for(Channel channel: _list  ){
				System.out.println( "Numero :" + channel.getCaller().getNumber());
				System.out.println( "Senha :" + channel.getDialplan().getExten());
			}
		
	}
		
	}}
