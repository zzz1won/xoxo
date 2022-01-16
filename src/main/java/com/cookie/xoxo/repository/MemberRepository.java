package com.cookie.xoxo.repository;

import com.cookie.xoxo.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    MemberEntity findByMemberEmail(String memberEmail);
    // 메소드 이름은 반드시 저렇게 써줘야함...메소드만으로 jpa가 쿼리를 만들어주기 때문.
    // 마치 select * from 을 실행, findByMemberEmail = where memberEmail<- 이고.
    // 넘어가는 데이터 String memberEmail로 구분을 하라는 뜻...
    // 일반적인 insert select delete update 는 쿼리가 다 만들어진다~
}
