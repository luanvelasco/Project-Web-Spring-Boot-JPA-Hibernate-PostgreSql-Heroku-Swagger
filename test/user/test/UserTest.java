package user.test;

import com.lvm.workshops.entities.User;

public class UserTest {

	public static void main(String[] args) {


		User user = new User(1L, "Luan Velasco", "luanvelasco@gmail.com", "9999999", "sd5425");
		
		System.out.println("userId: " + user.getId());
		System.out.println("userName: " + user.getName());
		System.out.println("userMail: " + user.getEmail());
		System.out.println("userTelephone: " + user.getTelephone());
		System.out.println("userPassword: " + user.getPassword());

	}

}
