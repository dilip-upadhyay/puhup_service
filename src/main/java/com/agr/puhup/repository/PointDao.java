package com.agr.puhup.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agr.puhup.model.Point;

@Transactional
public interface PointDao extends JpaRepository<Point, Long> {
}
