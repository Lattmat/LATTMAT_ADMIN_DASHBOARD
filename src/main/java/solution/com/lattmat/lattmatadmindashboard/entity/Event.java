package solution.com.lattmat.lattmatadmindashboard.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "nvarchar(25)")
    private String name;

    @Column(columnDefinition = "nvarchar(100)")
    private String image;

    @Column(columnDefinition = "nvarchar(255)")
    private String description;

}
