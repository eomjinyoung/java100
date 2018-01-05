/* 이 SQL은 bitcamp-java-project-v38.sql에 추가해야 한다.*/

/* 게시글 첨부 파일명을 저장할 테이블을 정의한다.*/
create table ex_file (
  no int not null,
  filename varchar(255) not null,
  bno int not null
);

/* primary key 컬럼 지정 */
alter table ex_file
  add constraint primary key (no);

/* ex_file의 pk 컬럼은 자동증가 컬럼으로 만든다. */
alter table ex_file
  modify column no int not null auto_increment;

/* ex_file의 bno 컬럼을 ex_board의 no 값을 참조하는 외부키로 만든다.*/
alter table ex_file
  add constraint foreign key (bno) references ex_board(no);

  
  
  
  
  
  
