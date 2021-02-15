
Запрос 1. Ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени. 
Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность».

SELECT q.film_name, q.start_time, q.film_duration, q.finish_time, f.title as next_film_name, q.next_start_time, 
       f.duration as next_film_duration, q.finish_time - q.next_start_time as overlap FROM
(SELECT f.id, f.title as film_name, s.start_time as start_time, f.duration as film_duration, 
  s.start_time + f.duration * INTERVAL '1' MINUTE as finish_time,
        LEAD(start_time, 1) OVER (ORDER BY s.id) next_start_time,
        LEAD(film_id, 1) OVER (ORDER BY s.id) next_film_id
FROM cinema.sessions s JOIN cinema.films f on (s.film_id = f.id) 
ORDER BY s.id ASC) q
JOIN cinema.films f on f.id = q.next_film_id 
WHERE finish_time > next_start_time


Запрос 2. перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва. 
Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;

SELECT q.*, q.next_start_time - q.finish_time AS timeout FROM
(SELECT f.title, s.start_time AS start_time, f.duration AS duration, 
  s.start_time + f.duration * INTERVAL '1' MINUTE AS finish_time,
        LEAD(start_time, 1) OVER (ORDER BY s.id) next_start_time
FROM cinema.sessions s JOIN cinema.films f on (s.film_id = f.id) 
ORDER BY s.id ASC) q
WHERE q.next_start_time - q.finish_time > '00:30'
ORDER BY timeout DESC 


Запрос 3. Просмотр статистики по каждому фильму.

SELECT COALESCE(f.title, 'Итого:') AS title, COUNT(t.id) AS viewers, 
       COUNT(DISTINCT s.id) AS sessions_count, COALESCE(SUM(price),0) AS total_income, 
       COALESCE(COUNT(*) / NULLIF(COUNT(DISTINCT s.id), 0), 0) AS average_viewers  FROM cinema.sessions s
JOIN cinema.tickets t ON t.session_id = s.id
RIGHT JOIN cinema.films f on s.film_id = f.id
GROUP BY ROLLUP(title)

Запрос 4. Просмотр статистики по временным интервалам 

SELECT COALESCE(start_period, 'Итого:') AS time_interval, SUM(price) AS total_income, COUNT(ticket_id) AS viewers FROM (
SELECT f.title, s.start_time AS start_time, f.duration AS duration, 
       s.start_time + f.duration * INTERVAL '1' MINUTE AS finish_time,
       s.price, t.id as ticket_id,
  CASE
    WHEN s.start_time >= '00:00:00' AND s.start_time < '09:00:00' THEN '00:00 - 09:00'
    WHEN s.start_time >= '09:00:00' AND s.start_time < '15:00:00' THEN '09:00 - 15:00'
    WHEN s.start_time >= '15:00:00' AND s.start_time < '18:00:00' THEN '15:00 - 18:00'
    WHEN s.start_time >= '18:00:00' AND s.start_time < '21:00:00' THEN '18:00 - 21:00'
    WHEN s.start_time >= '21:00:00' AND s.start_time <= '23:59:59' THEN '21:00 - 24:00'
  END AS start_period
  FROM cinema.sessions s
JOIN cinema.tickets t ON t.session_id = s.id
JOIN cinema.films f on s.film_id = f.id) q
GROUP BY ROLLUP(start_period)
ORDER BY start_period

