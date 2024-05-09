package com.board.boardcrud.dto;

import com.board.boardcrud.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommentRequestDto {
    private String content;

    private Long boardId;

    public CommentRequestDto(Comment comment) {
        this.content = comment.getContent();
        this.boardId = comment.getBoard().getId();
    }
}
