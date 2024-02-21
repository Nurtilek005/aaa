package PeakSoft.entyti;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_gen")
    @SequenceGenerator(name = "post_gen", sequenceName = "post_seq", allocationSize = 1)
    private Long id;
    private String title;
    private String description;
    private String createdAt;


    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "post",cascade = CascadeType.REMOVE)
    private List<Comment>comments;
    @OneToMany(mappedBy = "post",cascade = CascadeType.REMOVE)
    private List<Like>lists;
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Image>images;


}
