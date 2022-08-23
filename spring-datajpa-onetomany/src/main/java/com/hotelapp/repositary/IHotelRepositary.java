package com.hotelapp.repositary;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelapp.model.Category;
import com.hotelapp.model.Hotel;
import com.hotelapp.model.Type;
@Repository
public interface IHotelRepositary extends JpaRepository<Hotel,Integer> {
List<Hotel> findByCity(String city);
List<Hotel> getByType(Type type,Sort sort);
List<Hotel> getByRatings(String ratings);

List<Hotel> getByItemListItemName(String name);

@Query("from Hotel h inner join h.itemList i where i.itemName=?1")
List<Hotel> findByItemName(String itemName);

@Query("from Hotel h inner join h.itemList i where i.itemName=?1 or i.category=?2")
List<Hotel> findByItemNameCategory(String itemName,Category category);

@Query("from Hotel h inner join h.itemList i where i.cuisine=?1")
List<Hotel> findByCuisine(String cuisine);

@Query("from Hotel h inner join h.itemList i where i.category=?1")
List<Hotel> findByCategory(Category category);

@Query("from Hotel h inner join h.itemList i where i.cuisine=?1  and h.type=?2")
List<Hotel> findByCuisineAndType(String cuisine,Type type);

@Query("from Hotel h inner join h.itemList i where i.itemName=?1 and i.price<=?2")
List<Hotel> findByItemNameLessPrice(String itemName,double price);


}
