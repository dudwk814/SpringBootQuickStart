package com.rupypaper.Chapter05;

import com.rupypaper.Chapter05.domain.Board;
import com.rupypaper.Chapter05.persistence.BoardRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class Chapter05ApplicationTests {

	@Autowired
	private BoardRepository boardRepository;

	@Test
	public void testInsertBoard() {

		Board board = new Board();
		board.setTitle("첫 번째 게시글");
		board.setWriter("테스터");
		board.setContent("잘 등록되겠지");
		board.setCreateDate(new Date());
		board.setCnt(0L);

		boardRepository.save(board);
	}

	@Test
	public void testGetBoard() {

		Board board = boardRepository.findById(1L).get();

		System.out.println(board.toString());
	}

	@Test
	public void testUpdateBoard() {

		System.out.println("1번글 조회");
		Board board = boardRepository.findById(1L).get();

		System.out.println("1번글 수정");
		board.setTitle("제목을 수정했습니다.");
		boardRepository.save(board);
	}

	@Test
	public void testDeleteBord() {

		boardRepository.deleteById(1L);
	}
}
