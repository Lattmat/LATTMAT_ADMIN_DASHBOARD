package solution.com.lattmat.lattmatadmindashboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class FAQ {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "nvarchar(200)")
    private String question;

    @Column(columnDefinition = "nvarchar(3000)")
    private String answer;
}