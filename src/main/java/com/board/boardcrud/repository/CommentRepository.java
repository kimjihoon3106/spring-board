package com.board.boardcrud.repository;

import com.board.boardcrud.dto.CommentResponseDto;
import com.board.boardcrud.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<CommentResponseDto> findAllByBoardId(Long boardId);
}
