package com.hotelapp.service;

import java.util.List;

import com.hotelapp.model.Category;
import com.hotelapp.model.Hotel;
import com.hotelapp.model.Type;
public interface IHotelService {
Hotel addHotel(Hotel hotel);
void updateHotel(Hotel hotel);
void deleteHotel(int hotelId);
List<Hotel> getAll();
Hotel getById(int hotelId);

List<Hotel> getByCity(String city);
List<Hotel> getByType(Type type);
List<Hotel> getByRatings(double ratings);


List<Hotel> getByItemName(String itemName);
List<Hotel> getByItemNameCategory(String itemName,Category category);
List<Hotel> getByCuisine(String cuisine);
List<Hotel> getByCategory(Category  category);
List<Hotel> getByCusineAndType(String cuisine,Type type);
List<Hotel> getByItemNameLessPrice(String itemName,double price);
}
