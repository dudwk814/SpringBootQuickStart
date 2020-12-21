package com.rupypaper.Chapter05.persistence;

import com.rupypaper.Chapter05.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {


    public List<Board> findByTitle(String searchKeyword);

    public List<Board> findByContentContaining(String searchKeyword, Pageable paging);

    public List<Board> findByTitleContainingOrContentContaining(String title, String content);

    public List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);

    public Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);

    /*@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
    public List<Board> queryAnnotationTest1(String searchKeyword);

    @Query("SELECT b FROM Board b " +
            "WHERE b.title like %:searchKeyword% " +
            "ORDER BY b.seq DESC ")
    public List<Board> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);

    @Query("SELECT b.seq, b.title, b.writer, b.createDate" +
            " FROM Board b " +
            " WHERE b.title like %?1% " +
            " ORDER BY b.seq DESC ")
    public List<Object[]> queryAnnotationTest3(@Param("searchKeyword") String searchKeyword);

    @Query(value = "SELECT seq, title, writer, create_date FROM board  WHERE title like '%'||?1||'%'  ORDER BY seq DESC", nativeQuery = true)
    public List<Object[]> queryAnnotationTest4(@Param("searchKeyword") String searchKeyword);

    @Query("SELECT b FROM Board b ORDER BY b.seq DESC")
    public List<Board> queryAnnotationTest5(Pageable paging);*/
}
