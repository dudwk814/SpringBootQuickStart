package com.rubypaper.Chapter07.persistence;

import com.rubypaper.Chapter07.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {


}
