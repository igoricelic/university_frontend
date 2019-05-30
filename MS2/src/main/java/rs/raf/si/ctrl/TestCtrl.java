package rs.raf.si.ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rs.raf.si.dto.User;

@RestController
public class TestCtrl {
	
	private Random random = new Random();
	
	private List<User> users = new ArrayList<>();
	
	@PostMapping(path = "/addUser")
	public @ResponseBody User addUser(@RequestBody User user) {
		String fullName = user.getFirstName() + " " + user.getLastName();
		user.setFullName(fullName);
		user.setRandomNumber(random.nextInt(1000));
		this.users.add(user);
		System.out.println("Dodao novog usera: "+user.toString());
		return user;
	}
	
	@GetMapping(path = "/getUsers")
	public @ResponseBody List<User> getUsers() {
		return users;
	}

}
