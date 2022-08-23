package com.hotelapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hotelapp.model.Category;
import com.hotelapp.model.Hotel;
import com.hotelapp.model.Type;
import com.hotelapp.repositary.IHotelRepositary;
@Service
public class HotelServiceImpl implements IHotelService {
@Autowired
IHotelRepositary hotelRepositary;
	@Override
	public Hotel addHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelRepositary.save(hotel);
	}

	@Override
	public void updateHotel(Hotel hotel) {
		hotelRepositary.save(hotel);
		
	}

	@Override
	public void deleteHotel(int hotelId) {
		hotelRepositary.deleteById(hotelId);;
		
	}

	@Override
	public List<Hotel> getAll() {
		Sort sort=Sort.by(Direction.DESC,"name");
		return hotelRepositary.findAll(sort);
	}

	@Override
	public Hotel getById(int hotelId) {
		// TODO Auto-generated method stub
		return hotelRepositary.findById(hotelId).get();
	}

	@Override
	public List<Hotel> getByCity(String city) {
		// TODO Auto-generated method stub
		return hotelRepositary.findByCity(city);
	}

	@Override
	public List<Hotel> getByType(Type type) {
		Sort sort=Sort.by(Direction.DESC,"type");
		return hotelRepositary.getByType(type,sort);
	}

	@Override
	public List<Hotel> getByRatings(double ratings) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> getByItemName(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> getByItemNameCategory(String itemName, Category category) {
		// TODO Auto-generated method stub
		return hotelRepositary.findByItemNameCategory(itemName, category);
	}

	@Override
	public List<Hotel> getByCuisine(String cuisine) {
		// TODO Auto-generated method stub
		return hotelRepositary.findByCuisine(cuisine);
	}

	@Override
	public List<Hotel> getByCategory(Category category) {
		// TODO Auto-generated method stub
		return hotelRepositary.findByCategory(category);
	}

	@Override
	public List<Hotel> getByCusineAndType(String cuisine, Type type) {
		// TODO Auto-generated method stub
		return hotelRepositary.findByCuisineAndType(cuisine, type);
	}

	@Override
	public List<Hotel> getByItemNameLessPrice(String itemName, double price) {
		// TODO Auto-generated method stub
		return hotelRepositary.findByItemNameLessPrice(itemName, price);
	}

	
}
