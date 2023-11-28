package com.ant_storage.ANT.Storage.controller;

import com.ant_storage.ANT.Storage.entity.Tag;
import com.ant_storage.ANT.Storage.service.TagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("antstorage/v1/tags")
public class TagController {
	@Autowired
	private TagService tagService;

	@GetMapping()
	public List<Tag> getAllTags() {
		return tagService.findAllTags();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Tag>> getTagById(@PathVariable Integer id) {
		Optional<Tag> tag = tagService.getTagById(id);
		return (tag.isPresent()) ? ResponseEntity.ok(tag) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public Tag createTag(Tag tag) {
		return tagService.saveTag(tag);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTag(@PathVariable Integer id) {
		tagService.deleteTag(id);
	}
	
}
