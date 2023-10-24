package com.primerParcialBack.parcialBack.repository;

import com.primerParcialBack.parcialBack.entidades.Albums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends  JpaRepository<Albums, Long> {

}
