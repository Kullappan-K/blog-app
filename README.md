# blog-app

1. Read the all blogs of the application.
GET /allblogs

2. Read the all article of the application.
GET /allarticle

3. Read the particular blog of the application.
GET /blog/1

4. Read the particular article of the application.
GET /blog/1/articles

5. Create the new blog(provide the insert JSON of the blog)
POST /addblog/create

6.Create the new article(provide the insert JSON of the article)
POST /addarticle/create

7. Create the JWT token

I have created the static username and password(Refer the data.sql file).

POST /login

8. Read the all comments for particular blog of the application
GET /blog/1/comments

9.Read the particular comments of the application
GET /blog/1/comments/1

10. Create the new Comments(provide the insert JSON of the comments)
POST /addcomments/create

11. Create the new Reply(provide the insert JSON of the reply)
POST /addreply/create
