

/*Modifier la requête pour fournir la liste du nombre de clients (customer) par ville (city).
 Seules les villes
qui comptent deux clients ou plus doivent être sélectionnées.
N'afficher que les colonnes CITY et CUSTOMER_COUNT dans cet ordre.
Exemple de sortie :*/


SELECT c.city, count(c.customer_id) as CUSTOMER_COUNT
FROM customer c
 group by c.city
 having customer_count>1;



/*******************************/


/*Modifier la requête pour selectionner uniquement les clients (customer)
 n'ayant aucun ordre achat
(purchase_order) associé.
Afficher uniquement la colonne CUSTOMER_ID.*/

SELECT customer_id
 FROM customer c
where customer_id not in (select customer_id from purchase_order )

ou 

SELECT CUSTOMER.customer_id
 FROM CUSTOMER
LEFT JOIN PURCHASE_ORDER
 ON CUSTOMER.customer_id=PURCHASE_ORDER.customer_id
 WHERE PURCHASE_ORDER.customer_id is NULL;



/**********************************/

/*Modifiez la requête pour lister tous les produits(product) et leurs catégories 
associées(product_categorie) s’ils en ont une . Dans le cas contraire 
ne pas afficher de valeur null  pour la categorie 

N'afficher  que les colonnes PRODUCT_NAME et CATEGORY_NAME dans cet ordre.
Exemple de résultat :*/



 SELECT p.name as product_name, pc.name as category_name
FROM product p left join product_category pc on p.product_category_id = pc.
product_category_id





/**************************************/

/*Modifier la requête ci-contre pour lister le nombre de produits (product) disponibles par catégorie de
produits (product_category).
On ne listera pas les catégories de produits ne contenant pas de produit.
N'afficher que les colonnes CATEGORY_NAME (product_category.name) et PRODUCT_COUNT dans cet
ordre.*/


SELECT pc.name as CATEGORY_NAME,count(p.product_category_id) as PRODUCT_COUNT
 FROM product p
 right join product_category pc
 on p.product_category_id = pc.product_category_id
 group by pc.name
having product_count>0;


/*****************/


/*Modifier la requête pour donner la liste des villes (city) des clients (customer). La liste ne doit pas
contenir de doublon et doit être triée par ordre alphabétique.
N'afficher que la colonne CITY.
Exemple de sortie :*/

SELECT DISTINCT  city FROM CUSTOMER  ORDER BY CITY


/*Modifier la requête pour sélectionner uniquement les ids des clients (customer) ayant acheté au moins
un produit dans la catégorie "Books" ou "Garden" (product_category). La sortie ne doit contenir aucun
doublon et doit être triée par ordre croissant.
N'afficher que la colonne CUSTOMER_ID.*/


SELECT distinct c.customer_id
 FROM customer c
 left join purchase_order po
 on c.customer_id =po.customer_id
 left join order_product op
 on po.order_id=op.order_id
 left join product p
 on p.product_id=op.product_id
 left join product_category pc
 on pc.product_category_id=p.product_category_id
 where pc.name in ('Books','Garden')
 order by c.customer_id;

 /**********************************/


 /*Modifier la requête pour selectionner uniquement les clients ayant un code postal (zipcode) égal à
75000 ou 34000 et ayant une date de naissance (birth_date) définie.
N'afficher que colonnes LASTNAME et FIRSTNAME dans cet ordre.
Exemple de sortie*/

 SELECT lastname, firstname
 FROM customer c where c.zipcode in (75000,34000) and birth_date is not null;



 /**********************/

 /*Modifier la requête pour selectionner uniquement les noms et prénoms des clients (customer) dont le
nom commence par la lettre 'W', triés par ordre alphabétique de noms puis de prénoms.
N'afficher que les colonnes LASTNAME et FIRSTNAME dans cet ordre.*/

SELECT lastname,firstname
 FROM customer
 where lastname like ('W%')
 order by lastname, firstname
