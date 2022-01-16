package com.cookie.xoxo.entity;

import com.cookie.xoxo.dto.MemberSaveDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="member_table")
public class MemberEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 20, unique = true)
    private String memberEmail;

    @Column(length = 20)
    private String memberPassword;

    private String memberName;

    // MemberSaveDTO -> MemberEntity 객체로 변환하기 위한 메서드
    // entity 만들면서 팩토리메소드, 스태틱메소드를 적어줍니다.
    public static MemberEntity saveMember(MemberSaveDTO memberSaveDTO)  {
        // MemberEntity 타입의 saveMember 생성
        // MemberSaveDTO 타입의 memberSaveDTO를 가져올것이다.
        MemberEntity memberEntity = new MemberEntity();

        // 새로운 MemberEntity를 생성한다. MemberEntity 타입의 memberEntity라는 이름의 객체로!

        memberEntity.setMemberEmail(memberSaveDTO.getMemberEmail());
        // 1. memberEntity라는 객체에 2.MemberEmail값을 셋팅한다, 3.memberSaveDTO의 4.MemberEmail값을 가져와서.
        memberEntity.setMemberPassword(memberSaveDTO.getMemberPassword());
        memberEntity.setMemberName(memberSaveDTO.getMemberName());
        // 이렇게 다 담아온 값은 결국 memberEntity 안에 들어간 것이므로
        // memberEntity를 리턴해주면 memberSave에 있던 값이 memberEntity에 전부 들어가있는 셈이므로
        // MemberSaveDTO -> MemberEntity 라는 공식히 들어 맞게 되는 셈.

        return memberEntity;

    }

}
