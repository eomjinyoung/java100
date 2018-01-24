/* 강의실 데이터 준비 */
insert into room(rno, loc, name, qnty) values(1, '강남', '501', 30);
insert into room(rno, loc, name, qnty) values(2, '강남', '502', 30);
insert into room(rno, loc, name, qnty) values(3, '강남', '503', 30);
insert into room(rno, loc, name, qnty) values(4, '종로', '301', 30);
insert into room(rno, loc, name, qnty) values(5, '종로', '302', 30);
insert into room(rno, loc, name, qnty) values(6, '종로', '303', 30);
insert into room(rno, loc, name, qnty) values(7, '서초', '301', 30);
insert into room(rno, loc, name, qnty) values(8, '서초', '302', 30);
insert into room(rno, loc, name, qnty) values(9, '서초', '501', 30);
insert into room(rno, loc, name, qnty) values(10, '서초', '601', 30);

/* 학생 데이터 입력 */
insert into memb(mno, name, tel, email, pwd)
values(100, 's100', '111-1111', 's100@', password('1111'));
insert into memb(mno, name, tel, email, pwd)
values(101, 's101', '111-1111', 's101@', password('1111'));
insert into memb(mno, name, tel, email, pwd)
values(102, 's102', '111-1111', 's102@', password('1111'));
insert into memb(mno, name, tel, email, pwd)
values(103, 's103', '111-1111', 's103@', password('1111'));
insert into memb(mno, name, tel, email, pwd)
values(104, 's104', '111-1111', 's104@', password('1111'));

insert into stnt(mno, work, acc_no, bank)
values(100, 'N', '1000', '비트은행');
insert into stnt(mno, work, acc_no, bank)
values(101, 'Y', '1001', '비트은행');
insert into stnt(mno, work, acc_no, bank)
values(102, 'N', '1002', '캠프은행');
insert into stnt(mno, work, acc_no, bank)
values(103, 'Y', '1003', '우리은행');
insert into stnt(mno, work, acc_no, bank)
values(104, 'N', '1004', '국민은행');

/* 강사 데이터 입력 */
insert into memb(mno, name, tel, email, pwd)
values(200, 's200', '111-1111', 's200@', password('1111'));
insert into memb(mno, name, tel, email, pwd)
values(201, 's201', '111-1111', 's201@', password('1111'));
insert into memb(mno, name, tel, email, pwd)
values(202, 's202', '111-1111', 's202@', password('1111'));
insert into memb(mno, name, tel, email, pwd)
values(203, 's203', '111-1111', 's203@', password('1111'));
insert into memb(mno, name, tel, email, pwd)
values(204, 's204', '111-1111', 's204@', password('1111'));

insert into tcher(mno, hr_pay, acc_no, bank)
values(200, 10000, '2000', '신한은행');
insert into tcher(mno, hr_pay, acc_no, bank)
values(201, 20000, '2001', '농협');
insert into tcher(mno, hr_pay, acc_no, bank)
values(202, 15000, '2002', '기업은행');
insert into tcher(mno, hr_pay, acc_no, bank)
values(203, 25000, '2003', '우리은행');
insert into tcher(mno, hr_pay, acc_no, bank)
values(204, 30000, '2004', '국민은행');




