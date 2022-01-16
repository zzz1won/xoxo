package com.cookie.xoxo.service;

import com.cookie.xoxo.dto.MemberDetailDTO;
import com.cookie.xoxo.dto.MemberLoginDTO;
import com.cookie.xoxo.dto.MemberSaveDTO;

import java.util.List;

public interface MemberService {
    Long save(MemberSaveDTO memberSaveDTO);

    boolean login(MemberLoginDTO memberLoginDTO);

    List<MemberDetailDTO> findAll();

    MemberDetailDTO findById(Long memberId);
}
