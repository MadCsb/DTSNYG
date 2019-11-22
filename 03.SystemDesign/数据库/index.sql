ALTER TABLE t_sm_commproduct ADD INDEX index_commproduct_productid (F_PRODUCTID);
ALTER TABLE t_sm_goodsprice ADD INDEX index_goodsprice_productid (F_PRODUCTID);
ALTER TABLE t_sm_sellprice ADD INDEX index_sellprice_priceid (F_PRICEID);
ALTER TABLE t_sm_pdctype ADD INDEX index_pdctype_pdctypeid (F_PDCTYPEID);

ALTER TABLE t_sm_goodsprice ADD INDEX index_goodsprice_goodspriceid (F_GOODSPRICEID);
ALTER TABLE t_sm_sellprice ADD INDEX index_sellprice_productid (F_PRODUCTID);
ALTER TABLE t_sm_sellprice ADD INDEX index_sellprice_goodspriceid (F_GOODSPRICEID);

ALTER TABLE t_sm_order ADD INDEX index_order_orderid (F_ORDERID);
ALTER TABLE t_sm_orderlist ADD INDEX index_orderlist_orderlistid (F_ORDERLISTID);
ALTER TABLE t_sm_orderlist ADD INDEX index_orderlist_orderid (F_ORDERID);
ALTER TABLE t_sm_orderback ADD INDEX index_orderlist_orderid (F_ORDERID);
ALTER TABLE t_sm_orderback ADD INDEX index_orderlist_backid (F_BACKID);