package com.rubypaper.Chapter06.service;

import com.rubypaper.Chapter06.domain.Board;

import java.util.List;

public interface BoardService {

    public List<Board> getBoardList();

    public void insertBoard(Board board);

    public Board getBoard(Board board);

    public void updateBoard(Board board);

    public void deleteBoard(Board board);
}
