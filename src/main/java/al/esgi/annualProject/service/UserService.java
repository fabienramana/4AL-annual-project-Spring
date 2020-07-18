package al.esgi.annualProject.service;

import al.esgi.annualProject.models.User;
import al.esgi.annualProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;
    
    public String addNewUser(User u){
        userRepository.save(u);
        return "Saved";
    }
    
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
}
