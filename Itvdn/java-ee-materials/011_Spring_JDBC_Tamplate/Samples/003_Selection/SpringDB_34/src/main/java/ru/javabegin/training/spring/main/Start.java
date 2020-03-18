package ru.javabegin.training.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.javabegin.training.spring.dao.interfaces.MP3Dao;
import ru.javabegin.training.spring.dao.objects.MP3;

import java.util.List;

public class Start {

	public static void main(String[] args) {
//		MP3 mp3 = new MP3();
//		mp3.setName("Song name");
//		mp3.setAuthor("Song author");

		// new SQLiteDAO().insertWithJDBC(mp3);

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		MP3Dao sqLiteDAO = (MP3Dao) context.getBean("sqliteDAO");

//		List<MP3> mp3List = sqLiteDAO.getMP3ListByName("an");
//
//		for (MP3 mp3 : mp3List) {
//			System.out.println(mp3.getId() + " " + mp3.getAuthor() + " " + mp3.getName());
//		}
		System.out.println("Count mp3: " + sqLiteDAO.getMP3Count());
	}
}
