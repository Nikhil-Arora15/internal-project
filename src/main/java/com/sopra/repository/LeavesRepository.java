package com.sopra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sopra.entity.Employee;
import com.sopra.entity.Leaves;

// jpa repository has two parameters 1. type of repository and other is type of primary key	

public interface LeavesRepository extends JpaRepository<Leaves, Long> {
	@Query("SELECT u FROM Leaves u WHERE u.month= ?1")
	List<Leaves> findleavesbymonth(String month);

	@Query(value = "select sum(no_days) FROM com.sopra.entity.Leaves")
	public int sumleaves();

	@Query(value = "select sum(no_days) FROM com.sopra.entity.Leaves where month=?1 AND month IS NOT NULL")
	public int sumleaves(String month);

}
