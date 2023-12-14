package solution.com.lattmat.lattmatadmindashboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "nvarchar(100)")
    private String name;

    @Column(columnDefinition = "nvarchar(50)")
    private String street;

    @Column(columnDefinition = "nvarchar(30)")
    private String city;

    @Column(columnDefinition = "nvarchar(30)")
    private String state;

    @Column(columnDefinition = "nvarchar(10)")
    private String zipCode;

    @Column(columnDefinition = "nvarchar(300)")
    private String mapLink;

    @Column(columnDefinition = "nvarchar(30)")
    private String phone;

}
