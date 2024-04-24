package Board.springBoard.controller;

import Board.springBoard.Dto.LoginDto;
import Board.springBoard.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
public class MemberController {
    @GetMapping ("/login")
    public String getLogin(HttpServletRequest request, Model model) {

        //현재 페이지를 가져와 세션에 저장
        String referer = request.getHeader("Referer");
        request.getSession().setAttribute("prevPage",referer);
        log.info("uri={}",referer);
        model.addAttribute("login",new LoginDto());
        return "member/login";
    }
    @PostMapping("/login")
    public String postLogin(@ModelAttribute("login") LoginDto loginDto, HttpServletRequest request, HttpSession session,Model model){
        boolean login = .login(loginDto);

        if (login){
            String username = loginDto.getUsername();
            Member member = memberService.findByUsername(username);
            session.setAttribute("loginMember",member);

            //저장한 이전페이지 주소를 가져온다
            String prevPage = (String) request.getSession().getAttribute("prevPage");
            //세션에 페이지 주소 삭제
            request.getSession().removeAttribute("prevPage");

            return "redirect" + (prevPage != null ? prevPage : "/"); //이전페이지가 있다면 이전페이지로 없다면 / 페이지로
        }

        model.addAttribute("error","비밀번호 또는 아이디가 올바르지 않습니다.");
        return "member/login";
    }

    @PostMapping("/logout")
    public String login(HttpSession session){
        session.removeAttribute("loginMember");
        return "redorect:/";
    }

    @GetMapping("/")
        public String home(Model model, HttpSession session) {

        Member loginMember = (Member) session.getAttribute("loginMember");

        model.addAttribute("loginMember",loginMember);
        return "home";
    }
}
