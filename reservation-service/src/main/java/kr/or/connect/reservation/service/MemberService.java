package kr.or.connect.reservation.service;

import java.util.Collection;
import java.util.List;

import kr.or.connect.reservation.dto.Member;

public interface MemberService {
	public Member get(Long id);
	public Collection<Member> getAll();
    public Member addMember(Member member);
    public boolean delete(Integer id);
    public boolean update(Member member);
}
