package user.test;

import com.lvm.workshops.entities.User;

public class UserTest {

	public static void main(String[] args) {


		User user = new User(1L, "Luan Velasco", "luanvelasco@gmail.com", "24992263663", "sd5425");
		
		System.out.println("userId: " + user.getId());
		System.out.println("userName: " + user.getName());
		System.out.println("userMail: " + user.getEmail());
		System.out.println("userTelephone: " + user.getTelephone());
		System.out.println("userPassword: " + user.getPassword());

		Long id = 2L;
		String name = "Robert Half";
		String email = "rh@gmail.com";
		String telephone = "11951547885";
		String password = "7r8aav97";
		
		User user1 = new User(id, name, email, telephone, password);
		
		
		System.out.println("userId: " + user1.getId());
		System.out.println("userName: " + user1.getName());
		System.out.println("userMail: " + user1.getEmail());
		System.out.println("userTelephone: " + user1.getTelephone());
		System.out.println("userPassword: " + user1.getPassword());
		
		
	}

}
