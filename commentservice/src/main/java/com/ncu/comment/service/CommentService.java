package com.ncu.comment.service;

import com.ncu.comment.dto.CommentDto;
import com.ncu.comment.irepository.ICommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.ncu.comment.model.Comment;

@Service
public class CommentService {

    private final ICommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CommentService(ICommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    public List<CommentDto> getCommentsByBlogId(int blogID) {
        List<Comment> comments = commentRepository.getCommentsByBlogId(blogID);
        List<CommentDto> dtos = new ArrayList<>();
        for (Comment c : comments) {
            dtos.add(modelMapper.map(c, CommentDto.class));
        }
        return dtos;
    }

    public CommentDto addComment(CommentDto dto) {
        Comment comment = modelMapper.map(dto, Comment.class);
        Comment saved = commentRepository.addComment(comment);
        return modelMapper.map(saved, CommentDto.class);
    }

    public void deleteComment(int commentID) {
        commentRepository.deleteComment(commentID);
    }
}
