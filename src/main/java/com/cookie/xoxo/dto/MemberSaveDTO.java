package com.cookie.xoxo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberSaveDTO {
//    private Long memberId;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}
