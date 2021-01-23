package rs.ac.metropolitan.kanbanbackend.controller;

import rs.ac.metropolitan.kanbanbackend.entity.Comment;
import rs.ac.metropolitan.kanbanbackend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> getAll() {
        return ResponseEntity.ok(commentService.findAll());
    }

    @GetMapping("/{comment}")
    public ResponseEntity<Comment> getById(@PathVariable Integer comment) {
        return ResponseEntity.ok(commentService.findById(comment));
    }

    @PostMapping
    public ResponseEntity<Comment> save(@RequestBody Comment comment) {
        return ResponseEntity.status(201).body(commentService.save(comment));
    }

    @PutMapping
    public ResponseEntity<Comment> update(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.update(comment));
    }

    @DeleteMapping("/{commentId}")
    public void deleteById(@PathVariable Integer commentId) {
        commentService.deleteById(commentId);
    }
}
