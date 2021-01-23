package rs.ac.metropolitan.kanbanbackend.service;

import rs.ac.metropolitan.kanbanbackend.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    Comment save(Comment comment);

    Comment update(Comment comment);

    Comment findById(Integer commentId);

    void deleteById(Integer commentId);

}
