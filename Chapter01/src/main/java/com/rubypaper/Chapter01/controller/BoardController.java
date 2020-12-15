package com.rubypaper.Chapter01.controller;

import com.rubypaper.Chapter01.domain.BoardVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class BoardController {

    public BoardController() {
        System.out.println("=====> BoardController 생성");
    }

    @GetMapping("/hello")
    public String hello(String name) {

        return "Hello : " + name;
    }

    @GetMapping("/getBoard")
    public BoardVO getBoard() {

        BoardVO board = new BoardVO();
        board.setSeq(1);
        board.setTitle("테스트 제목");
        board.setContent("테스트 내용");
        board.setCreateDate(new Date());
        board.setCnt(0);
        return board;
    }

    @GetMapping("/getBoardList")
    public List<BoardVO> getBoardList() {

        List<BoardVO> boardList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            BoardVO vo = new BoardVO();

            vo.setSeq(i);
            vo.setTitle("제목" + i);
            vo.setWriter("테스터" + i);
            vo.setContent(i + "번 내용입니다.");
            vo.setCreateDate(new Date());
            vo.setCnt(0);
            boardList.add(vo);
        }

        return boardList;
    }
}
