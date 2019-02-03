**This Project is Built Purely on Java (GUI support using Swing Package) and used local mysql database.**
To run this project make sure:
1. Java is installed.
2. A mysql server is up and running.

First go and run the client side of mysql database.
Make a new user "zemotacqy" with password "Zemotacqy" and grant this user all permissions.
Refer here: [Setup Mysql Locally](https://www.digitalocean.com/community/tutorials/how-to-create-a-new-user-and-grant-permissions-in-mysql)
Run the following commands in succession:

create database login;
create table student(student_id int(10) NOT NULL auto_increment PRIMARY KEY, student_name varchar(100) ,age int(10) , course varchar(100) , college varchar(100) , contact int(10) );
insert into student(student_id , student_name , age , course , college , contact ) values(1 , 'master' , 1 , 'course' , 'college' , 1234567891);
create table teacher(teacher_id int(10) NOT NULL auto_increment PRIMARY KEY, teacher_name varchar(100) ,age int(10) , subject varchar(100) , qualifications varchar(100) , contact int(10) );
insert into teacher(teacher_id , teacher_name , age , subject , qualifications , contact ) values(1 , 'master' , 1 , 'subject' , 'qualifications' , 1234567891);

Now go to a cmd and then go the directory which contains all the java files in "connection".
And run the command - javac *.java
(This will create .class files of all the java files in connection folder)
Now go and run in same cmd : java Login_page
**Use username:admin and password: admin**

![small Preview](https://github.com/Zemotacqy/Student-Teacher-Portal/blob/master/Preview.JPG)
