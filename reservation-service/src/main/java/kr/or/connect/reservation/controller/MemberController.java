package kr.or.connect.reservation.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Member;
import kr.or.connect.reservation.dto.MemberFormParam;
import kr.or.connect.reservation.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 회원 가입시 form에서 알맞은 값을 입력하였는지 프론트 javascript를 이용하여 검증을 해야겠지만,
    // 프론트를 무시하고 요청을 보낼 수도 있기 때문에 서버에서도 해당 값이 올바른지 검증하는 코드가 반드시 존재해야 한다.
    @PostMapping
    public Member create(@RequestBody Member member) {
        if (member.getName() == null || member.getName().length() == 0 ) {
            return null; // 이름, email, passwd1, passwd2 중에서 하나라도 입력하지 않은 것이 있을 경우 이동
        }else {
                
                Member resultMember = memberService.addMember(member);

                return resultMember; // 회원 가입 후 봐야할 화면으로 redirect
            }
        }
    
    @GetMapping
	Collection<Member> readList() {
		return memberService.getAll();
	}
    
    @DeleteMapping("/{id}")
    boolean delete(@PathVariable Integer id){
		return memberService.delete(id);
	}
    
    @PutMapping
	boolean update(@RequestBody Member member){		
		return memberService.update(member);
	}
}
