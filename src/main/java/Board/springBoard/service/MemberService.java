package Board.springBoard.service;

import Board.springBoard.entity.Member;
import Board.springBoard.entity.MemberDto;


public interface MemberService {
        Member saveEntity(Member member);

        Member saveDto(MemberDto memberDto);
}
