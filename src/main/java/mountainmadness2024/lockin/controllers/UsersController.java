package mountainmadness2024.lockin.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mountainmadness2024.lockin.models.Users;
import mountainmadness2024.lockin.models.UsersRepository;
import java.util.List;
import java.util.Map;

@Controller
@Scope("session")   
public class UsersController {
    
    @Autowired
    private UsersRepository userRepo;

    // add new user (signup) function
    // if the input username already exists in the system then the user is direction to an error page
    // If successful signup, user starts with 0 total lockinTime and is assigned a uid by Users.java
    //
    @PostMapping("/users/add")
    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response){
        
        System.out.println("ADD user");
        String newName = newuser.get("username");
        String newPass = newuser.get("password");
        
        List<Users> users = userRepo.findByName(newName);

        if (users.isEmpty() == true){
            userRepo.save(new Users(newName,newPass, 0));
            response.setStatus(201);
            return "users/newUser";
        }
        else{
            return "users/existingUser";
        }
        
    }

    //succesful login leads User to timer page.
    //
    @PostMapping("/login")
    public String login(@RequestParam Map<String,String> formData, Model model, HttpServletRequest request, 
                                                                                        HttpSession session){
        
        String name = formData.get("username");
        String pwd = formData.get("password");
        List<Users> userlist = userRepo.findByNameAndPassword(name, pwd);

        // wrong info or nonexistant info means try again.
        if (userlist.isEmpty()){
            return "users/login";
        }
        else {
            
            Users user = userlist.get(0);
            request.getSession().setAttribute("session_user", user);
            model.addAttribute("user", user);
            return "users/protected";
        }
    }

}
