package com.project.Bookdetails.service;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Bookdetails.model.Book;
import com.project.Bookdetails.repository.BookRepository;

@Service
@Transactional
public class BookRepoService {

	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private final Lock writeLock = readWriteLock.writeLock();

	@Autowired
	BookRepository bookRepo;

	@Autowired
	XmlToBookListService xml;

	public void addAllBooks(String path) {
		writeLock.lock();
		try {
			List<Book> books = xml.getBooks(path);
			int count = 0;
			for (Book book : books) {
				bookRepo.save(book);
				count = count + 1;
			}
			System.out.println(count + " books added to the table");
		} finally {
			writeLock.unlock();
		}
	}

}
