package com.rubypaper.Chapter06.persistence;

import com.rubypaper.Chapter06.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {

}
