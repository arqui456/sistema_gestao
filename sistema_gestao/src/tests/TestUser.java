package tests;

import users.User;

public class TestUser {
	public static void main(String[] args) {
		User user = new User("Arquimedes", "avpfm@ic.ufal.br", false, "graduacao");
		System.out.println(user);
	}

}
