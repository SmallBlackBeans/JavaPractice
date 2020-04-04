package com.hanxiaocu.repositories.jpa.dao;

import com.hanxiaocu.entity.City;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/24 12:56 PM
 */
public interface HotelSummary {
	City getCity();

	String getName();

	Double getAverageRating();

	default Integer getAverageRatingRounded() {
		return getAverageRating() == null ? null : (int) Math.round(getAverageRating());
	}
}
