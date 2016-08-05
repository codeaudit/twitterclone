--create user table
create table Users(id int primary key, username varchar(25), avatar varchar(15), follows varchar(25));
create table Tweets(id int primary key, user_id int, message varchar(140), hit_time timestamp, foreign key(user_id) references Users(id));
create table Followers(id int primary key, user_id1 int, user_id2 int, foreign key(user_id1) references Users(id), foreign key(user_id2) references Users(id));
