package com.ncu.comment.controller;

import com.ncu.comment.dto.CommentDto;
import com.ncu.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/blog/{blogID}")
    public List<CommentDto> getCommentsByBlogId(@PathVariable int blogID) {
        return commentService.getCommentsByBlogId(blogID);
    }

    @PostMapping("/")
    public CommentDto addComment(@RequestBody CommentDto dto) {
        return commentService.addComment(dto);
    }

    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable("id") int commentID) {
        commentService.deleteComment(commentID);
        return "Comment deleted successfully.";
    }
}