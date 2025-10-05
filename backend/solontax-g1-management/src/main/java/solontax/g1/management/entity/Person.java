package solontax.g1.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    @Column(unique = true, nullable = false, updatable = false)
    private Long taxNumber;
}
