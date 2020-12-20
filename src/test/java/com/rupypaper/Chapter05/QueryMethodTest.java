package com.rupypaper.Chapter05;

import com.rupypaper.Chapter05.domain.Board;
import com.rupypaper.Chapter05.persistence.BoardRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest {

    @Autowired
    private BoardRepository boardRepository;

    @Before
    public void dataPrepare() {
        for (int i = 1; i <= 200; i++) {

            Board board = new Board();

            board.setTitle("테스트 제목 " + i);
            board.setWriter("테스터");
            board.setContent("테스트 내용 " + i);
            board.setCreateDate(new Date());
            board.setCnt(0L);

            boardRepository.save(board);
        }

    }

    @Test
    public void testFindByTitle() {

        List<Board> boardList = boardRepository.findByTitle("테스트 제목 10");

        System.out.println("검색 결과");

        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    @Test
    public void testFindByContentContaining() {

        Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");

        List<Board> boardList = boardRepository.findByContentContaining("내용",paging);

        System.out.println("검색 결과");

        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    @Test
    public void testFindByTitleContainingOrContentContaining() {

        List<Board> boardList = boardRepository.findByTitleContainingOrContentContaining("17", "17");

        System.out.println("검색 결과");

        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    @Test
    public void testFindByTitleContainingOrderBySeqDesc() {

        List<Board> boardList = boardRepository.findByTitleContainingOrderBySeqDesc("17");

        System.out.println("검색 결과");

        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    @Test
    public void testFindByTitleContaining() {

        Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");

        Page<Board> pageInfo = boardRepository.findByTitleContaining("제목", paging);

        System.out.println("Page Size : " + pageInfo.getSize());
        System.out.println("Total Pages : " + pageInfo.getTotalPages());
        System.out.println("TOTAL COUNT : " + pageInfo.getTotalElements());
        System.out.println("NEXT : " + pageInfo.nextPageable());

        List<Board> boardList = pageInfo.getContent();

        System.out.println("검색 결과");
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }




}

