package mountainmadness2024.lockin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import mountainmadness2024.lockin.models.Users;
import mountainmadness2024.lockin.models.UsersRepository;

@Controller
@Scope("session")   
public class UsersController {
    
    @Autowired
    private UsersRepository userRepo;

}
