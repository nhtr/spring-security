package com.truongnh.lsso.service;

import java.util.Optional;

import com.truongnh.lsso.persistence.model.Project;

public interface IProjectService {
	Optional<Project> findById(Long id);

	Project save(Project project);

	Iterable<Project> findAll();

}
