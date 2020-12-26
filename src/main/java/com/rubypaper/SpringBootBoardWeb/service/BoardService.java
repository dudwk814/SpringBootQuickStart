package com.rubypaper.SpringBootBoardWeb.service;

import com.rubypaper.SpringBootBoardWeb.domain.Board;
import com.rubypaper.SpringBootBoardWeb.domain.Search;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BoardService {

    void insertBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(Board board);

    Board getBoard(Board board);

    Page<Board> getBoardList(Search search);
}
