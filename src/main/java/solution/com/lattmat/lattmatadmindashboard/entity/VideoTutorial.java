package solution.com.lattmat.lattmatadmindashboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class VideoTutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "nvarchar(150)")
    private String title;

    @Column(columnDefinition = "nvarchar(150)")
    private String videoUrl;

    @Column(columnDefinition = "nvarchar(150)")
    private String coverPhotoUrl;

    @Column(columnDefinition = "nvarchar(500)")
    private String description;
}
