package solontax.g1.management.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private Long age;
    private Long taxNumber;
}
