package com.cookie.xoxo.dto;

import com.cookie.xoxo.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDetailDTO {
    private Long memberId;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    // MemberEntity -> MemberDetailDTO

    public static MemberDetailDTO toMemberDetaileDTO (MemberEntity memberEntity) {
        MemberDetailDTO memberDetailDTO = new MemberDetailDTO();
        memberDetailDTO.setMemberId(memberEntity.getId());
        memberDetailDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDetailDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDetailDTO.setMemberName(memberEntity.getMemberName());
        return memberDetailDTO;
    }

}
