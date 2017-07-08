package kr.or.connect.reservation.service.impl;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.MemberDao;
import kr.or.connect.reservation.dto.Member;
import kr.or.connect.reservation.service.MemberService;


@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberDao memberDao;

    @Transactional(readOnly = true)
	public Member get(Long id) {
		// TODO Auto-generated method stub
		return memberDao.selectById(id);
	}

    @Transactional(readOnly = false)
	public Member addMember(Member member) {
		// TODO Auto-generated method stub
		Long insert = memberDao.insert(member);
        member.setId(insert);
        return member;

	}
    
    
    
    public Collection<Member> getAll()
    {
    		return memberDao.selectAll();
    }
    
    @Transactional(readOnly = false)
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		int affected = memberDao.deleteById(id);
		return affected == 1;
	}

    
	public boolean update(Member member) {
		// TODO Auto-generated method stub
		int affected = memberDao.update(member);
		return affected == 1;
	}
}
