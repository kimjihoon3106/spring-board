package com.board.boardcrud.controller;

import com.board.boardcrud.dto.CommentRequestDto;
import com.board.boardcrud.dto.CommentResponseDto;
import com.board.boardcrud.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    // 댓글 등록
    @PostMapping("/boards/{id}/comments")
    public CommentResponseDto createBoard(@RequestBody CommentRequestDto requestDto, @PathVariable Long id) {
        return commentService.createComment(requestDto, id);
    }

    // 댓글 목록 조회
    @GetMapping("/boards/{id}/comments-list")
    public List<CommentResponseDto> getAllComments(@PathVariable Long id) {
        return commentService.readAllComments(id);
    }
}
