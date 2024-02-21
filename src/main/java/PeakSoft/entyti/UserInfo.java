package PeakSoft.entyti;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "userInfo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userInfo_gen")
    @SequenceGenerator(name = "userInfo_gen", sequenceName = "userInfo_seq", allocationSize = 1)
    private Long id;
    private String fullName;
    private String biography;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(length = 200000 )
    private String image;

    @OneToOne
    private User user;
}
