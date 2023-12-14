package solution.com.lattmat.lattmatadmindashboard.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import solution.com.lattmat.lattmatadmindashboard.entity.concert.Concert;
//import solution.com.lattmat.entity.concert.Concert;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Artists {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "nvarchar(50)")
    private String name;

    @Column(columnDefinition = "nvarchar(50)")
    private String shortName;

    @Column(columnDefinition = "nvarchar(50)")
    private String reknown;

    @Column(columnDefinition = "nvarchar(100)")
    private String profileImage;

    @Column(columnDefinition = "nvarchar(700)")
    private String bio;

    private LocalDate dob;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "artist_location",
            joinColumns = {@JoinColumn(name = "artist_id")},
            inverseJoinColumns = {@JoinColumn(name = "location_id")}
    )
    private List<Location> locations;

    @JsonIgnore
    @ManyToMany(targetEntity = Concert.class)
    private Set<Concert> concerts;
}
