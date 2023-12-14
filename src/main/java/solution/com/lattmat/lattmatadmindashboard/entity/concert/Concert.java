package solution.com.lattmat.lattmatadmindashboard.entity.concert;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import solution.com.lattmat.lattmatadmindashboard.entity.Artists;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "concert")
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "nvarchar(50)")
    private String title;

    @Column(columnDefinition = "nvarchar(255)")
    private String description;

    private LocalDate startDate;
    private LocalTime startTime;
    private LocalDate endDate;
    private LocalTime endTime;

    private LocalDate earlyAccessExpiredDate;

    @Column(columnDefinition = "bigint default 0")
    private long userClickCount;

    @Column(columnDefinition = "nvarchar(100)")
    private String image;

    @Column(columnDefinition = "nvarchar(100)")
    private String coverImage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "reference_id")
    private List<Promotion> promotions;

    @ManyToOne
    @JoinColumn(name="event_id", nullable=false)
    private Event event;

    @ManyToMany(targetEntity = Artists.class)
    private Set<Artists> artists;

}
