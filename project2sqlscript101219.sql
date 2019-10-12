/*  Project Cipher by The Cipher Gentlemen : Database Operations For Project 2
 *  ==========================================================================
 *      @authors Edward Sams, Nathan Cross, David Blitz, Efrain Vila
 * 
 *  Database Name   : cipher
 *  Schema          : public
 *  Tables          : Users, Forums, Portfolio, Stocks
 *  Keys            : user_id, forums_id, portfolio_id, stocks_id
 *  Foreign Keys    : forums_user(user_id), portfolio_user(user_id), stocks_portfolio(portfolio_id) 
 * 
 *  API             : 
 *  Implimentation  : Hibernate, Jenkins, Spring, Angular
 *  
 *  The tables will be added in Java via Hibernate.
 *  Adapt as needed.
 * 
 */

--CREATE DATABASE Cipher (created)

--DROP TABLE users CASCADE

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
stocks_id serial PRIMARY KEY,
stocks_portfolio integer,
stocks_shares NUMERIC (10,2),
stocks_company varchar (100),
stocks_symbol varchar (100),
FOREIGN KEY (stocks_portfolio) REFERENCES portfolios(portfolio_id)
);

--DROP TABLE Article CASCADE
--CREATE TABLE Article (
--article_id serial PRIMARY KEY,
--article_sourceid varchar (300),
--article_title varchar(300),
--article_symbols varchar (300)
--
--);
--------------------------------------------------------
