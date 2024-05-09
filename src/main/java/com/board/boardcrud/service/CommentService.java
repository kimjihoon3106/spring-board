package com.board.boardcrud.service;

import com.board.boardcrud.dto.CommentRequestDto;
import com.board.boardcrud.dto.CommentResponseDto;
import com.board.boardcrud.entity.Board;
import com.board.boardcrud.entity.Comment;
import com.board.boardcrud.repository.BoardRepository;
import com.board.boardcrud.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    // 댓글 등록 board 매핑
    @Transactional
    public CommentResponseDto createComment(CommentRequestDto requestDto, Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("조회 실패"));
        Comment comment = new Comment(requestDto,board);
        commentRepository.save(comment);
        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
        return commentResponseDto;
    }

    // 전체 댓글 조회
    @Transactional
    public List<CommentResponseDto> readAllComments(Long id) {
        return commentRepository.findAllByBoardId(id);
    }
}
