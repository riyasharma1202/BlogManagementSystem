package com.ncu.comment.service;

import com.ncu.comment.dto.CommentDto;
import com.ncu.comment.service.exceptions.*;
import com.ncu.comment.irepository.ICommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.ncu.comment.model.Comment;

@Service
public class CommentService {

    @Autowired
    private ICommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CommentDto> getCommentsByBlogId(int blogID) {
        List<Comment> comments = commentRepository.getCommentsByBlogId(blogID);
        if (comments.isEmpty()) {
            throw new ResourceNotFoundException("No comments found for blog ID " + blogID);
        }
        List<CommentDto> dtos = new ArrayList<>();
        comments.forEach(c -> dtos.add(modelMapper.map(c, CommentDto.class)));
        return dtos;
    }

    public CommentDto addComment(CommentDto dto) {
        Comment saved = commentRepository.addComment(modelMapper.map(dto, Comment.class));
        return modelMapper.map(saved, CommentDto.class);
    }

    public void deleteComment(int commentID) {
        commentRepository.deleteComment(commentID);
    }
}
