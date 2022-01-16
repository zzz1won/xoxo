package com.cookie.xoxo;

import com.cookie.xoxo.dto.MemberSaveDTO;
import com.cookie.xoxo.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class xoxoText {
    @Autowired
    private MemberService ms;

    @Test
    @DisplayName("회원생성 test")
    public void newMembers(){
        IntStream.rangeClosed(1,15).forEach(i->{
        ms.save(new MemberSaveDTO("email"+i, "pw"+i, "name"+i));
        });
    }
}
