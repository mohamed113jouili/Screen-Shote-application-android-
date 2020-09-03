




/***************************List City ***********************************/


SELECT DISTINCT  city FROM CUSTOMER  ORDER BY CITY




/********************HAVINGb city Custmer_Count***********************************/



SELECT  city  ,count(*) as CUSTOMER_COUNT
FROM CUSTOMER
GROUP BY city
HAVING (CUSTOMER_COUNT>1)




/*************************CUSTOMER_ID   SQL - NOT EXISTS***********************************/



SELECT CUSTOMER.customer_id
 FROM CUSTOMER
LEFT JOIN PURCHASE_ORDER
 ON CUSTOMER.customer_id=PURCHASE_ORDER.customer_id
 WHERE PURCHASE_ORDER.customer_id is NULL;



/****************  NOT NULL LASTNAME FIRSTNAME ***********************************/

SELECT
    firstname AS FIRSTNAME,
    lastname AS LASTNAME
FROM
    CUSTOMER
WHERE
    (
        (
            CUSTOMER.zip_code = 75000 OR zip_code = 34000
        ) AND brith_date IS NOT NULL
    )



/***********************LASTNAME FIRSTNAME LIKE****response question 23***********************************/
SELECT
    lastname,
    firstname
FROM
    CUSTOMER
WHERE
    (lastname LIKE 'w%')
ORDER BY
    firstname ASC

SELECT pc.name as CATEGORY_NAME,count(p.product_category_id) as PRODUCT_COUNT
 FROM product p
 right join product_category pc
 on p.product_category_id = pc.product_category_id
 group by pc.name
 having product_count>0;


/**************GROUP BY GATEGORIE_NAME,PRODUCT_COUNT***********************************/

SELECT
    res.PRODUCT_NAME,
    COUNT(*) AS PRODUCT_COUNT
FROM
    (
    SELECT
        PC.name AS PRODUCT_NAME
    FROM
        PRODUCT_CATEGORIE PC
    RIGHT JOIN PRODUCT P ON
        (
            PC.product_categorie_id = P.product_categorie_id
        )
) res
GROUP BY
    res.PRODUCT_NAME




    
/*****/
SELECT pc.name as CATEGORY_NAME,count(p.product_category_id) as PRODUCT_COUNT 3 FROM product p
 right join product_category pc
on p.product_category_id = pc.product_category_id
 group by pc.name
 having product_count>0;







/*************************** Jointur Multiuple  CUSTOMER_ID***********************************/

SELECT res3.CUSTOMER_ID FROM (
SELECT DISTINCT res2.product_categorie_id,res2.CUSTOMER_ID FROM (
SELECT res.CUSTOMER_ID,res.product_id ,PRODUCT.product_categorie_id FROM(
SELECT PURCHASE_ORDER.customer_id as CUSTOMER_ID ,ORDER_PRODUCT.product_id
FROM PURCHASE_ORDER
LEFT JOIN ORDER_PRODUCT
ON (PURCHASE_ORDER.order_id=ORDER_PRODUCT.order_id))res
LEFT JOIN PRODUCT
ON(PRODUCT.product_id=res.product_id))res2
LEFT JOIN PRODUCT_CATEGORIE
ON(PRODUCT_CATEGORIE.product_categorie_id=res2.product_categorie_id)
WHERE(PRODUCT_CATEGORIE.name="Books" OR PRODUCT_CATEGORIE.name="Garden"))res3
ORDER BY res3.CUSTOMER_ID








/**************OUTER JOIN product_name ,category_name ***********/


SELECT p.name AS product_name, p_c.name AS category_name  FROM PRODUCT  p
 INNER JOIN PRODUCT_CATEGORIE p_c
 ON p_c.product_categorie_id=p.product_categorie_id
 WHERE(p_c.name IS NOT NULL)
 UNION ALL
SELECT p.name AS product_name, p_c.name AS category_name  FROM PRODUCT p
 INNER JOIN PRODUCT_CATEGORIE p_c
 ON p_c.product_categorie_id=p.product_categorie_id
  WHERE(p_c.name  IS  NULL)

