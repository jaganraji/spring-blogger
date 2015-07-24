package com.jagan.jba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.jagan.jba.entity.Blog;
import com.jagan.jba.entity.Item;
import com.jagan.jba.entity.User;
import com.jagan.jba.exception.RssException;
import com.jagan.jba.repository.BlogRepository;
import com.jagan.jba.repository.ItemRepository;
import com.jagan.jba.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private RssService rssService;

	public void saveItems(Blog blog) {
		try {
			List<Item> items = rssService.getItems(blog.getUrl());
			for (Item item : items) {
				Item savedItem = itemRepository.findByBlogAndLink(blog, item.getLink());
				if (savedItem == null) {
					item.setBlog(blog);
					itemRepository.save(item);
				}
			}
		} catch (RssException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void save(Blog blog, String name) {
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
		saveItems(blog);
	}

	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		blogRepository.delete(blog);

	}

	public Blog findOne(int id) {
		return blogRepository.findOne(id);
	}

}
