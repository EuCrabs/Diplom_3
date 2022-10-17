package site.nomoreparties.stellarburgers.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class UserInfo {
    private String email;
    private String name;
}
