package com.rubypaper.SpringBootBoardWeb.service;

import com.querydsl.core.BooleanBuilder;
import com.rubypaper.SpringBootBoardWeb.domain.Board;
import com.rubypaper.SpringBootBoardWeb.domain.QBoard;
import com.rubypaper.SpringBootBoardWeb.domain.Search;
import com.rubypaper.SpringBootBoardWeb.persistence.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public void insertBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public void updateBoard(Board board) {

        Board findBoard = boardRepository.findById(board.getSeq()).get();

        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());

        boardRepository.save(findBoard);
    }

    @Override
    public void deleteBoard(Board board) {

        boardRepository.deleteById(board.getSeq());
    }

    @Override
    public Board getBoard(Board board) {
        return boardRepository.findById(board.getSeq()).get();
    }

    @Override
    public Page<Board> getBoardList(Search search) {

        BooleanBuilder builder = new BooleanBuilder();

        QBoard qboard = QBoard.board;

        if (search.getSearchCondition().equals("TITLE")) {
            builder.and(qboard.title.like("%" + search.getSearchKeyword() + "%"));
        } else if (search.getSearchCondition().equals("CONTENT")) {
            builder.and(qboard.content.like("%" + search.getSearchKeyword() + "%"));
        }

        Pageable paging = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
        return boardRepository.findAll(builder, paging);
    }
}
