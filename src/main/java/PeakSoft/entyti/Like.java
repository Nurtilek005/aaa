package PeakSoft.entyti;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

@Entity
@Table(name = "likes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "likes_gen")
    @SequenceGenerator(name = "likes_gen", sequenceName = "likes_seq", allocationSize = 1)
    private Long id;
    private boolean isLike;


    @ManyToOne
    private Comment comment;
    @ManyToOne
    private Post post;
    @OneToOne
    private User user;

}
