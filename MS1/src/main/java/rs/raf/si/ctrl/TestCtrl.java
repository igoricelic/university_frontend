package rs.raf.si.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import rs.raf.si.dto.Sum;
import rs.raf.si.dto.User;
import rs.raf.si.service.Ms2Service;

@RestController
public class TestCtrl {
	
	@Autowired
	private Ms2Service ms2Service;
	
	@PostMapping(path = "/addUser")
	public @ResponseBody User addUser(@RequestBody User user) {
		return ms2Service.addUser(user);
	}
	
	@GetMapping(path = "/getUsers")
	public @ResponseBody List<User> getUsers() {
		return ms2Service.getUsers();
	}

}
