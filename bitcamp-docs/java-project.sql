/* 성적 정보 테이블 */
create table ex_score (
    no int not null,
    name varchar(30) not null,
    kor int not null,
    eng int not null,
    math int not null
);

alter table ex_score
    add constraint primary key (no);

alter table ex_score
    modify column no int not null auto_increment;
    
alter table ex_score
    add fulltext (name);
    
    
    
    
    
    
    
    
    