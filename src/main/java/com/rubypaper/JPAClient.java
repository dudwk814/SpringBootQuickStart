package com.rubypaper;

import com.rubypaper.domain.Board;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class JPAClient {

    public static void main(String[] args) {
        // EntityManager 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");

        EntityManager em = emf.createEntityManager();

        // Transaction 시작
        EntityTransaction tx = em.getTransaction();



        try {

            // Transaction 시작
            tx.begin();

            Board board = new Board();

            board.setTitle("JPA 제목");
            board.setWriter("관리자");
            board.setContent("JPA 글 등록 잘 되네요");
            board.setCreateDate(new Date());
            board.setCnt(0L);

            // 글등록
            em.persist(board);

            // tx commit
            tx.commit();

            // 글 목록 조회
            String jpql = "select b from Board b order by b.seq desc";

            List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();

            for (Board brd : boardList) {
                System.out.println("----> " + brd.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();

            // tx 롤백
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
