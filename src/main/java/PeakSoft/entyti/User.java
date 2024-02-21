package PeakSoft.entyti;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name ="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_gen")
    @SequenceGenerator(name = "users_gen", sequenceName = "users_seq", allocationSize = 1)
    private Long id;
    @Column(unique = true)
    private String userName;
    private String password;
    @Column(unique = true)
    private String email;
    private String phoneNumber;


    @OneToMany(mappedBy = "user",cascade = {REMOVE,REFRESH})
    private List<Post> posts;
    @OneToOne(cascade = {REMOVE,REFRESH,PERSIST})
    private Follower follower;
    @OneToOne(cascade = {REMOVE,REFRESH,PERSIST})
    private UserInfo userInfo;
    @ManyToMany(mappedBy = "users",cascade = {REMOVE,REFRESH})
    private List<Comment>comments;
    @OneToOne(cascade = {REMOVE,REFRESH})
    private Like like;
    @ManyToOne(cascade = {REMOVE,REFRESH})
    private Image image;

}

