package DesignPatterns.ObserverPattern;

public class Test {

	public static void main(String[] args) {
		MyBlog blog = new MyBlog();
		User user1 = new User();
		User user2 = new User();
		user1.setSubject(blog);
		user2.setSubject(blog);
		
		blog.register(user2);
		blog.register(user1);
		
		System.out.println(user1.getMessage());
		blog.postNewArticle();
		System.out.println(user1.getMessage());

	}

}
