insert into Sport(name,description) values ('Basketball','Professional Basketball');
insert into Sport(name,description) values ('Football','Professional Football');
insert into Sport(name,description) values ('Baseball','Professional Baseball');


--Events
insert into Event(name,description,start_date,end_date,time,home_team_id,away_team_id,sport_id,tickets) values ('2020 NBA Finals','The 2020 NBA Finals',TO_DATE('09/30/2020','MM/dd/yyyy'),TO_DATE('10/11/2020','MM/dd/yyyy'), {ts '2020-09-30 18:00:00.00'}, 20, 15, 1,5000);
insert into Event(name,description,start_date,end_date,time,home_team_id,away_team_id,sport_id,tickets) values ('Super Bowl LIV','Super Bowl LIV, 2020',TO_DATE('02/02/2020','MM/dd/yyyy'),TO_DATE('02/02/2020','MM/dd/yyyy'), {ts '2020-02-02 17:30:00.00'}, 2, 4, 2,20000);
insert into Event(name,description,start_date,end_date,time,home_team_id,away_team_id,sport_id,tickets) values ('2020 Stanley Cup Finals','The 2020 NHL Stanley Cup Finals',TO_DATE('09/19/2020','MM/dd/yyyy'),TO_DATE('09/28/2020','MM/dd/yyyy'), {ts '2020-09-19 18:00:00.00'}, 36, 30, 3,8000);
