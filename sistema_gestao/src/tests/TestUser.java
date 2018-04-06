package tests;

import users.Graduation;
import users.Teacher;
import users.User;

public class TestUser {
	public static void main(String[] args) {
		User user = new Graduation("Doge", "doge@ic.ufal.br");
		User user1 = new Teacher("Willy","willy@ic.ufal.br");
		System.out.println(user);
		System.out.println(user1);
		if (user1 instanceof Teacher ){
			System.out.println("user1 is a Teacher");
		}
	}
}
