package com.rupypaper.Chapter05.persistence;

import com.rupypaper.Chapter05.domain.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {


    public List<Board> findByTitle(String searchKeyword);

    public List<Board> findByContentContaining(String searchKeyword, Pageable paging);

    public List<Board> findByTitleContainingOrContentContaining(String title, String content);

    public List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
}
