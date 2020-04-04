package com.id.taqi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.id.taqi.entity.User;
import com.id.taqi.services.UserService;

@RestController
public class UserController {

	@Autowired(required = true)
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> getUser() {
        return userService.getAll();
    }
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> saveUser(@RequestBody User u) {
		userService.saveOrUpdate(u);

        Map<String, Object> m = new HashMap<>();
        m.put("Success", Boolean.TRUE);
        m.put("Info", "Data Tersimpan");

        return m;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> updateUser(@RequestBody User u) {
    	userService.saveOrUpdate(u);
        Map<String, Object> m = new HashMap<>();
        m.put("Success", Boolean.TRUE);
        m.put("Info", "Data Berhasil di update");
        return m;
    }

    @RequestMapping(value = "/user/{id_user}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> deleteUser(@PathVariable("id_user") Integer id_user) {
    	userService.remove(userService.findById(id_user));
        Map<String, Object> m = new HashMap<>();
        m.put("Success", Boolean.TRUE);
        m.put("Info", "Data Berhasil di hapus");

        return m;
    }
}
