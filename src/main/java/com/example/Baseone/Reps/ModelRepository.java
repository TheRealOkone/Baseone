package com.example.Baseone.Reps;


import com.example.Baseone.MODEL.RecordModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<RecordModel, Long> {

}