/*  Project Cipher by The Cipher Gentlemen : Database Operations For Project 2
 *  ==========================================================================
 *      @authors Edward Sams, Nathan Cross, David Blitz, Efrain Vila
 * 
 *  Database Name   : cipher
 *  Schema          : public
 *  Tables          : Users, Forums, Portfolio, Stocks
 *  Keys            : user_id, forums_id, portfolio_id, stocks_id
 *  Foreign Keys    : forums_user(user_id), portfolio_user(user_id), stock_users(user_id) 
 * 
 *  Implimentation  : Hibernate, Jenkins, Spring, Angular
 *  
 *  The tables will be added in Java via Hibernate / Spring.
 *  Adapt as needed.
 * 
 */

--CREATE DATABASE Cipher (created)

-- DROP TABLE users CASCADE

CREATE TABLE users(
user_id serial PRIMARY KEY,
user_lastname varchar(100),
user_firstname varchar(100),
user_email varchar(100),
user_password varchar(100),
user_streetaddress varchar(300),
user_city varchar (100),
user_state varchar (100)
);

--DROP TABLE forums CASCADE

CREATE TABLE forums (
forums_id serial PRIMARY KEY,
forums_topic varchar (100),
forums_comment varchar (1000),
forums_user integer,
FOREIGN KEY (forums_user) REFERENCES users(user_id)
);

--DROP TABLE portfolios CASCADE

CREATE TABLE portfolios (
portfolio_id serial PRIMARY KEY,
portfolio_user integer,
portfolio_return NUMERIC (10,2),
portfolio_amount NUMERIC (10,2),
FOREIGN KEY (portfolio_user) REFERENCES users(user_id)
);

--DROP TABLE stocks CASCADE

CREATE TABLE stocks (
stock_id serial PRIMARY KEY,
stock_shares NUMERIC (10,2),
stock_quantity numeric (10,2),
stock_symbol varchar (100),
stock_price NUMERIC (10,2),
stock_users integer,
FOREIGN KEY (stock_users) REFERENCES users(user_id)
);

--DROP TABLE Article CASCADE
--CREATE TABLE Article (
--article_id serial PRIMARY KEY,
--article_sourceid varchar (300),
--article_title varchar(300),
--article_symbols varchar (300)
--
--);

INSERT INTO public.users (user_lastname,user_firstname,user_email,user_password) VALUES 
('Sakurai','Meiru','MSeiru@rockmanexe.com','Heart')
,('Black','Joe','Jblack@yahoo.com','black')
,('Morgan','JP','JPMorgan@yahoo.com','Chase')
,('Lee','Bruce','Hikick@gmail.com','Hiyaa')
,('Smith','John','Jsmith@cipherstock.com','jsmith')
,('Light','Thomas','TLight@rmbn.net','Met')
,('White','Jane','JWhite@gmail.com','JWhite')
,('Hikari','Netto','NHikari@rmbn.net','PlugIn')
,('Morgan','Greg','GMorgan@cipherstock.com','gmorgan')
,('Gear','Axel','Agear@rocketknight.com','Power')
;
INSERT INTO public.users (user_lastname,user_firstname,user_email,user_password) VALUES 
('Mac','Littal','LMac@punchout.org','KnockOut')
,('Chan','Jackie','LightningPunch@gmail.com','smack')
,('Ursa','Teddy','TUrsa@soft.org','Snuggle')
,('Docker','Lern','LDocker@clab.org','coding')
;
--------------------------------------------------------

SELECT f.forums_id "Post Number", f.forums_topic "Topic", f.forums_comment "Comments", concat(u.user_firstname, ' ', u.user_lastname) "Member Name"
FROM forums f INNER JOIN users u ON f.forums_user = u.user_id ORDER BY f.forums_id;

---------------------------------------

INSERT INTO public.forums (forums_topic,forums_comment,forums_user) VALUES 
('Microsoft Stock Rises','Shocking',14)
,('Microsoft Stock Rises','My stock is worth more',8)
,('Google ','Need for price to drop.',6)
,('Oracle Stock','Oracle stock is rising!!',14)
,('Oracle Stock','I just sold it my stock, I should of held on longer.',12)
,('Oracle Stock','Think long term returns, not short term profit.',14)
,('Gold','The future is in gold. It does not drop.',2)
,('Gold','I guess my jewelry is more valuable.',5)
,('Oil','If the price continues to rise, I wont be able to afford gas.',6)
,('Oil','Isnt there enought oil?',8)
;
INSERT INTO public.forums (forums_topic,forums_comment,forums_user) VALUES 
('Oil','This also affect airline prices. Higher oil prices, higher air fairs.',9)
,('Oil','Think about hybrids or electric vehicles. Their stocks might go up.',2)
,('Stock Advice','This it good to have all my stock in one company?',15)
,('Stock Advice','No , you want to diversify between diffferent stocks in different industries.',3)
,('Stock Advice','I recommend you meet with you finanicial adviser/broker for more help on choosing stock.',3)
,('Stock Advice','Thank You, I will meet with them next week.',15)
,('Netflix','Is this stock worth buying now?',13)
,('Netflix','Can not say for sure but I would wait a bit and watch their quarterlies.',2)
,('Netflix','There are other companies worth buying for a smart investment at this time.',3)
,('The market','The bulls are out today!!',10)
;
--------------------------------------------------------------------------------

