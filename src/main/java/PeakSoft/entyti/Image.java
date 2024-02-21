package PeakSoft.entyti;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_gen")
    @SequenceGenerator(name = "image_gen", sequenceName = "image_seq", allocationSize = 1)
    private Long id;
    @Column(length =200000)
    private String imageUrl;


    @OneToMany(mappedBy = "image")
    private List<User> users;
}

