package diasoft.mpanchuk.task3.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    @JsonProperty("firstName")
    @Column(name = "first_name")
    private String firstName;

    @JsonProperty("lastName")
    @Column(name = "last_name")
    private String lastName;

    @JsonProperty("email")
    @Column(name = "email")
    private String email;
}
