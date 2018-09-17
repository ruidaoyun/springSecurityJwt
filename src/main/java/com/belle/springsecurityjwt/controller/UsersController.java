package com.belle.springsecurityjwt.controller;


import com.belle.springsecurityjwt.model.dto.JSONResult;
import com.belle.springsecurityjwt.model.entity.Users;
import com.belle.springsecurityjwt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private HttpServletResponse response;

    @GetMapping()
    public List<Users> getAll(){


        return usersService.getAll ();
    }

    @Secured("normal")
    @GetMapping("{id}")
    public Users getUserById(@PathVariable("id")Integer id){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return usersService.getUserById (id);
    }

    /*@GetMapping()
    public Users getUserByName(@RequestParam("name") String name){
        return usersService.getUserByName (name);
    }*/

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id")Integer id){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Integer i=usersService.deleteUsersById (id);

        if (i>0){
            return JSONResult.fillResultString (0,"delete ",null);
        }
       return JSONResult.fillResultString (1,"delete failed",null);
    }

    @PostMapping
    public String insert( Users users){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Integer i=usersService.insertUsers (users);
        if (i>0){
            return JSONResult.fillResultString (0,"insert success",null);
        }
        return  JSONResult.fillResultString (1,"insert failed",null);

    }

    @PutMapping("{id}")
    public String update(
            @PathVariable Integer id,
            @RequestBody Users users){
        response.setHeader("Access-Control-Allow-Origin", "*");
        users.setId (id);
        System.out.println (users);
        Integer i=usersService.updateUsers (users);
        if (i>0){
            return JSONResult.fillResultString (0,"update success",null);
        }
        return  JSONResult.fillResultString (1,"update failed",null);
    }
}
