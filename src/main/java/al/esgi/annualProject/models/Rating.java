package al.esgi.annualProject.models;

import javax.persistence.*;

@Entity
@Table(name="rating")
public class Rating {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    public Integer id;
    
    
}
