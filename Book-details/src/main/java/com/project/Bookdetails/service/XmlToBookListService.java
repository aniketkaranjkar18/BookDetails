package com.project.Bookdetails.service;

import java.io.File;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.project.Bookdetails.model.Book;
import com.project.Bookdetails.model.Catalog;

@Service
public class XmlToBookListService {

	private List<Book> books;

	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private final Lock readLock = readWriteLock.readLock();

	public List<Book> getBooks(String path) {

		readLock.lock();
		try {
			File xmlFile = new File(path);
			JAXBContext jaxbContext;
			jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Catalog catalog = (Catalog) jaxbUnmarshaller.unmarshal(xmlFile);
			books = catalog.getBooks();
		} catch (JAXBException e) {
			e.printStackTrace();
		} finally {
			readLock.unlock();
		}
		return books;
	}

}
