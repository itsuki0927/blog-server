package cn.itsuki.blog.controllers;

import cn.itsuki.blog.entities.Comment;
import cn.itsuki.blog.entities.requests.CommentCreateRequest;
import cn.itsuki.blog.entities.requests.CommentPatchRequest;
import cn.itsuki.blog.entities.requests.CommentSearchRequest;
import cn.itsuki.blog.entities.requests.CommentUpdateRequest;
import cn.itsuki.blog.entities.responses.SearchResponse;
import cn.itsuki.blog.entities.responses.WrapperResponse;
import cn.itsuki.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 评论 controller
 *
 * @author: itsuki
 * @create: 2021-10-03 16:33
 **/
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService service;

    @PostMapping
    public WrapperResponse<Comment> create(@RequestBody @Valid CommentCreateRequest request) {
        return WrapperResponse.build(service.create(request));
    }

    @GetMapping
    public WrapperResponse<SearchResponse<Comment>> search(@Valid @ModelAttribute CommentSearchRequest criteria) {
        return WrapperResponse.build(service.search(criteria));
    }

    @PutMapping("/{id}")
    public WrapperResponse<Comment> update(@PathVariable("id") Long id, @RequestBody @Valid CommentUpdateRequest request) {
        return WrapperResponse.build(service.update(id, request));
    }


    @PatchMapping
    public WrapperResponse<Integer> patch(@Valid @RequestBody CommentPatchRequest request) {
        return WrapperResponse.build(service.patch(request));
    }

    @DeleteMapping("/{id}")
    public WrapperResponse<Integer> delete(@PathVariable("id") Long id) {
        return WrapperResponse.build(service.delete(id));
    }
}
