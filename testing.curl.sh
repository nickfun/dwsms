

curl -X POST -d to=123123 -d body=the-far-past -d "date=1984-09-09 08:08:08" http://localhost:8080/submit
curl -X POST -d to=123123 -d body=the-recent-past -d "date=2013-11-11 09:09:09" http://localhost:8080/submit
curl -X POST -d to=123123 -d body=the-future -d "date=2019-12-28 23:12:08" http://localhost:8080/submit

echo

