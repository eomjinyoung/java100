/* 이 SQL은 bitcamp-java-project-v38.sql에 추가해야 한다.*/

/* ex_board 에 게시글 작성자 컬럼을 추가한다.*/
alter table ex_board
  add column mno int not null;

/* 작성자 컬럼을 ex_memb 테이블의 no 컬럼을 참조하는 외부키로 선언한다.*/
alter table ex_board
  add constraint foreign key (mno) references ex_memb(no); 

