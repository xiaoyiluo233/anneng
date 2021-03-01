/*创建包裹表 */                                                                     '
create table parcel
(
    parcelId int not null primary key ,
    oid  varchar(100) not null,
    nextStation int not null ,
    upStation int not null,
    state int not null
);