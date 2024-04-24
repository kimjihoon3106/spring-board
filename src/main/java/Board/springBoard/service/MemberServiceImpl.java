package Board.springBoard.service;

import Board.springBoard.entity.Member;
import Board.springBoard.entity.MemberDto;
import Board.springBoard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public Member saveEntity(Member member){
        return memberRepository.save(member);
    }

    @Override
    public Member saveDto(MemberDto memberDto) {
        Member member = Member.builder()
                .username(memberDto.getUsername())
                .password(memberDto.getPassword())
                .build();
        return saveEntity(member);
    }
}
