package org.pt.learning.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.pt.learning.entity.Blog;
import org.pt.learning.entity.Message;
import org.pt.learning.enums.Status;
import org.pt.learning.jpa.repositories.BlogRepo;
import org.pt.learning.jpa.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InitDbService {
	
	@Autowired
	private BlogRepo blogRepo;
	
	@Autowired
	private MessageRepo messageRepo;
	
	@PostConstruct
	@Transactional
	public void initDB(){
		try{
			Blog blog1 = blogRepo.save(InitDbService.create1());
			Blog blog2 = blogRepo.save(InitDbService.create2());
			List<Message> list = InitDbService.messageList();
			list.get(0).setBlog(blog1);
			list.get(1).setBlog(blog1);
			list.get(2).setBlog(blog2);
			list.get(3).setBlog(blog2);
			messageRepo.save(list.get(0));
			messageRepo.save(list.get(1));
			messageRepo.save(list.get(2));
			messageRepo.save(list.get(3));
			System.out.println(blog1);
			System.out.println(blog2);
			System.out.println(list);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	private static Blog create1(){
		Blog blog = new Blog();
		blog.setAuthor("Prashant T");
		blog.setCreatedOn(new Date());
		blog.setEmail("prashanttiwari@gmail.com");
		blog.setStatus(Status.HALF_COMPLETE);
		blog.setTitle("PandoDaily");
		blog.setUpdatedOn(new Date());
		return blog;
	}
	
	private static Blog create2(){
		Blog blog = new Blog();
		blog.setAuthor("XXX");
		blog.setCreatedOn(new Date());
		blog.setEmail("secretxxxagent@gmail.com");
		blog.setStatus(Status.COMPLETE);
		blog.setTitle("Webdesigner Depot");
		blog.setUpdatedOn(new Date());
		return blog;
	}
	
	private static List<Message> messageList(){
		List<Message> messages = new ArrayList<Message>();
		Message message1 = new Message();
		Message message2 = new Message();
		Message message3 = new Message();
		Message message4 = new Message();
		message1.setMessage(InitDbService.getMessage().get(0));
		message2.setMessage(InitDbService.getMessage().get(1));
		message3.setMessage(InitDbService.getMessage().get(2));
		message4.setMessage(InitDbService.getMessage().get(3));
		messages.add(message1);
		messages.add(message2);
		messages.add(message3);
		messages.add(message4);
		return messages;
	}

	
	
	private static List<String> getMessage(){
		List<String> list = new ArrayList<String>();
		list.add("Even the most unique blog designs usually follow, at least in part, some sort of predefined or established style. And there are plenty of design styles to choose from if you’re looking for inspiration. Whatever your personal style, there are design patterns out there that can be adapted to suit your own aesthetic ideal and the needs of your site. And often working within a predefined pattern can enhance your creativity by helping you focus.");
		list.add("Below we’ve rounded up eleven common design patterns seen throughout blog designs on the web. But just because they’re commonly seen doesn’t mean they aren’t unique and filled with plenty of individuality and creativity. Figuring out how to make your own unique mark on a widely-recognized style can prove to be a creative challenge for nearly any designer. Read on for inspiration and ideas for your next design projects.");
		list.add("Webdesigner Depot's banner stands out with its bright colors and subtle details, all the while working itself seamlessly into the design of the entire blog. The color scheme, background, and fonts are all consistent -- which keeps this blog looking professional --  while still distinct from the basic blog templates we're all used to seeing.");
		list.add("Mashable breaks its content into three noticeable sections on the homepage: New posts are listed on the left in the smallest sized thumbnails, the Whats Rising posts are displayed in the center column as large thumbnails, and the What's Hot posts are shown to the right, also as large thumbnails. We also like that it includes the number of people who have shared an article in each post preview -- a great form of social proof.");
		return list;
	}

}
