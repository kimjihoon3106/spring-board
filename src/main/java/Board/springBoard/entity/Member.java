package Board.springBoard.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_ID")
    private Long id;

    private String username;

    private String password;

}
