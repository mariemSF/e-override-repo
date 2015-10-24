package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.AServicesRemote;


public class TestHello {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Context context = new InitialContext();
		AServicesRemote proxy = (AServicesRemote) context
				.lookup("/e-override-ejb/AServices!services.interfaces.AServicesRemote");

		System.out.println(proxy.SayHello("mariem"));
	}

}
