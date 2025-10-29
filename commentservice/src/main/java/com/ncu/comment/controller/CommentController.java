package com.ncu.comment.controller;

import com.ncu.comment.dto.APIResponse;
import com.ncu.comment.dto.CommentDto;
import com.ncu.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/blog/{blogID}")
    public ResponseEntity<APIResponse<List<CommentDto>>> getCommentsByBlogId(@PathVariable int blogID) {
        List<CommentDto> comments = commentService.getCommentsByBlogId(blogID);
        return ResponseEntity.ok(new APIResponse<>("Comments fetched", comments, true));
    }

    @PostMapping("/")
    public ResponseEntity<APIResponse<CommentDto>> addComment(@RequestBody CommentDto dto) {
        CommentDto saved = commentService.addComment(dto);
        return new ResponseEntity<>(
                new APIResponse<>("Comment added successfully", saved, true),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<String>> deleteComment(@PathVariable("id") int commentID) {
        commentService.deleteComment(commentID);
        return ResponseEntity.ok(new APIResponse<>("Comment deleted", null, true));
    }
}
