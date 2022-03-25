package com.github.devxzero;

import com.github.devxzero.entities.Comment;
import com.github.devxzero.entities.Post;
import com.github.devxzero.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize JPA and Hibernate
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.github.devxzero.jpa-template");

        // Start persistence context with an new entityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Start a transaction
        entityManager.getTransaction().begin();

        // Persist new user
        User user = new User("Joe");
        entityManager.persist(user);

        // Persist new post
        Post post = new Post();
        post.setTitle("Post 1");
        post.setContent("This is my first post!");
        entityManager.persist(post);

        // Persist multiple new comments
        for (int i = 0; i < 1; i++) {
            Comment comment = new Comment("reply 1", post, user);
            entityManager.persist(comment);
            post.getComments().add(comment);
        }

        // Query comments
        List<Comment> comments = entityManager.createQuery("from Comment")
                .setMaxResults(1)
                .getResultList();
        for (Comment comment : comments) {
            System.out.println(comment);
        }

        // Commit transaction
        entityManager.getTransaction().commit();

        // Close persistence context
        entityManager.close();
    }
}
