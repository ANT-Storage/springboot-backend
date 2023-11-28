package com.ant_storage.ANT.Storage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ant_storage.ANT.Storage.entity.Tag;
import com.ant_storage.ANT.Storage.service.TagService;

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
