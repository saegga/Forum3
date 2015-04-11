SELECT *
FROM users u, posts p, forums f, subjects s
WHERE
  u.id = p.user_id AND
  f.id = s.forum_id
  AND p.subject_id = s.id AND
  s.id = 1;

