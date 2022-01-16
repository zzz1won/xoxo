package com.cookie.xoxo.service;

import com.cookie.xoxo.dto.MemberDetailDTO;
import com.cookie.xoxo.dto.MemberLoginDTO;
import com.cookie.xoxo.dto.MemberSaveDTO;
import com.cookie.xoxo.entity.MemberEntity;
import com.cookie.xoxo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository mr;

    @Override
    public Long save(MemberSaveDTO memberSaveDTO) {
        // JpaRepository는 무조건 Entity만 받기 때문에
        // DTO를 Entity로 변환해줘야한다. [JPA를 사용할 때 규칙]

        // MemberSaveDTO -> MemberEntity
        MemberEntity memberEntity = MemberEntity.saveMember(memberSaveDTO);
        // MemberEntity에서 만든 saveMember객체에 memberSaveDTO의 값이 담겨있는데
        // 위의 내용을 MemberEntity 타입의 memberEntity에 저장해둔다.

        /*Long memberId = mr.save(memberEntity).getId();
        //memberEntity에 있는 Id 값을 담는다. MemberRepotisory의 save에.
        return memberId;*/

        return mr.save(memberEntity).getId();
    }

    @Override
    public boolean login(MemberLoginDTO memberLoginDTO) {
        /*mr.findByMemberEmail(memberLoginDTO.getMemberEmail()); 얘도 dto -> entity로 변환해야하므로 */
        MemberEntity memberEntity = mr.findByMemberEmail(memberLoginDTO.getMemberEmail());
        // 이 id (우리에겐 memberEmail)를 갖고있는 사람이 있는가?
        // 비번이 일치하는가를 판단.
        if (memberEntity != null)   {
            //1. memberEntity 에서 id 조회결과가 있으면
            if (memberEntity.getMemberPassword().equals(memberLoginDTO.getMemberPassword()))    {
                //memberEntity의 (save 된) memberPassword 와 memberLoginDTO의 memberPassword의 일치여부를 확인.
                return true;
            }  else     {
                return false;
            }
        }   else    {
            return false;
        }
    }

    @Override
    public List<MemberDetailDTO> findAll() {
        /* mr.findAll(); */
        //findAll을 하게 되면 리턴은 해당 entity가 들어있는 list로 넘겨주는, jpa가 설정.
        List<MemberEntity> memberEntityList = mr.findAll();

        //DetailDTO를 담기위한 List 선언
        List<MemberDetailDTO> memberList = new ArrayList<>();

        for (MemberEntity m : memberEntityList) {
            memberList.add(MemberDetailDTO.toMemberDetaileDTO(m));
        }

        return memberList;
    }

    @Override
    public MemberDetailDTO findById(Long memberId) {
        /*
        Optional<MemberEntity> memberEntityOptional = mr.findById(memberId);
        MemberEntity memberEntity = memberEntityOptional.get();
            //null을 방지하기 위한 객체 (공식으로 외우기)
        MemberDetailDTO memberDetailDTO = MemberDetailDTO.toMemberDetaileDTO(memberEntity);
            //entity를 dto로 변경...
        return memberDetailDTO;
         */
        return MemberDetailDTO.toMemberDetaileDTO(mr.findById(memberId).get());
    }
}
