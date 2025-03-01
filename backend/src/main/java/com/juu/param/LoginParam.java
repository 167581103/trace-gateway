package com.juu.param;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LoginParam {
    String username;
    String password;
}
