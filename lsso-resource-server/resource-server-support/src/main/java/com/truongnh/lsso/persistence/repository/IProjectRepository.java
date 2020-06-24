package com.truongnh.lsso.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.truongnh.lsso.persistence.model.Project;

public interface IProjectRepository extends PagingAndSortingRepository<Project, Long> {
}
