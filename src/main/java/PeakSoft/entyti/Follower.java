package PeakSoft.entyti;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "follower")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Follower{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "follower_gen")
    @SequenceGenerator(name = "follower_gen", sequenceName = "follower_seq", allocationSize = 1)
    private Long id;

    @ManyToMany
    @JoinTable(name = "follower_subscribers",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "subscriber_id"))
    private List<User> subscribers ;

    @ManyToMany
    @JoinTable(name = "follower_subscriptions",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "subscription_id"))
    private List<User> subscriptions ;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

}
