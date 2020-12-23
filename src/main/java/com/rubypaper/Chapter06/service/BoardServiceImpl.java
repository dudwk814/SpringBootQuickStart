package com.rubypaper.Chapter06.service;

import com.rubypaper.Chapter06.domain.Board;
import com.rubypaper.Chapter06.persistence.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<Board> getBoardList() {
        return (List<Board>) boardRepository.findAll();
    }

    @Override
    public void insertBoard(Board board) {
        boardRepository.save(board);

    }

    @Override
    public Board getBoard(Board board) {
        return boardRepository.findById(board.getSeq()).get();
    }

    @Override
    public void updateBoard(Board board) {
        Board board1 = boardRepository.findById(board.getSeq()).get();

        board1.setTitle(board.getTitle());
        board1.setContent(board.getContent());
        boardRepository.save(board1);
    }

    @Override
    public void deleteBoard(Board board) {

        boardRepository.delete(board);
    }
}
