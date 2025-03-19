package com.mentorship.news_aggregation.dtos;

import com.mentorship.news_aggregation.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;

    private String fullName;

    private String email;

    private String password;


}
