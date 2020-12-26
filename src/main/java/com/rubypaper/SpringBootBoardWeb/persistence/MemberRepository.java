package com.rubypaper.SpringBootBoardWeb.persistence;

import com.rubypaper.SpringBootBoardWeb.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {

}
