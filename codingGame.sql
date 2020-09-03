




/***************************response question 17***********************************/


SELECT DISTINCT  city FROM CUSTOMER  ORDER BY CITY




/***************************response question 18***********************************/



SELECT  city  ,count(*) as CUSTOMER_COUNT
FROM CUSTOMER
GROUP BY city
HAVING (CUSTOMER_COUNT>)


/***************************response question 21***********************************/

SELECT
    CUSTOMER.customer_id
FROM
    CUSTOMER
LEFT JOIN PURCHASE_ORDER ON(
        CUSTOMER.customer_id = PURCHASE_ORDER.customer_id
    )
WHERE NOT EXISTS
    (
    SELECT
        ORDER_PRODUCT.order_id
    FROM
        ORDER_PRODUCT
    WHERE
        (
            ORDER_PRODUCT.order_id = PURCHASE_ORDER.order_id
        )
)
/***other response*/

SELECT c.customer_id
 FROM customer c
 left join purchase_order po
 on c.customer_id=po.customer_id
 where po.customer_id is null;



/***************************response question 22***********************************/

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



/***************************response question 23***********************************/
SELECT
    lastname,
    firstname
FROM
    CUSTOMER
WHERE
    (lastname LIKE 'w%')
ORDER BY
    firstname ASC




/***************************response question 19 kais ***********************************/

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


/***************************question 20 Jointur Multiuple  kais***********************************/



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




