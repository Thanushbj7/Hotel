package com.hotelapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hotelapp.model.Category;
import com.hotelapp.model.Hotel;
import com.hotelapp.model.Item;
import com.hotelapp.model.Type;
import com.hotelapp.service.IHotelService;

@SpringBootApplication
public class SpringDatajpaOnetomanyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaOnetomanyApplication.class, args);
	}
@Autowired
IHotelService hotelService;
	@Override
	public void run(String... args) throws Exception {
		Item item1=new Item("Dosa",Category.BREAKFAST,"SI",Type.VEG,100);
		Item item2=new Item("Idly",Category.BREAKFAST,"SI",Type.VEG,150);
		Item item3=new Item("Palav",Category.BREAKFAST,"SI",Type.VEG,50);
		Item item4=new Item("Ice Cream",Category.BEVERAGES,"Juices",Type.VEG,300);
		Set<Item> items=new HashSet<>(Arrays.asList(item1,item2,item3));
		
		
		Hotel hotel=new Hotel("Taj",Type.VEG,"Hyderabad",4.5,items);
		hotelService.addHotel(hotel);
		Item item5=new Item("Dosa",Category.BREAKFAST,"SI",Type.VEG,100);
		Item item6=new Item("Idly",Category.BREAKFAST,"SI",Type.VEG,170);
//		Item item7=new Item("Chicken Biryani",Category.MAINCOURSE,"Juices",Type.VEG,50);
		Set<Item> itemsList1=new HashSet<Item>(Arrays.asList(item4,item5,item6));
		
		Hotel hotel1=new Hotel("Sagar",Type.VEG,"Hyderabad",3,itemsList1);
//		hotelService.addHotel(hotel1);
//		hotelService.getAll().forEach(System.out::println);
//		hotelService.getById(100);
		hotelService.getByItemNameCategory("Dosa",Category.BREAKFAST).forEach(nhotel->{
			System.out.println("Name "+nhotel.getName());
			System.out.println("City "+nhotel.getCity());
			
			nhotel.getItemList().forEach(nitem->{
				System.out.println("ItemName "+nitem.getItemName());
				System.out.println("ItemName "+nitem.getCuisine());
				System.out.println("ItemName "+nitem.getCategory());
				System.out.println("ItemName "+nitem.getPrice());
			});
		});
		System.out.println();
		hotelService.getByType(Type.NONVEG).forEach(nhotel->{
			System.out.println("Name "+nhotel.getName());
			System.out.println("City "+nhotel.getCity());
			
			nhotel.getItemList().forEach(nitem->{
				System.out.println("ItemName "+nitem.getItemName());
				System.out.println("ItemName "+nitem.getCuisine());
				System.out.println("ItemName "+nitem.getCategory());
				System.out.println("ItemName "+nitem.getPrice());
			});
		});
		
	}

}
