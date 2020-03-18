package ru.javabegin.training.spring.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javabegin.training.spring.dao.impls.SQLiteDAO;
import ru.javabegin.training.spring.dao.objects.MP3;

import java.util.List;

public class Start {

	public static void main(String[] args) {
		// MP3 firstMP3 = new MP3();
		// firstMP3.setName("Song name");
		// firstMP3.setAuthor("Song author");
		//
		// MP3 secondMP3 = new MP3();
		// secondMP3.setName("Song name2");
		// secondMP3.setAuthor("Song author2");
		//
		// List<MP3> list = new ArrayList<>();
		//
		// list.add(firstMP3);
		// list.add(secondMP3);
		//
		// // new SQLiteDAO().insertWithJDBC(mp3);
		//
		 ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		 SQLiteDAO sqLiteDAO = (SQLiteDAO) context.getBean("sqliteDAO");

		List<MP3> mp3List = sqLiteDAO.getMP3ListByAuthor("evc");

		for (MP3 mp3 : mp3List) {
			System.out.println(mp3.getId() + " " + mp3.getName()
					+ " " + mp3.getAuthor().getId() + " " + mp3.getAuthor().getName());
		}


	}
}
