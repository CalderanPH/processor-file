package br.paulocalderan.fileprocessor.domain.user.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String name;
    private String email;
    private String source;
}
