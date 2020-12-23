package com.rubypaper.Chapter06;

import com.rubypaper.Chapter06.domain.Board;
import com.rubypaper.Chapter06.domain.Member;
import com.rubypaper.Chapter06.persistence.BoardRepository;
import com.rubypaper.Chapter06.persistence.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataInitializeTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testDataInsert() {
        Member member = new Member();
        member.setId("member1");
        member.setPassword("member111");
        member.setName("둘리");
        member.setRole("ROLE_USER");
        memberRepository.save(member);

        Member member2 = new Member();
        member2.setId("member2");
        member2.setName("도우너");
        member2.setPassword("member222");
        member2.setRole("ROLE_ADMIN");
        memberRepository.save(member2);

        for (int i = 1; i <= 3; i++) {
            Board board = new Board();
            board.setWriter("둘리");
            board.setTitle("둘리가 등록한 게시글 " + i);
            board.setContent("둘리가 등록한 게시글 내용 " + i);
            boardRepository.save(board);
        }

        for (int i = 1; i <= 3; i++) {
            Board board = new Board();
            board.setWriter("도우너");
            board.setTitle("도우너가 등록한 게시글 " + i);
            board.setContent("도우너가 등록한 게시글 내용 " + i);
            boardRepository.save(board);
        }
    }
}
