package ru.javabegin.training.spring.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.javabegin.training.spring.dao.impls.SQLiteDAO;
import ru.javabegin.training.spring.dao.objects.MP3;

public class Start {

	public static void main(String[] args) {
		MP3 firstMP3 = new MP3();
		firstMP3.setName("Song name111");
		firstMP3.setAuthor("Song author111");

		MP3 secondMP3 = new MP3();
		secondMP3.setName("Song name222");
		secondMP3.setAuthor("Song author222");

		List<MP3> list = new ArrayList<MP3>();

		list.add(firstMP3);
		list.add(secondMP3);

		// new SQLiteDAO().insertWithJDBC(mp3);

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		SQLiteDAO sqLiteDAO = (SQLiteDAO) context.getBean("sqliteDAO");

		MP3 mp3 = new MP3();
		mp3.setName("New Name");
		mp3.setAuthor("New Author");

		sqLiteDAO.insert(mp3);

		//System.out.println(sqLiteDAO.insertList(list));
	}
}
