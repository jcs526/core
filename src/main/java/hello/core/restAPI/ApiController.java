package hello.core.restAPI;

import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class ApiController {

    MemberService memberService;

    @Autowired
    public ApiController(MemberService memberServiceImpl) {
        this.memberService = memberServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable("id") long id){
        Member member = memberService.findMember(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(member);
    }

}
