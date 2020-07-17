package al.esgi.annualProject.service;

import al.esgi.annualProject.repository.CommentariesRepository;
import al.esgi.annualProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentariesService {
    private final CommentariesRepository commentariesRepository;
    
    @Autowired
    public CommentariesService(CommentariesRepository commentariesRepository) {
        this.commentariesRepository = commentariesRepository;
    }
}
