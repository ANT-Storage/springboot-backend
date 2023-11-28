package com.ant_storage.ANT.Storage.service;

import com.ant_storage.ANT.Storage.entity.Tag;
import com.ant_storage.ANT.Storage.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TagService {
	@Autowired
	private TagRepository tagRepository;
	
	public List<Tag> findAllTags() {
		return tagRepository.findAll();
	}
	
	public Optional<Tag> getTagById(Integer id){
		return tagRepository.findById(id);
	}
	
	public Tag saveTag(Tag tag) {
		return tagRepository.save(tag);
	}
	
	public void deleteTag(Integer id) {
		tagRepository.deleteById(id);
	}
}
