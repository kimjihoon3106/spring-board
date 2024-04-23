package Board.springBoard.Service;

import Board.springBoard.Dto.LoginDto;
import Board.springBoard.entity.Member;
import Board.springBoard.entity.MemberDto;
import Board.springBoard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
@SuperBuilder(toBuilder = true)

public class MemberServicelmpl implements MemberService {

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

    @Override
    public Member findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    public boolean login(LoginDto loginDto){
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();
        Member byUsername = memberRepository.findByUsername(username);
        if(byUsername!=null){
            if(byUsername.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
