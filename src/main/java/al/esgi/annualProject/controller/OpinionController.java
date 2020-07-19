package al.esgi.annualProject.controller;

import al.esgi.annualProject.models.Movie;
import al.esgi.annualProject.models.Opinion;
import al.esgi.annualProject.models.User;
import al.esgi.annualProject.repository.MovieRepository;
import al.esgi.annualProject.repository.OpinionRepository;
import al.esgi.annualProject.repository.UserRepository;
import al.esgi.annualProject.service.MovieService;
import al.esgi.annualProject.service.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/opinion")
public class OpinionController {
    OpinionService opinionService;
    public OpinionController(OpinionService opinionService){
        this.opinionService = opinionService;
    }
    

    @PostMapping(path="/add")
    public Opinion addNewOpinion(@RequestBody Opinion opinion){
        return opinionService.addNewOpinion(opinion);
    }

    @GetMapping(path="/{id}")
    public Opinion getOpinionById(@PathVariable int id){
        return opinionService.getOpinionById(id);
    }
    
    @DeleteMapping(path="/{id}")
    public String deleteOpinionById(@PathVariable int id){
        return opinionService.deleteOpinionById(id);
    }
    
    @PutMapping(path="/{id}")
    public Opinion updateOpinionById(@PathVariable int id, @RequestBody Opinion opinion){
        return opinionService.updateOpinionById(id, opinion);
    }
    
    @GetMapping(path="/movie/{id}")
    public List<Opinion> getOpinionsByMovie(@PathVariable int id){
        return opinionService.getOpinionsByMovie(id);
    }

    @GetMapping(path="/user/{id}")
    public List<Opinion> getOpinionsByUser(@PathVariable String id){
        return opinionService.getOpinionsByUser(id);
    }
    
    @GetMapping(path="/last")
    public String getLastOpinion(){
        return opinionService.getLastOpinion();
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<Opinion> getAllOpinions() {
        return opinionService.getAllOpinions();
    }
}
