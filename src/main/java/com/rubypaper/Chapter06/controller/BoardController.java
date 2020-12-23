package com.rubypaper.Chapter06.controller;

import com.rubypaper.Chapter06.domain.Board;
import com.rubypaper.Chapter06.domain.Member;
import com.rubypaper.Chapter06.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SessionAttributes("member")
@Controller
public class BoardController {

    @ModelAttribute("member")
    public Member setMember() {
        return new Member();
    }

    @Autowired
    private BoardService boardService;

    @GetMapping("/hello")
    public void hello(Model model) {
        model.addAttribute("greeting", "Hello 타임리프");
    }

    // 글 목록 조회
    @RequestMapping("/getBoardList")
    public String getBoardList(@ModelAttribute("member") Member member, Model model) {

        if (member.getId() == null) {
            return "redirect:/login";
        }

        List<Board> boardList = boardService.getBoardList();


        model.addAttribute("boardList", boardList);
        return "getBoardList";
    }

    // 글 상세 조회
    @GetMapping("/getBoard")
    public String getBoard(@ModelAttribute("member") Member member,Board board, Model model) {

        if (member.getId() == null) {
            return "redirect:/login";
        }

        model.addAttribute("board", boardService.getBoard(board));

        return "/getBoard";
    }

    // 글 등록 폼 이동
    @GetMapping("/insertBoard")
    public String insertBoardView(@ModelAttribute("member") Member member) {
        return "insertBoard";
    }

    // 글 등록
    @PostMapping("/insertBoard")
    public String insertBoard(Board board) {

        boardService.insertBoard(board);

        return "redirect:/getBoardList";
    }

    // 글 수정
    @PostMapping("/updateBoard")
    public String updateBoard(@ModelAttribute("member") Member member,Board board) {

        if (member.getId() == null) {
            return "redirect:/login";
        }

        boardService.updateBoard(board);

        return "forward:getBoardList";
    }

    // 글 삭제
    @GetMapping("/deleteBoard")
    public String deleteBoard(@ModelAttribute("member") Member member, Board board) {

        if (member.getId() == null) {
            return "redirect:/login";
        }

        boardService.deleteBoard(board);

        return "forward:getBoardList";
    }
}
