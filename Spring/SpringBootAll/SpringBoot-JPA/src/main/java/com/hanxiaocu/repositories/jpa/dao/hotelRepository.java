package com.hanxiaocu.repositories.jpa.dao;

import com.hanxiaocu.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/24 12:57 PM
 */
public interface hotelRepository extends JpaRepository<HotelSummary, Long> {


	@Query(value = "select h.city as city, h.name as name, avg(r.ration) as averageRating" +
			"from Hotel h left outer join h.reviews r where h.city = ?1 group by h")
	Page<HotelSummary> findByCity(City city, Pageable pageable);




	@Query("select h.name as name , avg (r.ration) as averageRating " +
			"from Hotel h left outer join h.reviews r group by h")
	Page<HotelSummary> findByCity(Pageable pageable);

}



