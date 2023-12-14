package solution.com.lattmat.lattmatadmindashboard.entity.night;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import solution.com.lattmat.entity.Event;
import solution.com.lattmat.entity.Location;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class NightAndClub {

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

    @ManyToOne
    @JoinColumn(name="event_id", nullable=false)
    private Event event;

}
