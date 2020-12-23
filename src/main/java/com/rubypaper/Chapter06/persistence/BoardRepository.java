package com.rubypaper.Chapter06.persistence;

import com.rubypaper.Chapter06.domain.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}
