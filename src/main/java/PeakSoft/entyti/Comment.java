package PeakSoft.entyti;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_gen")
    @SequenceGenerator(name = "comment_gen", sequenceName = "comment_seq", allocationSize = 1)
    private Long id;
    private String comment;
    private String createAt;


    @ManyToOne
    private Post post;
    @OneToMany(mappedBy = "comment", cascade = CascadeType.REMOVE)
    private List<Like> lists;
    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<User>users;

}

