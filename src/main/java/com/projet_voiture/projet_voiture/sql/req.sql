SELECT a FROM Annonce a INNER JOIN a.validations val WHERE val.etat =  1 AND EXISTS (SELECT f.annonce FROM Favori f) GROUP BY a ORDER BY COUNT(f) DESC

SELECT a.*
FROM Annonce a
INNER JOIN Validation val ON a.idannonce = val.idannonce -- Assuming 'id' is the primary key of Annonce
WHERE val.etat =  1
AND EXISTS (
    SELECT  1
    FROM Favori f
    WHERE f.idannonce = a.idannonce -- Assuming 'idannonce' is the foreign key in Favori referencing Annonce
)
GROUP BY a.idannonce
ORDER BY COUNT(val) DESC;
