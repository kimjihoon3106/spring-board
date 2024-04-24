package Board.springBoard.service;

import Board.springBoard.entity.MemberDto;

import java.lang.reflect.Member;

public interface MemberService {
        Member saveEntity(Member member);

        Member saveDto(MemberDto memberDto);
}
