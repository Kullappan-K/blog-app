INSERT INTO USERS(username, pass) VALUES ('AAA', 'AAA'), ('BBB', 'BBB');
INSERT INTO BLOG(id, blog_name, blog_description, created_at, updated_at, user_id) VALUES (1, 'My Travel Blog', 'Blog about Travel', '2012-02-02 00:00:00.000Z', '2012-02-02 00:00:00.000Z', '1'),
(2, 'My Personal Blog', 'Blog about Personal', '2012-02-02 00:00:00.000Z', '2012-02-02 00:00:00.000Z', '1');
INSERT INTO article(id, blog_id, title, article_body, author_id, created_at, updated_at, published_at, category) VALUES(1, 1, 'Trip of Assam', 'Beautiful Nature', '1', '2012-02-02 00:00:00.000Z', '2012-02-02 00:00:00.000Z', '2012-02-02 00:00:00.000Z', 'Travel'),
(2, 1, 'Trip of Assam', 'Beautiful Nature', '1' ,'2012-02-02 00:00:00.000Z', '2012-02-02 00:00:00.000Z', '2012-02-02 00:00:00.000Z', 'Travel');