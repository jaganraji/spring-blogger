package com.jagan.jba.service;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.jagan.jba.entity.Item;
import com.jagan.jba.exception.RssException;

public class RssServiceTest {

	private RssService rssService;

	@Before
	public void setUp() throws Exception {
		rssService = new RssService();

	}

	@Test
	public void testGetItemsFile() throws RssException {
		List<Item> items = rssService.getItems(new File("test-rss/javavids.xml"));
		System.out.println(items.size());
		assertEquals(47, items.size());
		Item firstItem = items.get(0);
		System.out.println(firstItem.getTitle());
		assertEquals("1 brother behind bars; 1 on the run for 23 years", firstItem.getTitle());
		assertEquals("23 07 2015 12:14", new SimpleDateFormat("dd MM yyyy HH:mm").format(firstItem.getPublishedDate()));

	}

}
