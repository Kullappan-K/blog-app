DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS BLOG;
DROP TABLE IF EXISTS ARTICLE;
DROP TABLE IF EXISTS COMMENTS;
DROP TABLE IF EXISTS REPLIES;

CREATE TABLE USERS (user_id INT  AUTO_INCREMENT NOT NULL, username VARCHAR(250) PRIMARY KEY NOT NULL, pass VARCHAR(250) NOT NULL);
CREATE TABLE BLOG (id INT  AUTO_INCREMENT NOT NULL, blog_name VARCHAR(250) NOT NULL, blog_description VARCHAR(500) NOT NULL ,created_at VARCHAR(50) NOT NULL, updated_at VARCHAR(50) NOT NULL, user_id VARCHAR(100) NOT NULL, PRIMARY KEY(id, user_id));
CREATE TABLE ARTICLE (id INT  AUTO_INCREMENT NOT NULL, blog_id INT NOT NULL, title VARCHAR(200) NOT NULL, article_body VARCHAR(5000) NOT NULL, author_id VARCHAR(100) NOT NULL, created_at VARCHAR(50) NOT NULL, updated_at VARCHAR(50) NOT NULL, published_at VARCHAR(50) NOT NULL, category VARCHAR(100) NOT NULL, PRIMARY KEY(id, author_id));
CREATE TABLE COMMENTS (id INT  AUTO_INCREMENT NOT NULL, blog_id INT NOT NULL, author_id VARCHAR(100) NOT NULL, comment_body VARCHAR(500) NOT NULL, created_at VARCHAR(50) NOT NULL, PRIMARY KEY(id, blog_id));
CREATE TABLE REPLIES (id INT  AUTO_INCREMENT NOT NULL, comment_id INT NOT NULL, author_id VARCHAR(100) NOT NULL, reply_body VARCHAR(500) NOT NULL, created_at VARCHAR(50) NOT NULL, PRIMARY KEY(id, comment_id));