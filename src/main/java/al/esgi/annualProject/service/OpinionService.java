package al.esgi.annualProject.service;

import al.esgi.annualProject.models.Movie;
import al.esgi.annualProject.models.Opinion;
import al.esgi.annualProject.models.User;
import al.esgi.annualProject.repository.MovieRepository;
import al.esgi.annualProject.repository.OpinionRepository;
import al.esgi.annualProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpinionService {
    @Autowired
    private OpinionRepository opinionRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    UserRepository userRepository;


    public String addNewOpinion(Opinion opinion) {
        Movie movie = movieRepository.getOne(opinion.getMovieId());
        Optional<User> user = userRepository.findByUserIdAndroid(opinion.getUserId());
        opinionRepository.save(opinion);
        Double averageNote = opinionRepository.findAverageNoteByMovie(movie.getId());
        Double averageLikeNote = opinionRepository.findAverageLikeNoteByMovie(movie.getId());
        movie.setAverageNote(averageNote);
        movie.setAverageLikes(averageLikeNote);
        movieRepository.save(movie);
        return "Saved";
    }


    public Optional<Opinion> getOpinionById(int id) {
        Optional<Opinion> opinion = opinionRepository.findById(id);
        return opinion;
    }

    public String deleteOpinionById(int id) {
        Opinion opinion = opinionRepository.getOne(id);
        opinionRepository.delete(opinion);
        return "deleted";
    }

    public String updateOpinionById(int id, Opinion opinion) {
        Opinion opinionFound = opinionRepository.getOne(id);
        opinionFound.setComment(opinion.getComment());
        opinionFound.setIsLiked(opinion.getIsLiked());
        opinionFound.setNote(opinion.getNote());
        opinionRepository.save(opinionFound);
        return "modified";
    }

    public List<Opinion> getOpinionsByMovie(int id) {
        Movie movie = movieRepository.getOne(id);
        List<Opinion> opinions = opinionRepository.findByMovieId(id);
        return opinions;
    }

    public List<Opinion> getOpinionsByUser(String id) {
        Optional<User> user = userRepository.findByUserIdAndroid(id);
        List<Opinion> opinions = opinionRepository.findByUserId(user.get().getUserIdAndroid());
        return opinions;
    }

    public String getLastOpinion() {
        Opinion opinion = opinionRepository.findFirstByOrderByIdDesc();
        String toReturn = "{\"comment\":\""+ opinion.getComment() +"\", \"movieId\":"+opinion.getMovieId()+"}";
        return toReturn;
    }

    public Iterable<Opinion> getAllOpinions() {
        return opinionRepository.findAll();
    }
}
