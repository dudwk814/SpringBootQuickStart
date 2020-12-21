package com.rupypaper.Chapter05.persistence;

import com.rupypaper.Chapter05.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {

}
